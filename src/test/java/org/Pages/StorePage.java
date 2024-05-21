package org.Pages;

import org.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePage extends BasePage {

	private final By SearchField = By.xpath("//input[@type='search']");
	private final By SearchButton = By.xpath("//button[@value='Search']");
	private final By title = By.xpath("//h1[@class='woocommerce-products-header__title page-title']");
	// private final By AddToCartButton = By.xpath("//a[@aria-label='Add “Blue
	// Shoes” to your cart']");
	private final By ViewCartButton = By.xpath("//a[@title='View cart']");

	public StorePage(WebDriver driver) {
		super(driver);
	}

	public StorePage enterTextSearchField(String txt) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SearchField)).sendKeys(txt);
		// driver.findElement(SearchField).sendKeys(txt);
		return this;
	}

	public StorePage clickSearchButton() {
		wait.until(ExpectedConditions.elementToBeClickable(SearchButton)).click();
		// driver.findElement(SearchButton).click();
		return this;
	}

	public String getTitle() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();

		// return driver.findElement(title).getText();
	}

	private By getAddToCartButton(String ProductName) {
		return By.xpath("//a[@aria-label='Add “" + ProductName + "” to your cart']");
	}

	public StorePage clickAddToCartButton(String ProductName) {
		By AddToCartButton = getAddToCartButton(ProductName);
		wait.until(ExpectedConditions.elementToBeClickable(AddToCartButton)).click();
	//	driver.findElement(AddToCartButton).click();
		return this;
	}

	public CartPage VerifyViewCartButton() {
		wait.until(ExpectedConditions.elementToBeClickable(ViewCartButton)).click();
		// driver.findElement(ViewCartButton).click();
		return new CartPage(driver);

	}
}
