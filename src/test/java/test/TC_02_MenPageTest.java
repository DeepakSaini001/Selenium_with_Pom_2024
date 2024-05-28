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

public class TC_02_MenPageTest extends BaseTest {

	@Test
	public void OrderThroughMenPage() {
		BillingAddress billingAddress = new BillingAddress();

		billingAddress.setFirstName("Deepak").setLastName("Saini").setStreetAddress01("KKR")
				.setStreetAddress02("Haryana").setTown("KKR").setZipCode("00012")
				.setEmailID("Deepak.saini2106@gmail.com").setCountry("United States (US)").setState("California");

		LoginPage login = new HomePage(getDriver()).load().navigatetoAccountUsingMainMenu();
		Assert.assertEquals(login.verifyAccountTitle(), "Account");
		SuccessfulLoginPage LoggedIn = login.enterUserName("user1").enterPassword("user1").clickLoginButton();
		Assert.assertEquals(LoggedIn.verifyUserLoggedIn(), "Dashboard");
		MenPage menpage = login.navigateToMenUsingMenu().enterTextSearchField("Blue").clickSearchButton();
		Assert.assertEquals(menpage.verifySearchTitle(), "Search results: “Blue”");
		menpage.clickAddToCartButton("Blue Shoes");
		CartPage cartpage = menpage.VerifyViewCartButton();
		Assert.assertEquals(cartpage.getProductName(), "Blue Shoes");
		CheckOutPage checkoutpage = cartpage.ClickCheckOutButton().setBillingAddress(billingAddress)
				.SelectDirectBankTransfer().clickPlaceOrder();

		Assert.assertEquals(checkoutpage.getNotice(), "Thank you. Your order has been received.");

		Assert.assertEquals(checkoutpage.getTitle(), "Checkout");
	}

}
