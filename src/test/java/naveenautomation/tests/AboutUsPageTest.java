package naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.TestBases.TestBase;
import com.naveenautomation.pages.AboutUsPage;
import com.naveenautomation.pages.HomePage;

public class AboutUsPageTest extends TestBase {

	HomePage home;
	AboutUsPage about;

	@BeforeMethod
	public void launchBrowser() {
		initialisation();
	}

	@Test
	public void validateAboutUsPageNavigation() {
		home = new HomePage();

		about = home.clickAboutUsItem("About Us");

		String headerText = about.getaboutUsHeader();
		Assert.assertEquals(headerText, "About Us", "Actual and Expected header text don't match");

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
