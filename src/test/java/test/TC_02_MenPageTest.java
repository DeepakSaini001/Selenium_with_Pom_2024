package test;

import org.Base.BaseTest;
import org.Objects.BillingAddress;
import org.Pages.CartPage;
import org.Pages.CheckOutPage;
import org.Pages.HomePage;
import org.Pages.LoginPage;
import org.Pages.MenPage;
import org.Pages.SuccessfulLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants_data;

public class TC_02_MenPageTest extends BaseTest {

	@Test
	public void OrderThroughMenPage() {

		LoginPage login = new HomePage(getDriver()).load().navigatetoAccountUsingMainMenu();
		Assert.assertEquals(login.verifyAccountTitle(), Constants_data.AccountTitle);
		SuccessfulLoginPage LoggedIn = login.enterUserName(Constants_data.UserName02)
				.enterPassword(Constants_data.PASSWORD02).clickLoginButton();
		Assert.assertEquals(LoggedIn.verifyUserLoggedIn(), Constants_data.LoggedInTitle);
		MenPage menpage = login.navigateToMenUsingMenu().enterTextSearchField(Constants_data.ProductSearch)
				.clickSearchButton();
		Assert.assertEquals(menpage.getTitle(), Constants_data.SearchResultTitle);
		menpage.clickAddToCartButton(Constants_data.ProductName);
		CartPage cartpage = menpage.clickViewCartButton();
		Assert.assertEquals(cartpage.getProductName(), Constants_data.ProductName);

		CheckOutPage checkoutpage = cartpage.ClickCheckOutButton().setBillingAddress(setBillingAddressDetails())
				.SelectDirectBankTransfer().clickPlaceOrder();

		Assert.assertEquals(checkoutpage.getNotice(), Constants_data.OrderPlacedTitle);

	}

	public static BillingAddress setBillingAddressDetails() {
		BillingAddress billingAddress = new BillingAddress();

		return billingAddress.setFirstName(Constants_data.FirstName).setLastName(Constants_data.LastName)
				.setStreetAddress01(Constants_data.FirstAddress).setStreetAddress02(Constants_data.LastAddress)
				.setTown(Constants_data.Town).setZipCode(Constants_data.ZipCode).setEmailID(Constants_data.EmailID)
				.setCountry(Constants_data.Country).setState(Constants_data.State);
	}

}
