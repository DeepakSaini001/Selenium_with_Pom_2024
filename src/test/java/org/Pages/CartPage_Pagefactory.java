package org.Pages;

import org.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage_Pagefactory extends BasePage {

//	private final By ProductName=By.xpath("//td[@class='product-name'] //a[contains(text(),'Blue Shoes')]");
//	private final By CheckOutButton=By.xpath("//a[@class='checkout-button button alt wc-forward']");

	@FindBy(xpath = "//td[@class='product-name'] //a[contains(text(),'Blue Shoes')]")
	private WebElement ProductName;

	@FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
	private WebElement CheckOutButton;

	public CartPage_Pagefactory(WebDriver driver) {
		super(driver);
	}

	public String getProductName() {
		return wait.until(ExpectedConditions.visibilityOf(ProductName)).getText();
		// return driver.findElement(ProductName).getText();

	}

	public CheckOutPage ClickCheckOutButton() {
		wait.until(ExpectedConditions.elementToBeClickable(CheckOutButton)).click();
		// driver.findElement(CheckOutButton).click();
		return new CheckOutPage(driver);
	}
}
