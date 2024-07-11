package Junk_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

public class dynamic_WebElement {
	@Test
	public static void Handle_Dynamic_WebElements() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/deepaksaini/Downloads/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://askomdch.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'Store')]")).click();
		WebElement referenceElement = driver.findElement(By.xpath("//a[contains(text(),'Find More')]"));
		WebElement targetElement = driver.findElement(RelativeLocator.with(By.tagName("a")).toLeftOf(referenceElement));
		targetElement.click();
		
	}
}
