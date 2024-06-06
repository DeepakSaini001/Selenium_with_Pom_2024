package org.Base;

import java.io.IOException;

import org.Factory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	


	private void setDriver(WebDriver driver) {
		this.driver.set(driver);
	}

	protected WebDriver getDriver() {
		return this.driver.get();
	}

	@BeforeMethod
	public void StartDriver() throws IOException {
		setDriver(new DriverManager().InitilizeDriver());
		System.out.println("Current thread" + Thread.currentThread().getId() + ", " + "Driver" + getDriver());

	}

	@AfterMethod
	public void quitDriver() {
		System.out.println("Current thread" + Thread.currentThread().getId() + ", " + "Driver" + getDriver());
		getDriver().quit();

	}

}
