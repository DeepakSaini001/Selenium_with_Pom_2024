package org.Factory;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	public WebDriver InitilizeDriver() throws IOException {

		WebDriverManager.chromedriver().cachePath("Drivers").setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		return driver;
	}

}
