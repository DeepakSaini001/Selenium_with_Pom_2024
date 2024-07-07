package org.Base;

import java.io.IOException;

import org.Factory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	// ThreadLocal class have 2 methods--- 1 is set and 1 is get
	// set means to initialize the web driver value
	// get means to get the ThreadLocal value of that particular driver

	private void setDriver(WebDriver driver) {
		this.driver.set(driver);
	}

	protected WebDriver getDriver() { // protected ---because it will only be visible to its parent/child class only
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
