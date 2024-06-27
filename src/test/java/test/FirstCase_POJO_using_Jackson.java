package test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.io.InputStream;


import org.Base.BaseTest;
import org.Objects.BillingAddress;
import org.Pages.CartPage;
import org.Pages.CheckOutPage;
import org.Pages.HomePage;
import org.Pages.StorePage;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.JacksonUtils;

public class FirstCase_POJO_using_Jackson extends BaseTest {

	@Test(priority = 0)
	public void guestCheckoutUsingBankTransfer() throws InterruptedException, IOException {
		BillingAddress billingAddress = new BillingAddress();
		InputStream is = getClass().getClassLoader().getResourceAsStream("MyBillingAddress.json");
		billingAddress = JacksonUtils.desirilization(is, billingAddress);

		HomePage homepage = new HomePage(getDriver()).load();
		StorePage storepage = homepage.navigatetoStoreUsingMenu();

		storepage.enterTextSearchField("Blue").clickSearchButton();

		AssertJUnit.assertEquals(storepage.getTitle(), "Search results: “Blue”");
		storepage.clickAddToCartButton("Blue Shoes");
		Thread.sleep(5000);
		CartPage cartpage = storepage.clickViewCartButton();

		AssertJUnit.assertEquals(cartpage.getProductName(), "Blue Shoes");
		CheckOutPage checkoutpage = cartpage.ClickCheckOutButton().setBillingAddress(billingAddress).ClickCountryDropDown()
				.enterTextSearchCountry("United States (US)").getCountryNameSelect().ClickStateDropDown()
				.enterTextSearchState("California").getStateNameSelect().clickPlaceOrder();
		Thread.sleep(5000);
		AssertJUnit.assertEquals(checkoutpage.getNotice(), "Thank you. Your order has been received.");

	}

}
