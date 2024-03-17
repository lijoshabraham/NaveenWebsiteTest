package naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.TestBases.TestBase;
import com.naveenautomation.pages.ContactUsPage;
import com.naveenautomation.pages.HomePage;
import com.naveenautomation.utility.Utility;

public class ContactUsPageTest extends TestBase {

	HomePage home;
	ContactUsPage contactPage;

	@BeforeMethod
	public void launchBrowser() {
		initialization();
	}

	@Test
	public void validateContactUsForm() {
		home = new HomePage();

		contactPage = home.clickContactUsItem("Contact Us");

		contactPage.submitContactForm(Utility.generateRandomString(5), Utility.generateRandomEmail(),
				Utility.generateRandomString(15));

		String successMessage = contactPage.validateContactFormSubmitMessage();
		Assert.assertEquals(successMessage, "Your enquiry has been successfully sent to the store owner!");
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
