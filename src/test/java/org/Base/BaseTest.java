package org.Base;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.Factory.DriverManagerAPI;
import org.Factory.DriverManagerFactory;
import org.Factory.DriverManagerOriginal;
import org.abstractFactory.DriverManagerFactoryAbstract;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.utils.CookieUtils;

import constants.DriverType;
import io.restassured.http.Cookies;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

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

	@Parameters("browser")
	@BeforeMethod
	public void StartDriver(@Optional String browser) {

		System.out.println("Browser parameter is derived from TestNG using Annotation Parameter" + " : " + browser);
		System.out.println("If run individual test, then browser will give null value and it is expected because we are"
				+ " deriving the browser value from testng annotaion Parameter");
		System.out.println("If run through TestNG, then remove these hardcoded brower value from BaseTest");
		System.out.println("If run through Individual Test, then add these hardcoded brower value from BaseTest");

		browser = System.getProperty("broswer", browser);

		if (browser == null) {
			browser = "CHROME";
		} else
			throw new NullPointerException("Browser parameter is null" + " : " + browser);

		// setDriver(new DriverManagerOriginal().InitilizeDriver(browser));
		// setDriver(new DriverManagerAPI().InitilizeDriver());
		// below one is used Interface
		setDriver(DriverManagerFactory.getManager(DriverType.valueOf(browser)).createDriver());
		// below one is used Abstraction
		// setDriver(DriverManagerFactoryAbstract.getManager(DriverType.valueOf(browser)).getDriver());
		System.out.println("Current thread" + Thread.currentThread().getId() + ", " + "Driver" + getDriver());

	}

	@Parameters("browser")
	@AfterMethod
	public void quitDriver(@Optional String browser, ITestResult result) throws IOException {
		System.out.println("Current thread" + Thread.currentThread().getId() + ", " + "Driver" + getDriver());
		if (result.getStatus() == ITestResult.FAILURE) {

			File destinationFile = new File("ScreenShot" + File.separator + browser + File.separator
					+ result.getTestClass().getRealClass().getSimpleName() + "_" + result.getMethod().getMethodName()
					+ ".png");
			takeScreenshot(destinationFile);
			 takeScreenshotUsingAShot(destinationFile);
		}
		getDriver().quit();

	}

	public void injectCookiesToBrowser(Cookies cookies) {
		List<Cookie> seleniumCookies = new CookieUtils().convertRestAssuredCookiesToSeleniumCookies(cookies);
		for (Cookie cookie : seleniumCookies) {
			System.out.println(cookie.toString());
			getDriver().manage().addCookie(cookie);
		}
	}

	private void takeScreenshot(File destinationFile) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, destinationFile);
	}

	private void takeScreenshotUsingAShot(File destinationFile) {
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100))
				.takeScreenshot(getDriver());
		try {
			ImageIO.write(screenshot.getImage(), "PNG", destinationFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
