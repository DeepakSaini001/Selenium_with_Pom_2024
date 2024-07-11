package test;


import org.Base.BaseTest;
import org.Objects.BillingAddress;
import org.Objects.Product;
import org.Objects.User;
import org.Pages.CheckOutPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.FakerUtils;
import org.utils.JacksonUtils;

import api.actions.CartApi;
import api.actions.SignUpAPI;
import constants.Constants_data;

import java.io.IOException;

public class CheckoutTest extends BaseTest {

    @Test
    public void GuestCheckoutUsingDirectBankTransfer() throws Exception {
      //  BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
        CheckOutPage checkoutPage = new CheckOutPage(getDriver()).load();

        CartApi cartApi = new CartApi();
        cartApi.addToCart(1215, 1);
        injectCookiesToBrowser(cartApi.getCookies());

        checkoutPage.load().
        setBillingAddress(setBillingAddressDetails()).
                SelectDirectBankTransfer().
                clickPlaceOrder();
        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
    }

    @Test
    public void LoginAndCheckoutUsingDirectBankTransfer() throws IOException, InterruptedException {
       BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
        String username = "demouser" + new FakerUtils().generateRandomNumber();
        User user = new User().
                setUsername(username).
                setPassword("demopwd").
                setEmail(username + "@askomdch.com");

        SignUpAPI signUpApi = new SignUpAPI();
        signUpApi.register(user);
        CartApi cartApi = new CartApi(signUpApi.getCookies());
        Product product = new Product(1215);
        cartApi.addToCart(product.getId(), 1);

        CheckOutPage checkoutPage = new CheckOutPage(getDriver()).load();
        injectCookiesToBrowser(signUpApi.getCookies());
        checkoutPage.load();
        checkoutPage.setBillingAddress(setBillingAddressDetails()).
                SelectDirectBankTransfer().
                clickPlaceOrder();
        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
    }
    
    public static BillingAddress setBillingAddressDetails() {
		BillingAddress billingAddress = new BillingAddress();

		return billingAddress.setFirstName(Constants_data.FirstName).setLastName(Constants_data.LastName)
				.setStreetAddress01(Constants_data.FirstAddress).setStreetAddress02(Constants_data.LastAddress)
				.setTown(Constants_data.Town).setZipCode(Constants_data.ZipCode).setEmailID(Constants_data.EmailID)
				.setCountry(Constants_data.Country).setState(Constants_data.State);
	}
}
