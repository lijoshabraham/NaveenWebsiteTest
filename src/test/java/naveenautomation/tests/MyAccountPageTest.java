package naveenautomation.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naveenautomation.TestBases.TestBase;
import com.naveenautomation.pages.AccountLoginPage;
import com.naveenautomation.pages.ChangePwdPage;
import com.naveenautomation.pages.EditAccountPage;
import com.naveenautomation.pages.EditAffiliateInfoPage;
import com.naveenautomation.pages.MyAccountPage;
import com.naveenautomation.pages.NewsletterPage;
import com.naveenautomation.utility.ExcelUtils;
import com.naveenautomation.utility.Utility;

public class MyAccountPageTest extends TestBase {

	AccountLoginPage page;
	MyAccountPage myAccountPage;
	ChangePwdPage changePwdPage;
	EditAccountPage editAccount;
	EditAffiliateInfoPage editAffiliateInfoPage;
	NewsletterPage newsletterPage;

	@BeforeMethod
	public void launchBrowser() {
		initialisation();
		page = new AccountLoginPage();
	}

	@Test()
	public void validateLogin() {
		AccountLoginPage page = new AccountLoginPage();
		myAccountPage = page.submitLogin("lijosh4@gmail.com", "password");
		String myAccountText = myAccountPage.getMyAccountText();
		Assert.assertEquals(myAccountText, "My Account");// actual&Expected

	}

	@Test
	public void validateUserCanEditAffiliateInformation() {
		myAccountPage = page.submitLogin("lijosh4@gmail.com", "password");
		editAffiliateInfoPage = myAccountPage.clickEditAffiliateInfoBtn();
		editAffiliateInfoPage.submitAffiliateInformation(Utility.generateRandomString(7),
				Utility.generateRandomString(6), Utility.generateRandomString(5), Utility.generateRandomString(8));
		String editAffiliateInfoAlert = myAccountPage.getEditAffiliateInfosuccessBanner();
		Assert.assertEquals(editAffiliateInfoAlert, "Success: Your account has been successfully updated.");
	}

	@Test
	public void validateUserCanSubscribeNewsLetter() {
		myAccountPage = page.submitLogin("lijosh4@gmail.com", "password");
		newsletterPage = myAccountPage.clickNewsletterItem("NewsLetter");
		myAccountPage = newsletterPage.submitNewsletterSubscription();
		String newsletterSubscriptionSuccessAlert = myAccountPage.getNewsletterSubscriptionSuccessBanner();
		Assert.assertEquals(newsletterSubscriptionSuccessAlert,
				"Success: Your newsletter subscription has been successfully updated!");
	}

	@Test(dataProvider = "LoginData")
	public void validateLoginFromDataProvider(String username, String password) {
		AccountLoginPage page = new AccountLoginPage();
		page.submitLogin(username, password);
	}

	@DataProvider(name = "LoginData")
	private String[][] loginInfoProvider() throws IOException {
		String filePath = "C:\\Users\\user\\Downloads\\LoginDetails.xlsx";
		int rowCount = ExcelUtils.getRowCount(filePath, "Sheet1");
		int colCount = ExcelUtils.getColumnCount(filePath, "Sheet1", rowCount);
		String[][] loginData = new String[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				loginData[i - 1][j] = ExcelUtils.getCellValue(filePath, "Sheet1", i, j);
			}
		}
		return loginData;
	}

	@Test()
	public void validatePasswordUpdate() {

		myAccountPage = page.submitLogin("lijosh4@gmail.com", "password");

		changePwdPage = myAccountPage.clickChangePasswordBtn();

		myAccountPage = changePwdPage.updatePassword("Password1", "Password1");

		String pwdAlertMessage = myAccountPage.getPasswordUpdateAlertText();
		Assert.assertEquals(pwdAlertMessage, "Success: Your password has been successfully updated.");

	}

	@Test
	public void validateEditAccount() {

		myAccountPage = page.submitLogin("lijosh4@gmail.com", "password");

		editAccount = myAccountPage.clickEditAccountItem("Edit Account");

		myAccountPage = editAccount.updateAccountDetails(Utility.generateRandomString(5),
				Utility.generateRandomString(5));
		String editAccountSuccessMessage = myAccountPage.getEditAccountSuccessBanner();
		Assert.assertEquals(editAccountSuccessMessage, "Success: Your account has been successfully updated.");

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
