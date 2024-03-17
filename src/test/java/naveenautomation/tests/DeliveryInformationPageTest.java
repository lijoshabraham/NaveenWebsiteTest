package naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.TestBases.TestBase;
import com.naveenautomation.pages.DeliveryInformationPage;
import com.naveenautomation.pages.HomePage;

public class DeliveryInformationPageTest extends TestBase{
	HomePage home;
	DeliveryInformationPage deliveryPage;

	@BeforeMethod
	public void launchBrowser() {
		initialization();
	}

	@Test
	public void validateDeliveryInformationPageNavigation() {
		home = new HomePage();

		deliveryPage = home.clickDeliveryInformation("Delivery Information");

		String headerText = deliveryPage.getdeliveryPageHeader();
		Assert.assertEquals(headerText, "Delivery Information", "Actual and Expected header text don't match");

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}



}
