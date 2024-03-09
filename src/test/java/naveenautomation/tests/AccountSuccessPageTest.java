package naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.TestBases.TestBase;
import com.naveenautomation.pages.AccountLoginPage;
import com.naveenautomation.pages.AccountRegisterPage;
import com.naveenautomation.pages.AccountSuccessPage;
import com.naveenautomation.utility.Utility;

public class AccountSuccessPageTest extends TestBase {

	AccountLoginPage login;
	AccountRegisterPage register;
	AccountSuccessPage accountSuccessPage;

	@BeforeMethod
	public void launchBrowser() {
		initialisation();
	}

	@Test
	public void validateAccountRegister() {
		login = new AccountLoginPage();
		register = login.clickNewAccountContinueBtn();
		String password = Utility.generateRandomString(8);
		accountSuccessPage = register.submitRegistrationDetails(Utility.generateRandomString(5),
				Utility.generateRandomString(5), Utility.generateRandomEmail(), Utility.generateRandomString(10),
				password, password);

		String headerText = accountSuccessPage.getAccountCreatedHeader();
		Assert.assertEquals(headerText, "Your Account Has Been Created!",
				"Actual and Expected header text don't match");

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
