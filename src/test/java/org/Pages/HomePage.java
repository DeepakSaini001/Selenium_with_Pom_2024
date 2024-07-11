package org.Pages;

import org.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.pages.components.MyHeader;
import org.selenium.pom.pages.components.ProductThumbnail;


public class HomePage extends BasePage {

	private final By StoreMenuLink = By.xpath("//a[contains(text(),'Store')]");
	private final By MenMenuLink = By.xpath("//li[@id='menu-item-1228']");
	private final By Account = By.xpath("//li[@id='menu-item-1237']");
	private MyHeader myHeader;
	private ProductThumbnail productThumbnail;

	/*
	 * we need to create new instances of over MyHeader and Porductthumbnail of
	 * these components in the constructor. so, whenever i create the object of
	 * homepage, i will have the new objects of the components created.
	 */

	/*
	 * why here we select the storePage as the return type?
	 * 
	 * 
	 * Answer-- it is for good automation practice and this is called as ""fluent
	 * interface"". if we look as the UI flow perceptive that we have landed on the
	 * HomePage and in second method we used navigatetoStoreUsingMenu then we have
	 * landed to the StorePage. so when we are navigating to new page from current
	 * page then we need to written the object of that new page. so in above, we are
	 * navigating to the store page that's why it is mentioned the return type of
	 * StorePage. also, we have passed the driver-- so that driver life also there
	 * in StorePage.
	 * 
	 * Question- if we are still on the current page and don't want to go to other
	 * page then what to do?
	 * 
	 * Answer-- use Builder Pattern. example-- return this;
	 * 
	 * Question- if we are still on the current page and want to go to other page
	 * then what to do?
	 * 
	 * Answer-- use fluent interface. example-- return new "Page name"(driver) ----
	 * return new Loginpage(driver) if we are on homepage and provide the return
	 * type of next page--- which is Loginpage.
	 * 
	 */

	public HomePage(WebDriver driver) {
		super(driver); // created the constructor and super keyword to call the parent class
						// constructor which is in BasePage
		//this.myHeader= new MyHeader(driver);
		myHeader = new MyHeader(driver);
		productThumbnail = new ProductThumbnail(driver);
		//
	}

	public MyHeader getMyHeader() {
		return myHeader;
	}

	public ProductThumbnail getProductThumbnail() {
		return productThumbnail;
	}

	public HomePage load() {
		load("/"); // this method is from the BasePage
		wait.until(ExpectedConditions.titleContains("AskOmDch"));
		return this;
	}

	public StorePage navigatetoStoreUsingMenu() {
		wait.until(ExpectedConditions.elementToBeClickable(StoreMenuLink)).click();
		// driver.findElement(StoreMenuLink).click();
		return new StorePage(driver);

	}

	public MenPage navigateToMenUsingMenu() {
		wait.until(ExpectedConditions.elementToBeClickable(MenMenuLink)).click();
		return new MenPage(driver);
	}

	public LoginPage navigatetoAccountUsingMainMenu() {
		wait.until(ExpectedConditions.elementToBeClickable(Account)).click();
		return new LoginPage(driver);
	}

}
