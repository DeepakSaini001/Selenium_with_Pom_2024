package test;


import org.Base.BaseTest;
import org.Objects.Product;
import org.Objects.User;
import org.Pages.CheckOutPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.FakerUtils;

import api.actions.CartApi;
import api.actions.SignUpAPI;

public class LoginTest extends BaseTest {

    @Test
    public void loginDuringCheckout() throws Exception {
        String username = "demouser" + new FakerUtils().generateRandomNumber();
        User user = new User().
                setUsername(username).
                setPassword("demopwd").
                setEmail(username + "@askomdch.com");

        SignUpAPI signUpApi = new SignUpAPI();
        signUpApi.register(user);
        CartApi cartApi = new CartApi();
        Product product = new Product(1215);
        cartApi.addToCart(product.getId(), 1);

        CheckOutPage checkoutPage = new CheckOutPage(getDriver()).load();
        injectCookiesToBrowser(cartApi.getCookies());
        checkoutPage.load();
        checkoutPage.
                ClickhereToLogin().
                login(user);
        Assert.assertTrue(checkoutPage.getProductName().contains(product.getName()));
    }
}
