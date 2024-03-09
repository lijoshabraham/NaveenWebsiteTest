package naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.TestBases.TestBase;
import com.naveenautomation.pages.AccountLoginPage;
import com.naveenautomation.pages.HomePage;
import com.naveenautomation.pages.MyAccountPage;
import com.naveenautomation.pages.ProductId43Page;

public class ProductId43PageTest extends TestBase {
	AccountLoginPage loginPage;
	MyAccountPage myAccountPage;
	HomePage home;
	ProductId43Page productId43Page;

	@BeforeMethod
	public void launchBrowser() {
		initialisation();
	}

	@Test
	public void verifyAddtoCart() {
		loginPage = new AccountLoginPage();
		myAccountPage = loginPage.submitLogin("lijosh4@gmail.com", "password");
		home = myAccountPage.clickHomeLogo();
		productId43Page = home.clickmacBookBtn();
		productId43Page.clickAddtoCartBtn();
		String addTocartSuccessAlert = productId43Page.getSuccessAlert();
		Assert.assertTrue(addTocartSuccessAlert.contains("MacBook"), "Search header doesn't contain the expected text");

	}
	
	@Test
	public void verifyAddtoWishList() {
		loginPage = new AccountLoginPage();
		myAccountPage = loginPage.submitLogin("lijosh4@gmail.com", "password");
		home = myAccountPage.clickHomeLogo();
		productId43Page = home.clickmacBookBtn();
		productId43Page.clickAddtoCartBtn();
		String addToWishListSuccessAlert = productId43Page.getSuccessAlert();
		Assert.assertTrue(addToWishListSuccessAlert.contains("MacBook"), "Search header doesn't contain the expected text");

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
