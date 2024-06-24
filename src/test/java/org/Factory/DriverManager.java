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

	/*
	 * public WebDriver InitilizeDriver() { WebDriver driver; String browser =
	 * System.getProperty("browser"); switch (browser) { case "Chrome":
	 * WebDriverManager.chromedriver().cachePath("Drivers").setup(); driver = new
	 * ChromeDriver(); break; case "Firefox":
	 * WebDriverManager.firefoxdriver().cachePath("Drivers").setup(); driver = new
	 * FirefoxDriver(); break; default: throw new
	 * IllegalStateException("invalid browser name " + browser); }
	 * 
	 * driver.manage().window().maximize(); //
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); return
	 * driver; }
	 */
}

/*
 * Why we are creating a extra class as DriverManager? what is the purpose of
 * creating this class and doing driver initialization inside it if we can do
 * the driver initialization in BaseTest class.
 * 
 * Answer-- The reason is to abstract driver initialization logic. This also
 * follows the Single Responsibility Principle (SRP) that says, a class should
 * ideally have only one reason to change. If I keep drive initialization in the
 * BaseTest class, this class will be doing two things i.e. driver
 * initialization as well as test setup (@Before* and @After* annotated
 * methods). This would violate SRP. Now, over time, the driver initialization
 * logic can get complex with multiple browsers, with each browser having their
 * own initialization logics (browser options, etc.). If I put all this logic in
 * one class, it can make the class bulky. Also, the class will be doing
 * multiple things and it will have multiple reasons to change for e.g. a change
 * in Chrome browser's options, a change in Firefox browser's options, etc. Now
 * imagine one person is working on updating Chrome browser's options and
 * another person is working on updating Firefox browser's options. Now both of
 * them will be updating the same class and this may result in conflicts (during
 * check-in). Additionally, a change in Chrome browser's option would mean the
 * entire class will need to be tested even if Firefox options is not changed.
 * If I were to put Chrome browser's option in a different class, I would be
 * changing only that class and validating the change by running just the Chrome
 * tests. I will not have to run the Firefox tests.
 */