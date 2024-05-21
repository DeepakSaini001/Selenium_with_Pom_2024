package org.Base;

import org.Factory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	protected WebDriver driver;
	
	
	
	@BeforeMethod
	public void StartDriver() {
		driver=new DriverManager().InitilizeDriver();
		
	}
	@AfterMethod
	public void quitDriver() {
		driver.quit();
		
	}

}
