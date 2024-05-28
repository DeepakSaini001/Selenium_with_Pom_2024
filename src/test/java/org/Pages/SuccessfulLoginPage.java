package org.Pages;

import org.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SuccessfulLoginPage extends BasePage {

	 private final By LoggedIn=By.xpath("//a[contains(text(),'Dashboard')]");
	//private final By LoggedIn = By.xpath("div[id='content'] strong:nth-child(1)");

	public SuccessfulLoginPage(WebDriver driver) {
		super(driver);
	}

	public String verifyUserLoggedIn() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(LoggedIn)).getText();
	}
	

}
