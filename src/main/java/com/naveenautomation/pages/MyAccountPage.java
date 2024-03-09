package com.naveenautomation.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.TestBases.TestBase;
import com.naveenautomation.utility.Utility;

public class MyAccountPage extends TestBase {

	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content>ul:nth-of-type(1) li:nth-of-type(2) a")
	WebElement changePwdBtn;

	@FindBy(css = "div.alert")
	WebElement successBanner;

	@FindBy(css = "div.alert")
	WebElement editAffiliateInfosuccessBanner;

	@FindBy(css = "#account-account>div.row h2:first-of-type")
	WebElement myAccountText;

	@FindBy(css = "#content>ul:nth-of-type(3) a")
	WebElement editAffiliateInfoBtn;

	@FindBy(css = "#logo img")
	WebElement homeLogo;

	@FindBy(css = "#column-right a")
	List<WebElement> sideNavWebelementList;

	public HomePage clickHomeLogo() {
		Utility.waitForElementClickable(driver, homeLogo, 10);
		homeLogo.click();
		return new HomePage();
	}

	public ChangePwdPage clickChangePasswordBtn() {
		changePwdBtn.click();
		return new ChangePwdPage();
	}

	public String getPasswordUpdateAlertText() {
		return successBanner.getText();
	}


	public String getMyAccountText() {
		return myAccountText.getText();
	}

	public String getEditAccountSuccessBanner() {
		return successBanner.getText();
	}

	public String getNewsletterSubscriptionSuccessBanner() {
		return successBanner.getText();
	}

	public String getEditAffiliateInfosuccessBanner() {
		return editAffiliateInfosuccessBanner.getText();
	}

	public EditAffiliateInfoPage clickEditAffiliateInfoBtn() {
		editAffiliateInfoBtn.click();
		return new EditAffiliateInfoPage();
	}

	// Right side bar List
	private <T> T clickSideNavMenuItem(String item, Class<T> pageClass) {
		for (WebElement element : sideNavWebelementList) {
			if (element.getText().equalsIgnoreCase(item)) {
				element.click();
				return PageFactory.initElements(driver, pageClass);
			}
		}
		throw new RuntimeException("Right side bar Item not found: " + item);
	}

	// AddressBook
	public AddressBookPage clickAddressBookItem(String itemToClick) {
		return clickSideNavMenuItem(itemToClick, AddressBookPage.class);
	}

	// Edit Account
	public EditAccountPage clickEditAccountItem(String itemToClick) {
		return clickSideNavMenuItem(itemToClick, EditAccountPage.class);
	}

	// Wish List
	public WishListPage clickWishListItem(String itemToClick) {
		return clickSideNavMenuItem(itemToClick, WishListPage.class);
	}

	// Order History
	public OrderHistoryPage clickOrderHistoryItem(String itemToClick) {
		return clickSideNavMenuItem(itemToClick, OrderHistoryPage.class);
	}

	// Downloads
	public DownloadPage clickDownloadsItem(String itemToClick) {
		return clickSideNavMenuItem(itemToClick, DownloadPage.class);
	}

	// Recurring Payments
	public RecurringPaymentsPage clickRecurringPaymentsItem(String itemToClick) {
		return clickSideNavMenuItem(itemToClick, RecurringPaymentsPage.class);
	}

	// Reward Points
	public RewardPointsPage clickRewardPointsItem(String itemToClick) {
		return clickSideNavMenuItem(itemToClick, RewardPointsPage.class);
	}

	// Returns
	public ReturnPage clickReturnItem(String itemToClick) {
		return clickSideNavMenuItem(itemToClick, ReturnPage.class);
	}

	// Transactions
	public TransactionsPage clickTransactionsItem(String itemToClick) {
		return clickSideNavMenuItem(itemToClick, TransactionsPage.class);
	}

	// Newsletter
	public NewsletterPage clickNewsletterItem(String itemToClick) {
		return clickSideNavMenuItem(itemToClick, NewsletterPage.class);
	}

	// Logout
	public AccountLogoutPage clickLogoutItem(String itemToClick) {
		return clickSideNavMenuItem(itemToClick, AccountLogoutPage.class);
	}

}
