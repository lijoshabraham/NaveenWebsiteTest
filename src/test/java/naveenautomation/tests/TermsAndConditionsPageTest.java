package naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.TestBases.TestBase;
import com.naveenautomation.pages.HomePage;
import com.naveenautomation.pages.TermsAndConditionsPage;

public class TermsAndConditionsPageTest extends TestBase{
	HomePage home;
	TermsAndConditionsPage termsAndConditions;

	@BeforeMethod
	public void launchBrowser() {
		initialization();
	}

	@Test
	public void validateTermsAndConditionsPageNavigation() {
		home = new HomePage();

		termsAndConditions = home.clickTermsAndConditionsItem("Terms & Conditions");

		String headerText = termsAndConditions.getTermsAndConditionsHeader();
		Assert.assertEquals(headerText, "Terms & Conditions", "Actual and Expected header text don't match");

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}


}
