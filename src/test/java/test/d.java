package test;

import api.actions.SignUpAPI;

public class d {

	public static void main(String[] args) {

		SignUpAPI a = new SignUpAPI();
		System.out.println("Fetching the register value using Groovy"+" : "+a.fetchRegisterNonceValueUsingGroovy());
		System.out.println("Fetching the register value using JSoup"+" : "+a.fetchRegisterNonceValueUsingJsoup());
	}
}
