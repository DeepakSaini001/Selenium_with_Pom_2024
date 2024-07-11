package org.Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import constants.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManagerOriginal_WithoutParameter {

	public WebDriver InitilizeDriver() {

		WebDriver driver;
		String browser=System.getProperty("browser"+"CHROME");
	//	String localbrowser=System.getProperty("browser"+browser);
		switch (DriverType.valueOf(browser)) {
		case CHROME -> {
			WebDriverManager.chromedriver().cachePath("Drivers").setup();
			driver = new ChromeDriver();
		}
		case FIREFOX -> {
			WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
			driver = new FirefoxDriver();
		}
		default -> throw new IllegalStateException("Invalid browser name: " + browser);
		}
		driver.manage().window().maximize();
//	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return driver;
	}

}
