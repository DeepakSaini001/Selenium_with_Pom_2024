package org.Pages;

import org.Base.BasePage;
import org.Objects.BillingAddress;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends BasePage {
	private final By title = By.xpath("//h1[contains(text(),'Checkout')]");
	private final By FirstNameField = By.xpath("//input[@name='billing_first_name']");
	private final By LastNameField = By.xpath("//input[@name='billing_last_name']");

	private final By CountryDropDown = By.xpath("//span[@id='select2-billing_country-container']");
	private final By SearchCountry = By.xpath("//input[@class='select2-search__field']");
	private final By SelectCountry = By.xpath("//li[contains(text(),'United States (US)')] [1]");
	private final By Country_SelectClass = By.xpath("//select[@id='billing_country']");

	private final By StreetAddress01Field = By.xpath("//input[@id='billing_address_1']");
	private final By StreetAddress02Field = By.xpath("//input[@id='billing_address_2']");
	private final By TownField = By.xpath("//input[@id='billing_city']");

	private final By State_dropdown = By.xpath("//select[@id='billing_state']");
	private final By StateDropDown = By.xpath("//span[@id='select2-billing_state-container']");
	private final By SearchState = By.xpath("//input[@role='combobox']");
	private final By SelectState = By.xpath("//li[contains(text(),'California')]");

	private final By ZipCodeField = By.xpath("//input[@id='billing_postcode']");
	private final By EmailIDField = By.xpath("//input[@id='billing_email']");

	private final By overlay = By.cssSelector(".blockUI.blockOverlay");

	private final By PalceOrder = By.xpath("//button[@id='place_order']");
	private final By OrderSuccess = By
			.xpath("//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']");

	private final By ClickHereToLoginlink = By.xpath("//a[@class='showlogin']");
	private final By UserNamefield = By.xpath("//input[@id='username']");
	private final By Passwordfield = By.xpath("//input[@id='password']");
	private final By LoginButton = By.xpath("//button[@value='Login']");

	private final By DirectbankTransferRadioButton = By.xpath("//input[@id='payment_method_bacs']");

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}

	public String getTitle() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
		// return driver.findElement(title).getText();
	}

	public CheckOutPage ClickhereToLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(ClickHereToLoginlink)).click();
		// driver.findElement(ClickHereToLoginlink).click();
		return this;
	}

	public CheckOutPage enterUserName(String username) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(UserNamefield)).sendKeys(username);
		// driver.findElement(UserNamefield).sendKeys(username);
		return this;
	}

	public CheckOutPage enterPassword(String passowrd) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Passwordfield)).sendKeys(passowrd);
		// driver.findElement(Passwordfield).sendKeys(passowrd);
		return this;
	}

	public CheckOutPage ClickLoginButton() {
		wait.until(ExpectedConditions.elementToBeClickable(LoginButton)).click();
		// driver.findElement(LoginButton).click();
		return this;
	}

	public CheckOutPage enterFirstName(String firstName) {
		WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(FirstNameField));
		// or
		WebElement b = waitForElementToBeVisible(FirstNameField);
		e.clear();
		e.sendKeys(firstName);
		// driver.findElement(FirstNameField).clear();
		// driver.findElement(FirstNameField).sendKeys(firstName);

		return this;
	}

	public CheckOutPage enterlastName(String lastName) {
		WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(LastNameField));
		e.clear();
		e.sendKeys(lastName);

		// driver.findElement(LastNameField).clear();
		// driver.findElement(LastNameField).sendKeys(lastName);
		return this;
	}

	public CheckOutPage CountryUsingSelectClass(String countryName) {
		Select dropdown = new Select(driver.findElement(Country_SelectClass));
		dropdown.selectByVisibleText(countryName);

		return this;

	}

	public CheckOutPage ClickCountryDropDown() {
		wait.until(ExpectedConditions.elementToBeClickable(CountryDropDown)).click();
		// driver.findElement(CountryButton).click();
		return this;
	}

	public CheckOutPage enterTextSearchCountry(String countryName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SearchCountry)).sendKeys(countryName);

		// driver.findElement(CountryField).sendKeys(countryName);
		return this;
	}

	public CheckOutPage getCountryNameSelect() {
		wait.until(ExpectedConditions.elementToBeClickable(SelectCountry)).click();
		// driver.findElement(SelectCountry).click();
		return this;
	}

	public CheckOutPage StateUsingSelectClass(String stateName) {
		Select dropdown = new Select(driver.findElement(State_dropdown));
		dropdown.selectByVisibleText(stateName);
		return this;
	}

	public CheckOutPage ClickStateDropDown() {
		wait.until(ExpectedConditions.elementToBeClickable(StateDropDown)).click();
		// driver.findElement(StateButton).click();
		return this;
	}

	public CheckOutPage enterTextSearchState(String stateName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(SearchState)).sendKeys(stateName);
		// driver.findElement(StateField).sendKeys(stateName);
		return this;
	}

	public CheckOutPage getStateNameSelect() {
		wait.until(ExpectedConditions.elementToBeClickable(SelectState)).click();
		// driver.findElement(SelectState).click();
		return this;
	}

	public CheckOutPage enterStreetAddress01(String streetAddress01) {
		WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(StreetAddress01Field));
		e.clear();
		e.sendKeys(streetAddress01);
		// driver.findElement(StreetAddress01Field).clear();
		// driver.findElement(StreetAddress01Field).sendKeys(streetAddress01);
		return this;
	}

	public CheckOutPage enterStreetAddress02(String streetAddress02) {
		WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(StreetAddress02Field));
		e.clear();
		e.sendKeys(streetAddress02);
		// driver.findElement(StreetAddress02Field).clear();
		// driver.findElement(StreetAddress02Field).sendKeys(streetAddress02);
		return this;
	}

	public CheckOutPage enterTown(String town) {
		WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(TownField));
		e.clear();
		e.sendKeys(town);
		// driver.findElement(TownField).clear();
		// driver.findElement(TownField).sendKeys(town);
		return this;
	}

	public CheckOutPage enterZipCode(String zipCode) {
		WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(ZipCodeField));
		e.clear();
		e.sendKeys(zipCode);
		// driver.findElement(ZipCodeField).clear();
		// driver.findElement(ZipCodeField).sendKeys(zipCode);
		return this;
	}

	public CheckOutPage enterEmailID(String emailID) {
		WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(EmailIDField));
		e.clear();
		e.sendKeys(emailID);
		// driver.findElement(EmailIDField).clear();
		// driver.findElement(EmailIDField).sendKeys(emailID);
		return this;
	}

	public CheckOutPage setBillingAddress(BillingAddress billingAddress) {
		return enterFirstName(billingAddress.getFirstName()).enterlastName(billingAddress.getLastName())
				.CountryUsingSelectClass(billingAddress.getCountry())
				.enterStreetAddress01(billingAddress.getStreetAddress01())
				.enterStreetAddress02(billingAddress.getStreetAddress02()).enterTown(billingAddress.getTown())
				.StateUsingSelectClass(billingAddress.getState()).enterZipCode(billingAddress.getZipCode())
				.enterEmailID(billingAddress.getEmailID());
	}

	public CheckOutPage clickPlaceOrder() {
		waitForOverlaysToDisappear(overlay);
		wait.until(ExpectedConditions.elementToBeClickable(PalceOrder)).click();
		// driver.findElement(PalceOrder).click();
		return this;

	}

	public String getNotice() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(OrderSuccess)).getText();
		// return driver.findElement(OrderSuccess).getText();
	}

	public CheckOutPage login(String username, String password) {
		return enterUserName(username).enterPassword(password).ClickLoginButton();
	}

	public CheckOutPage SelectDirectBankTransfer() {
		WebElement e = wait.until(ExpectedConditions.elementToBeClickable(DirectbankTransferRadioButton));
		if (!e.isSelected()) {
			e.click();
		}
		return this;
	}

}
