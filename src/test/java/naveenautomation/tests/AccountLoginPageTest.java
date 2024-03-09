package naveenautomation.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.naveenautomation.TestBases.TestBase;

public class AccountLoginPageTest extends TestBase {

	@BeforeMethod
	public void launchBrowser() {
		initialisation();
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
