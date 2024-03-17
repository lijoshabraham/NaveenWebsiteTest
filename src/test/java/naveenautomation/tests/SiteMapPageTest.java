package naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.naveenautomation.TestBases.TestBase;
import com.naveenautomation.pages.HomePage;
import com.naveenautomation.pages.SiteMapPage;

public class SiteMapPageTest extends TestBase {
	HomePage home;
	SiteMapPage siteMap;

	@BeforeMethod
	public void launchBrowser() {
		initialization();
	}

	@Test
	public void validateSiteMapPageNavigation() {
		home = new HomePage();

		siteMap = home.clickSiteMapItem("Site Map");

		String headerText = siteMap.getsiteMapHeader();
		Assert.assertEquals(headerText, "Site Map", "Actual and Expected header text don't match");

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
