package naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.TestBases.TestBase;
import com.naveenautomation.pages.AccountLoginPage;
import com.naveenautomation.pages.MyAccountPage;
import com.naveenautomation.pages.RecurringPaymentsPage;

public class RecurringPaymentsPageTest extends TestBase {

	AccountLoginPage page;
	MyAccountPage myAccountPage;
	RecurringPaymentsPage recurringPaymentsPage;

	@BeforeMethod
	public void launchBrowser() {
		initialization();
		page = new AccountLoginPage();
	}

	@Test
	public void validateRecurringPaymentsPageNavigation() {

		myAccountPage = page.submitLogin("lijosh4@gmail.com", "password");

		recurringPaymentsPage = myAccountPage.clickRecurringPaymentsItem("Recurring Payments");

		String headerText = recurringPaymentsPage.getRecurringPaymentHeading();
		Assert.assertEquals(headerText, "Recurring Payments", "Actual and Expected header text don't match");

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
