package org.Pages;

import org.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MenPage extends BasePage {
	private final By SearchField = By.xpath("//input[@type='search']");
	private final By SearchButton = By.xpath("//button[@value='Search']");
	private final By title = By.xpath("//h1[@class='woocommerce-products-header__title page-title']");
	private final By ViewCartButton = By.xpath("//a[@title='View cart']");

	public MenPage(WebDriver driver) {
		super(driver);
	}

	public MenPage enterTextSearchField(String searchText) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SearchField)).sendKeys(searchText);
		return this;
	}

	public MenPage clickSearchButton() {
		wait.until(ExpectedConditions.elementToBeClickable(SearchButton)).click();
		return this;
	}

	public String verifySearchTitle() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();

	}

	private By getAddToCartButton(String ProductName) {
		return By.xpath("//a[@aria-label='Add “" + ProductName + "” to your cart']");
	}

	public MenPage clickAddToCartButton(String ProductName) {
		By AddToCartButton = getAddToCartButton(ProductName);
		wait.until(ExpectedConditions.elementToBeClickable(AddToCartButton)).click();
		return this;
	}

	public CartPage VerifyViewCartButton() {
		wait.until(ExpectedConditions.elementToBeClickable(ViewCartButton)).click();
		return new CartPage(driver);

	}

}
