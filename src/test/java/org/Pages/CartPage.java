package org.Pages;

import org.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{
	
	private final By ProductName=By.xpath("//td[@class='product-name'] //a[contains(text(),'Blue Shoes')]");
	private final By CheckOutButton=By.xpath("//a[@class='checkout-button button alt wc-forward']");
			
			
	public CartPage(WebDriver driver) {
		super(driver);
			}

	public String getProductName () {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(ProductName)).getText();
	//	return	driver.findElement(ProductName).getText();
		
	}
	public CheckOutPage ClickCheckOutButton() {
		wait.until(ExpectedConditions.elementToBeClickable(CheckOutButton)).click();
		//driver.findElement(CheckOutButton).click();
		return new CheckOutPage(driver);
	}
}
