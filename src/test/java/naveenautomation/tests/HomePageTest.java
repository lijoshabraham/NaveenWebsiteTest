package naveenautomation.tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.TestBases.TestBase;
import com.naveenautomation.pages.AccountLoginPage;
import com.naveenautomation.pages.HomePage;
import com.naveenautomation.pages.MyAccountPage;

public class HomePageTest extends TestBase {
	AccountLoginPage loginPage;
	MyAccountPage myAccountPage;
	HomePage home;

	@BeforeMethod
	public void launchBrowser() {
		initialization();
	}

	@Test
	public void verifyNaveenWebsiteLogo() {
		home = new HomePage();
		boolean flag = home.verifyNaveenLogo();
		assertTrue(flag);

	}

	@Test
	public void verifyAddtoCartFromHome() {
		loginPage = new AccountLoginPage();
		myAccountPage = loginPage.submitLogin("lijosh4@gmail.com", "password");
		home = myAccountPage.clickHomeLogo();
		home.clickAddToCartIcon();
		String addTocartSuccessAlert = home.getSuccessAlert();
		Assert.assertTrue(addTocartSuccessAlert.contains("Success"), "Add to cart alert doesn't contain the expected text");
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
