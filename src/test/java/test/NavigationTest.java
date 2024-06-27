package test;

import org.Base.BaseTest;
import org.Pages.HomePage;
import org.Pages.MenPage;
import org.Pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

	@Test
	public void NavigateFromHomeToStoreUsingMainMenu() {

		StorePage storepage = new HomePage(getDriver()).load().navigatetoStoreUsingMenu();
		Assert.assertEquals(storepage.getTitle(), "Store");
	}
	@Test
	public void NavigateFromHomeToMenUsingMainMenu() {

		MenPage menpage = new HomePage(getDriver()).load().navigateToMenUsingMenu();
		Assert.assertEquals(menpage.getTitle(), "Store");
	}

}
