package naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.TestBases.TestBase;
import com.naveenautomation.pages.AccountLoginPage;
import com.naveenautomation.pages.MyAccountPage;
import com.naveenautomation.pages.WishListPage;

public class WishListPageTest extends TestBase {
	AccountLoginPage page;
	MyAccountPage myAccountPage;
	WishListPage wishList;

	@BeforeMethod
	public void launchBrowser() {
		initialisation();
		page = new AccountLoginPage();
	}

	@Test
	public void validateWishListPageNavigation() {

		myAccountPage = page.submitLogin("lijosh4@gmail.com", "password");

		wishList = myAccountPage.clickWishListItem("Wish List");

		String headerText = wishList.getWishListPageHeader();
		Assert.assertEquals(headerText, "My Wish List", "Actual and Expected header text don't match");

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
