package naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.TestBases.TestBase;
import com.naveenautomation.pages.AccountLoginPage;
import com.naveenautomation.pages.CategoryAndPath24Page;


public class CategoryAndPath24PageTest extends TestBase{
	
	AccountLoginPage page;
	CategoryAndPath24Page categoryAndPath24Page;

	@BeforeMethod
	public void launchBrowser() {
		initialisation();
		page = new AccountLoginPage();
	}

	@Test()
	public void validateProductSort() {
		categoryAndPath24Page = page.clickphoneAndPDABtn();
		
		categoryAndPath24Page = categoryAndPath24Page.SubmitSort("Name (Z - A)");
		
		String firstProductName = categoryAndPath24Page.getFirstProductName();
		Assert.assertEquals(firstProductName, "Palm Treo Pro");
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
