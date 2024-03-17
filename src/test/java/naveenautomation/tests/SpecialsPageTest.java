package naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.TestBases.TestBase;
import com.naveenautomation.pages.HomePage;
import com.naveenautomation.pages.SpecialsPage;

public class SpecialsPageTest extends TestBase {
	HomePage home;
	SpecialsPage specials;

	@BeforeMethod
	public void launchBrowser() {
		initialization();
	}

	@Test
	public void validateSpecialsPageNavigation() {
		home = new HomePage();

		specials = home.clickSpecialsItem("Specials");

		String headerText = specials.validatespecialsPageHeader();
		Assert.assertEquals(headerText, "Special Offers", "Actual and Expected header text don't match");

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
