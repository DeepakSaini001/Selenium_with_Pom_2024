package test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstCase_original {

	// class name start with capital letter
	// method name start with lower letter

	@Test(priority = 0)
	public void guestCheckoutUsingBankTransfer() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/deepaksaini/Downloads/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://askomdch.com/");
		driver.manage().window().maximize();
		WebElement Store = driver.findElement(By.xpath("//a[contains(text(),'Store')]"));
		Store.click();

		WebElement SearchBox = driver.findElement(By.xpath("//input[@type='search']"));
		SearchBox.sendKeys("Blue");

		driver.findElement(By.xpath("//button[@value='Search']")).click();
		AssertJUnit.assertEquals(
				driver.findElement(By.xpath("//h1[@class='woocommerce-products-header__title page-title']")).getText(),
				"Search results: “Blue”");
		driver.findElement(By.xpath("//a[@aria-label='Add “Blue Shoes” to your cart']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='View cart']")));
		AssertJUnit.assertEquals(driver.findElement(By.xpath("//a[@title='View cart']")).getText(), "View cart");
		driver.findElement(By.xpath("//a[@title='View cart']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//td[@class='product-name'] //a[contains(text(),'Blue Shoes')]")));
		AssertJUnit.assertEquals(driver
				.findElement(By.xpath("//td[@class='product-name'] //a[contains(text(),'Blue Shoes')]")).getText(),
				"Blue Shoes");
		WebElement ProceedTOCheckOut = driver
				.findElement(By.xpath("//a[@class='checkout-button button alt wc-forward']"));
		ProceedTOCheckOut.click();

		AssertJUnit.assertEquals(driver.findElement(By.xpath("//h1[contains(text(),'Checkout')]")).getText(), "Checkout");
		driver.findElement(By.xpath("//input[@name='billing_first_name']")).sendKeys("Deepak");
		driver.findElement(By.xpath("//input[@name='billing_last_name']")).sendKeys("Saini");
		driver.findElement(By.xpath("//span[@id='select2-billing_country-container']")).click();
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("United States (US)");

		driver.findElement(By.xpath("//li[contains(text(),'United States (US)')] [1]")).click();
		driver.findElement(By.xpath("//input[@id='billing_address_1']")).sendKeys("Kurukshetra");

		driver.findElement(By.xpath("//input[@id='billing_address_2']")).sendKeys("Haryana");
		driver.findElement(By.xpath("//input[@id='billing_city']")).sendKeys("Kurukshetra");
		driver.findElement(By.xpath("//span[@id='select2-billing_state-container']")).click();
		driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("California");
		driver.findElement(By.xpath("//li[contains(text(),'California')]")).click();
		driver.findElement(By.xpath("//input[@id='billing_postcode']")).sendKeys("00012");

		driver.findElement(By.xpath("//input[@id='billing_email']")).sendKeys("Deepak.saini2106@gmail.com");
		driver.findElement(By.xpath("//button[@id='place_order']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']")));
		AssertJUnit.assertEquals(driver.findElement(By.xpath(
				"//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']"))
				.getText(), "Thank you. Your order has been received.");
		driver.quit();

	}

	@Test(priority = 1)
	public void LoginAndCheckOut_guestCheckoutUsingBankTransfer() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/deepaksaini/Downloads/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://askomdch.com/");
		driver.manage().window().maximize();
		WebElement Store = driver.findElement(By.xpath("//a[contains(text(),'Store')]"));
		Store.click();

		WebElement SearchBox = driver.findElement(By.xpath("//input[@type='search']"));
		SearchBox.sendKeys("Blue");

		driver.findElement(By.xpath("//button[@value='Search']")).click();
		AssertJUnit.assertEquals(
				driver.findElement(By.xpath("//h1[@class='woocommerce-products-header__title page-title']")).getText(),
				"Search results: “Blue”");
		driver.findElement(By.xpath("//a[@aria-label='Add “Blue Shoes” to your cart']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='View cart']")));
		AssertJUnit.assertEquals(driver.findElement(By.xpath("//a[@title='View cart']")).getText(), "View cart");
		driver.findElement(By.xpath("//a[@title='View cart']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//td[@class='product-name'] //a[contains(text(),'Blue Shoes')]")));
		AssertJUnit.assertEquals(driver
				.findElement(By.xpath("//td[@class='product-name'] //a[contains(text(),'Blue Shoes')]")).getText(),
				"Blue Shoes");
		WebElement ProceedTOCheckOut = driver
				.findElement(By.xpath("//a[@class='checkout-button button alt wc-forward']"));
		ProceedTOCheckOut.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Checkout')]")));
		AssertJUnit.assertEquals(driver.findElement(By.xpath("//h1[contains(text(),'Checkout')]")).getText(), "Checkout");
		driver.findElement(By.xpath("//a[@class='showlogin']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']")));

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("user1");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("user1");
		driver.findElement(By.xpath("//button[@value='Login']")).click();
		driver.findElement(By.xpath("//input[@name='billing_first_name']")).sendKeys("Deepak");
		driver.findElement(By.xpath("//input[@name='billing_last_name']")).sendKeys("Saini");
		driver.findElement(By.xpath("//span[@id='select2-billing_country-container']")).click();
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("United States (US)");

		driver.findElement(By.xpath("//li[contains(text(),'United States (US)')] [1]")).click();
		driver.findElement(By.xpath("//input[@id='billing_address_1']")).sendKeys("Kurukshetra");

		driver.findElement(By.xpath("//input[@id='billing_address_2']")).sendKeys("Haryana");
		driver.findElement(By.xpath("//input[@id='billing_city']")).sendKeys("Kurukshetra");
		driver.findElement(By.xpath("//span[@id='select2-billing_state-container']")).click();
		driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("California");
		driver.findElement(By.xpath("//li[contains(text(),'California')]")).click();
		driver.findElement(By.xpath("//input[@id='billing_postcode']")).sendKeys("00012");
		driver.findElement(By.xpath("//input[@id='billing_email']")).clear();
		driver.findElement(By.xpath("//input[@id='billing_email']")).sendKeys("Deepak.saini2106@gmail.com");
		driver.findElement(By.xpath("//button[@id='place_order']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']")));
		AssertJUnit.assertEquals(driver.findElement(By.xpath(
				"//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']"))
				.getText(), "Thank you. Your order has been received.");
		driver.quit();

	}
	

}
