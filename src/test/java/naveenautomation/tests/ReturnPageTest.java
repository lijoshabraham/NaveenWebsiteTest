package naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.TestBases.TestBase;
import com.naveenautomation.pages.AccountLoginPage;
import com.naveenautomation.pages.MyAccountPage;
import com.naveenautomation.pages.ReturnPage;

public class ReturnPageTest extends TestBase {

	AccountLoginPage page;
	MyAccountPage myAccountPage;
	ReturnPage returnPage;

	@BeforeMethod
	public void launchBrowser() {
		initialization();
		page = new AccountLoginPage();
	}

	@Test
	public void validatereturnPageNavigation() {

		myAccountPage = page.submitLogin("lijosh4@gmail.com", "password");

		returnPage = myAccountPage.clickReturnItem("Returns");

		String headerText = returnPage.getreturnPageHeading();
		Assert.assertEquals(headerText, "Product Returns", "Actual and Expected header text don't match");

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
