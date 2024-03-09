package naveenautomation.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.TestBases.TestBase;
import com.naveenautomation.pages.AccountLoginPage;
import com.naveenautomation.pages.DownloadPage;
import com.naveenautomation.pages.MyAccountPage;

public class DownloadPageTest extends TestBase {

	AccountLoginPage page;
	MyAccountPage myAccountPage;
	DownloadPage download;

	@BeforeMethod
	public void launchBrowser() {
		initialisation();
		page = new AccountLoginPage();
	}

	@Test
	public void validateDownloadsPageNavigation() {

		myAccountPage = page.submitLogin("lijosh4@gmail.com", "password");

		download = myAccountPage.clickDownloadsItem("Downloads");

		String headerText = download.getAccountDowloadsHeading();
		Assert.assertEquals(headerText, "Account Downloads", "Actual and Expected header text don't match");

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
