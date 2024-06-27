package test;

import org.Base.BaseTest;
import org.Pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

	@Test
	public void searchWithPartialMatch() {
		String searchFor = "Blue";
		StorePage storePage = new StorePage(getDriver()).load().search(searchFor);
		String currentURL = storePage.getCurrentUrl();
		System.out.println("Current URL: " + currentURL);
		boolean isURLCorrect = storePage.verifyURLContains("Blue&post_type=product");
		System.out.println("verifyURLContains : " + isURLCorrect);

		Assert.assertTrue(isURLCorrect, "The URL does not contain the expected string.");

		Assert.assertEquals(storePage.getTitle(), "Search results: “" + searchFor + "”");
		
	
	}
}
