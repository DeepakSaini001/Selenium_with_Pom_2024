package test;



import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.Base.BaseTest;
import org.Pages.CartPage;
import org.Pages.CheckOutPage;
import org.Pages.HomePage;
import org.Pages.StorePage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstCase extends BaseTest {

	@Test(priority = 0)
	public void guestCheckoutUsingBankTransfer() {

		HomePage homepage = new HomePage(getDriver()).load();
		StorePage storepage = homepage.navigatetoStoreUsingMenu();
		/*
		 * check the return type of ClickStoreMenulink method. it is StorePage. as we
		 * are using fluent interface. we don't need to again create the object of
		 * StorePage. No need to create the new object for storePage.
		 */

		storepage.enterTextSearchField("Blue").clickSearchButton();

		AssertJUnit.assertEquals(storepage.getTitle(), "Search results: “Blue”");
		storepage.clickAddToCartButton("Blue Shoes");

		CartPage cartpage = storepage.clickViewCartButton();

		AssertJUnit.assertEquals(cartpage.getProductName(), "Blue Shoes");
		CheckOutPage checkoutpage = cartpage.ClickCheckOutButton();

		AssertJUnit.assertEquals(checkoutpage.getTitle(), "Checkout");
		checkoutpage.enterFirstName("Deepak").enterlastName("Saini").ClickCountryDropDown()
				.enterTextSearchCountry("United States (US)").getCountryNameSelect().enterStreetAddress01("Kurukshetra")
				.enterStreetAddress02("haryana").ClickStateDropDown().enterTextSearchState("California")
				.getStateNameSelect().enterTown("Kurukshetra").enterEmailID("Deepak.saini2106@gmail.com")
				.enterZipCode("00012").clickPlaceOrder();

		AssertJUnit.assertEquals(checkoutpage.getNotice(), "Thank you. Your order has been received.");

	}

	@Test(priority = 1)
	public void LoginAndCheckOut_guestCheckoutUsingBankTransfer() throws InterruptedException {

		StorePage storepage = new HomePage(getDriver()).load().navigatetoStoreUsingMenu().enterTextSearchField("Blue")
				.clickSearchButton();

		AssertJUnit.assertEquals(storepage.getTitle(), "Search results: “Blue”");
		storepage.clickAddToCartButton("Blue Shoes");

		CartPage cartpage = storepage.clickViewCartButton();

		AssertJUnit.assertEquals(cartpage.getProductName(), "Blue Shoes");
		CheckOutPage checkoutpage = cartpage.ClickCheckOutButton();

		AssertJUnit.assertEquals(checkoutpage.getTitle(), "Checkout");
		checkoutpage.ClickhereToLogin().enterUserName("user1").enterPassword("user1").ClickLoginButton()
				.enterFirstName("Deepak").enterlastName("Saini").ClickCountryDropDown()
				.enterTextSearchCountry("United States (US)").getCountryNameSelect().enterStreetAddress01("Kurukshetra")
				.enterStreetAddress02("haryana").ClickStateDropDown().enterTextSearchState("California")
				.getStateNameSelect().enterTown("Kurukshetra").enterEmailID("Deepak.saini2106@gmail.com")
				.enterZipCode("00012").clickPlaceOrder();
Thread.sleep(5000);
		AssertJUnit.assertEquals(checkoutpage.getNotice(), "Thank you. Your order has been received.");
	}

}
