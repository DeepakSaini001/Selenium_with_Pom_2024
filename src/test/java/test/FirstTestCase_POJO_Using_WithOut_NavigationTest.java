package test;

import org.testng.annotations.Test;
import org.Base.BaseTest;
import org.Objects.BillingAddress;
import org.Pages.CartPage;
import org.Pages.CheckOutPage;
import org.Pages.HomePage;
import org.Pages.StorePage;

import org.testng.Assert;


public class FirstTestCase_POJO_Using_WithOut_NavigationTest extends BaseTest {

	@Test(priority = 0, description = "this test will fail beacuse we have not set the value of country and state and in result will get null exception")
	public void FailTestguestCheckoutUsingBankTransfer() {
		BillingAddress billingAddress = new BillingAddress();

		billingAddress.setFirstName("Deepak").setLastName("Saini").setStreetAddress01("KKR")
				.setStreetAddress02("Haryana").setTown("KKR").setZipCode("00012")
				.setEmailID("Deepak.saini2106@gmail.com");

		HomePage homepage = new HomePage(getDriver()).load();
		StorePage storepage = homepage.navigatetoStoreUsingMenu();

		storepage.enterTextSearchField("Blue").clickSearchButton();

		Assert.assertEquals(storepage.getTitle(), "Search results: “Blue”");
		storepage.clickAddToCartButton("Blue Shoes");

		CartPage cartpage = storepage.clickViewCartButton();

		Assert.assertEquals(cartpage.getProductName(), "Blue Shoes");
		CheckOutPage checkoutpage = cartpage.ClickCheckOutButton().setBillingAddress(billingAddress)
				.ClickCountryDropDown().enterTextSearchCountry("United States (US)").getCountryNameSelect()
				.ClickStateDropDown().enterTextSearchState("California").getStateNameSelect().SelectDirectBankTransfer()
				.clickPlaceOrder();

		Assert.assertEquals(checkoutpage.getNotice(), "Thank you. Your order has been received.");

	}

	@Test(priority = 1, description = " using normal billing address")
	public void LoginAndCheckOut_guestCheckoutUsingBankTransfer() {

		StorePage storepage = new HomePage(getDriver()).load().navigatetoStoreUsingMenu().enterTextSearchField("Blue")
				.clickSearchButton();

		Assert.assertEquals(storepage.getTitle(), "Search results: “Blue”");
		storepage.clickAddToCartButton("Blue Shoes");

		CartPage cartpage = storepage.clickViewCartButton();

		Assert.assertEquals(cartpage.getProductName(), "Blue Shoes");
		CheckOutPage checkoutpage = cartpage.ClickCheckOutButton();

		Assert.assertEquals(checkoutpage.getTitle(), "Checkout");
		checkoutpage.ClickhereToLogin().enterUserName("user1").enterPassword("user1").ClickLoginButton()
				.enterFirstName("Deepak").enterlastName("Saini").ClickCountryDropDown()
				.enterTextSearchCountry("United States (US)").getCountryNameSelect().enterStreetAddress01("Kurukshetra")
				.enterStreetAddress02("haryana").ClickStateDropDown().enterTextSearchState("California")
				.getStateNameSelect().enterTown("Kurukshetra").enterEmailID("Deepak.saini2106@gmail.com")
				.enterZipCode("00012").SelectDirectBankTransfer().clickPlaceOrder();

		Assert.assertEquals(checkoutpage.getNotice(), "Thank you. Your order has been received.");
	}

	@Test(priority = 2, description = "Using Select Class provided with getter and setter")
	public void CountrySelectUsing_SelectClass() {

		BillingAddress billingAddress = new BillingAddress();

		billingAddress.setFirstName("Deepak").setLastName("Saini").setStreetAddress01("KKR")
				.setStreetAddress02("Haryana").setTown("KKR").setZipCode("00012")
				.setEmailID("Deepak.saini2106@gmail.com").setCountry("United States (US)").setState("California");

		HomePage homepage = new HomePage(getDriver()).load();
		StorePage storepage = homepage.navigatetoStoreUsingMenu();

		storepage.enterTextSearchField("Blue").clickSearchButton();

		Assert.assertEquals(storepage.getTitle(), "Search results: “Blue”");
		storepage.clickAddToCartButton("Blue Shoes");

		CartPage cartpage = storepage.clickViewCartButton();

		Assert.assertEquals(cartpage.getProductName(), "Blue Shoes");
		CheckOutPage checkoutpage = cartpage.ClickCheckOutButton().setBillingAddress(billingAddress)
				.SelectDirectBankTransfer().clickPlaceOrder();

		Assert.assertEquals(checkoutpage.getNotice(), "Thank you. Your order has been received.");
	}

}
