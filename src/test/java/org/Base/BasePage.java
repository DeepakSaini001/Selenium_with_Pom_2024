package org.Base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected WebDriverWait waitLong;
	protected WebDriverWait waitShort;
	// private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	// below method is example of parameterized constructor
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		waitLong = new WebDriverWait(driver, Duration.ofSeconds(15)); // this wait object can be used furhter in each
																		// page
																		// object class
		waitShort = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	public void load(String endPoint) {
		driver.get("https://askomdch.com/" + endPoint);
	}

	public void waitForOverlaysToDisappear(By overlay) {
		List<WebElement> overlays = driver.findElements(overlay);
		System.out.println("OVERLAY SIZE" + "==" + overlays.size());
		if (overlays.size() > 0) {
			wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
			System.out.println("OVERLAYS INVISIBLE");
		} else {
			System.out.println("OVERLAY NOT FOUND");
		}
	}

	public WebElement waitForElementToBeVisible(By element) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

}
