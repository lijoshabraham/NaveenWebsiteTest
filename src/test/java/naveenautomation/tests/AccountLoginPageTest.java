package naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.TestBases.TestBase;
import com.naveenautomation.pages.AccountLoginPage;

public class AccountLoginPageTest extends TestBase {

	AccountLoginPage page;
	@BeforeMethod
	public void launchBrowser() {
		initialization();
	}
	@Test
	public void validateInvalidDataLogin() {
		AccountLoginPage page = new AccountLoginPage();
		page.submitLogin("lijosh9@gmail.com", "password");
		String FailureText = page.getFailureAlert();
		Assert.assertEquals(FailureText, "Warning: No match for E-Mail Address and/or Password.");// actual&Expected

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
