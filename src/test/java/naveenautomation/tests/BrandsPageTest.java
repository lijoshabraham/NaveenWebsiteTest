package naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.TestBases.TestBase;
import com.naveenautomation.pages.BrandsPage;
import com.naveenautomation.pages.HomePage;

public class BrandsPageTest extends TestBase {
	HomePage home;
	BrandsPage brands;

	@BeforeMethod
	public void launchBrowser() {
		initialization();
	}

	@Test
	public void validateBrandsPageNavigation() {
		home = new HomePage();

		brands = home.clickBrandsItem("Brands");

		String headerText = brands.validateBrandPageHeader();
		Assert.assertEquals(headerText, "Find Your Favorite Brand", "Actual and Expected header text don't match");

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
