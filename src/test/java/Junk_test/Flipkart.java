package Junk_test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Flipkart {
	@Test(priority = 0)
	public void Flipakrt() {
		System.setProperty("webdriver.chrome.driver", "/Users/deepaksaini/Downloads/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		
		//driver.findElement(By.xpath("//a[@title='Login']")).click();
		driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("Iphone");


		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Fashion')]")));

	//	driver.findElement(By.xpath("//span[contains(text(),'Fashion')] //a[contains(text(),'Men Footwear')]")).click();
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Fashion')]"))).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'Men Footwear')]")).click();

	}
}