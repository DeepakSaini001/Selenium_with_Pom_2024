package Junk_test;

import java.time.Duration;
import java.util.List;

import org.Base.BaseTest;
import org.Pages.CartPage;
import org.Pages.HomePage;
import org.Pages.LoginPage;
import org.Pages.MenPage;
import org.Pages.SuccessfulLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import constants.Constants_data;

public class check_withList {
	@Test
	public static void hi() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/deepaksaini/Downloads/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://askomdch.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'Store')]")).click();
		// driver.findElement(By.xpath("//button[@value='Search']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[@aria-label='Add “Blue Shoes” to your cart']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[@aria-label='Add “Basic Blue Jeans” to your cart']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[@aria-label='Add “Anchor Bracelet” to your cart']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='View cart']")));
		Assert.assertEquals(driver.findElement(By.xpath("//a[@title='View cart']")).getText(), "View cart");
		driver.findElement(By.xpath("//a[@title='View cart']")).click();

		int rowCount = driver
				.findElements(By.xpath(
						"//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents'] //tr"))
				.size();
		int colCount = driver
				.findElements(By.xpath(
						"//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents'] //th"))
				.size();
		System.out.println("total row" + " =  " + rowCount);
		System.out.println("total Coloumn" + " = " + colCount);

		for (int i = 1; i < rowCount - 1; i++) {
			{
				List<WebElement> ProductName = driver.findElements(By.xpath(
						"//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents'] //tr["
								+ (i) + "] //td[3]"));
		driver.quit();
	}
}}}
