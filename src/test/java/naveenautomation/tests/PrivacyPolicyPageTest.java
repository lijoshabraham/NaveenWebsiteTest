package naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.TestBases.TestBase;
import com.naveenautomation.pages.HomePage;
import com.naveenautomation.pages.PrivacyPolicyPage;

public class PrivacyPolicyPageTest extends TestBase {

	HomePage home;
	PrivacyPolicyPage privacyPage;

	@BeforeMethod
	public void launchBrowser() {
		initialization();
	}

	@Test
	public void validatePrivacyPolicyPageNavigation() {
		home = new HomePage();

		privacyPage = home.clickPrivacyPolicyItem("Privacy Policy");

		String headerText = privacyPage.getprivacyPolicyHeader();
		Assert.assertEquals(headerText, "Privacy Policy", "Actual and Expected header text don't match");

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
