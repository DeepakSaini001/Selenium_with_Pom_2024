package test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class currentURL {
	@Test
	public static void OpenNewWindowTest() {

		System.setProperty("webdriver.chrome.driver", "/Users/deepaksaini/Downloads/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

		((JavascriptExecutor) driver).executeScript("window.open('https://www.facebook.com/','_blank');");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		((JavascriptExecutor) driver).executeScript("window.open('https://www.flipkart.com/','_blank');");
		((JavascriptExecutor) driver).executeScript("window.open('https://www.myntra.com/','_blank');");
		wait.until(ExpectedConditions.numberOfWindowsToBe(4));
		Set<String> windows = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<String>(windows); // this will store all the open tabs name

		System.out.println("this is all tabs "+ " : " + tabs);
		System.out.println(driver.getCurrentUrl() + " : " + driver.getTitle());

	}

}
