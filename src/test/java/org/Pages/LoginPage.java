package org.Pages;

import org.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

	private final By verifyTitle = By.xpath("//h1[contains(text(),'Account')]");
	private final By UserNamefield = By.xpath("//input[@id='username']");
	private final By Passwordfield = By.xpath("//input[@id='password']");
	private final By LoginButton = By.xpath("//button[@name='login']");
	private final By MenMenuLink=By.xpath("//li[@id='menu-item-1228']");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public String verifyAccountTitle() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(verifyTitle)).getText();
	}

	public LoginPage enterUserName(String username) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(UserNamefield)).sendKeys(username);
		return this;
	}

	public LoginPage enterPassword(String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Passwordfield)).sendKeys(password);
		return this;
	}

	public SuccessfulLoginPage clickLoginButton() {
		wait.until(ExpectedConditions.elementToBeClickable(LoginButton)).click();
		return new SuccessfulLoginPage(driver);
	}
	public MenPage navigateToMenUsingMenu() {
		wait.until(ExpectedConditions.elementToBeClickable(MenMenuLink)).click();
		return new MenPage(driver);
	}

}
