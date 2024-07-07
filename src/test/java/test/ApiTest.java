package test;

import org.Objects.User;
import org.utils.FakerUtils;

import api.actions.CartApi;
import api.actions.SignUpAPI;

public class ApiTest {

	public static void main(String[] args) {

		String Username = "demouser" + FakerUtils.generateRandomNumber();
		User user = new User().setUsername(Username).setPassword("demo").setEmail(Username + "@askmdch.com");
		SignUpAPI signUpAPI = new SignUpAPI();
		// System.out.println("User Details"+" : "+signUpAPI.register(user));

		signUpAPI.register(user);
		System.out.println("Register getCookies Details" + " : " + signUpAPI.getCookies());

		CartApi cartapi = new CartApi(signUpAPI.getCookies());
		cartapi.addToCart(1215, 1);
		System.out.println("cartapi getCookies Details" + " : " + cartapi.getCookies());

	}
}
