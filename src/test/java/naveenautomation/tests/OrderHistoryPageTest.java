package naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.TestBases.TestBase;
import com.naveenautomation.pages.AccountLoginPage;
import com.naveenautomation.pages.MyAccountPage;
import com.naveenautomation.pages.OrderHistoryPage;

public class OrderHistoryPageTest extends TestBase {

	AccountLoginPage page;
	MyAccountPage myAccountPage;
	OrderHistoryPage orderHistory;

	@BeforeMethod
	public void launchBrowser() {
		initialisation();
		page = new AccountLoginPage();
	}

	@Test
	public void validateOrderHistoryPageNavigation() {

		myAccountPage = page.submitLogin("lijosh4@gmail.com", "password");

		orderHistory = myAccountPage.clickOrderHistoryItem("Order History");

		String headerText = orderHistory.getOrderHistoryHeading();
		Assert.assertEquals(headerText, "Order History", "Actual and Expected header text don't match");

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
