package naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.TestBases.TestBase;
import com.naveenautomation.pages.AccountLoginPage;
import com.naveenautomation.pages.CartPage;
import com.naveenautomation.pages.HomePage;
import com.naveenautomation.pages.MyAccountPage;

public class CartPageTest extends TestBase {
	AccountLoginPage loginPage;
	MyAccountPage myAccountPage;
	HomePage home;
	CartPage cartPage;

	@BeforeMethod
	public void launchBrowser() {
		initialisation();
	}

	@Test
	public void verifyCartPageNavigation() {
		loginPage = new AccountLoginPage();
		myAccountPage = loginPage.submitLogin("lijosh4@gmail.com", "password");
		home = myAccountPage.clickHomeLogo();
		cartPage = home.navigateToViewCart();
		String headerText = cartPage.getCartPageHeader();
		Assert.assertTrue(headerText.contains("Shopping Cart"), "Shopping Cart header doesn't contain the expected text");
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
