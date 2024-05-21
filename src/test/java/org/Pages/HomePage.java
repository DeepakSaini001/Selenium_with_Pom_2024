package org.Pages;

import java.time.Duration;

import org.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

	private final By StoreMenuLink = By.xpath("//a[contains(text(),'Store')]");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public HomePage load() {
		load("/");
		wait.until(ExpectedConditions.titleContains("AskOmDch"));
		return this;
	}

	public StorePage navigatetoStoreUsingMenu() {
		wait.until(ExpectedConditions.elementToBeClickable(StoreMenuLink)).click();
	//	driver.findElement(StoreMenuLink).click();
		return new StorePage(driver);

	}

}
/*
 * why here we select the storePage as the return type?
 * 
 * 
 * Answer-- it is for good automation practice and this is called as ""fluent
 * interface"". if we look as the UI flow perceptive that we have landed on the
 * HomePage and in second method we used navigatetoStoreUsingMenu then we have
 * landed to the StorePage. so when we are navigating to new page from current
 * page then we need to written the object of that new page. so in above, we are
 * navigating to the store page that's why it is mentioned the return type of
 * StorePage. also, we have passed the driver-- so that driver life also there
 * in StorePage.
 * 
 * Question- if we are still on the current page and don't want to go to other
 * page then what to do?
 * 
 * Answer-- use Builder Pattern.
 */
