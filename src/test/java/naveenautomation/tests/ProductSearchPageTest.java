package naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.TestBases.TestBase;
import com.naveenautomation.pages.HomePage;
import com.naveenautomation.pages.ProductSearchPage;
import com.naveenautomation.utility.Utility;

public class ProductSearchPageTest extends TestBase {

	HomePage home;
	ProductSearchPage search;

	@BeforeMethod
	public void launchBrowser() {
		initialization();
	}

	@Test
	public void verifySearchPageHeader() {
		home = new HomePage();

		String searchData = Utility.generateRandomString(7);
		search = home.submitSearchData(searchData); 

		String searchPageText = search.verifySearchHeader();
		Assert.assertTrue(searchPageText.contains("Search"), "Search header doesn't contain the expected text");
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
