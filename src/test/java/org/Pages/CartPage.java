package org.Pages;

import java.util.List;

import org.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import constants.Constants_data;

public class CartPage extends BasePage {

	private final By ProductName = By.xpath("//td[@class='product-name'] //a[contains(text(),'Blue Shoes')]");
	// private final By ProductName=By.xpath("//td[@class='product-name']
	// //a[contains(text(),'Blue Shoes')]");
	private final By CheckOutButton = By.xpath("//a[@class='checkout-button button alt wc-forward']");
	private final By TotalRow = By
			.xpath("//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents'] //tr");
	private final By TotalColumn = By
			.xpath("//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents'] //th");

	public CartPage(WebDriver driver) {
		super(driver);
	}

	public String getProductName() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(ProductName)).getText();
		// return driver.findElement(ProductName).getText();

	}
	

	public CheckOutPage ClickCheckOutButton() {
		wait.until(ExpectedConditions.elementToBeClickable(CheckOutButton)).click();
		// driver.findElement(CheckOutButton).click();
		return new CheckOutPage(driver);
	}

	public CartPage dynamicProductTable( ) {

		int rowCount = driver.findElements(TotalRow).size();
		int colCount = driver.findElements(TotalColumn).size();
		for (int i = 1; i < rowCount - 1; i++) {
			{
				String	 productName = driver.findElement(By.xpath(
						"//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents'] //tr["
								+ (i) + "] //td[3]")).getText();

				System.out.println(productName);
			}
		}
		return this;
	}
}
