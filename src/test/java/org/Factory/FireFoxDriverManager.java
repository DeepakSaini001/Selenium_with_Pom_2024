package org.Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FireFoxDriverManager implements DriverManager {
	

	@Override
	public WebDriver createDriver() {
		WebDriverManager.chromedriver().cachePath("Drivers").setup();
		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();
		return driver;

	}

	

}
