package org.Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager implements DriverManager {

	@Override
	public WebDriver createDriver() {
		WebDriverManager.chromedriver().cachePath("Drivers").setup();
		WebDriver driver = new ChromeDriver(); // local driver object
		driver.manage().window().maximize();
		return driver;

	}

}