package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

import com.naveenautomation.TestBases.TestBase;
import com.naveenautomation.utility.Utility;

public class HomePage extends TestBase {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#logo img")
	WebElement logo;

	@FindBy(css = "#search input")
	WebElement searchInputBox;

	@FindBy(css = "#search button")
	WebElement searchBtn;

	@FindBy(css = ".row #cart")
	WebElement cartBtn;

	@FindBy(css = ".row #cart .dropdown-menu p a:first-of-type")
	WebElement viewCartBtn;

	@FindBy(css = "#common-home>div:first-of-type")
	WebElement successAlert;

	@FindBy(css = "#content .row>div:first-of-type .button-group button:first-of-type")
	WebElement addTocartIcon;

	@FindBy(css = "#content .row>div:first-of-type .caption a")
	WebElement macBookBtn;

	@FindBy(css = ".row> div:first-of-type .list-unstyled li a")
	List<WebElement> informationWebElementList;

	@FindBy(css = ".row> div:nth-of-type(2) .list-unstyled li a")
	List<WebElement> customerServiceWebElementList;

	@FindBy(css = ".row> div:nth-of-type(3) .list-unstyled li a")
	List<WebElement> extrasWebElementList;

	public void clickAddToCartIcon() {
		Utility.waitForElementClickable(driver, addTocartIcon, 10);
		addTocartIcon.click();
	}

	public ProductId43Page clickmacBookBtn() {
		macBookBtn.click();
		return new ProductId43Page();
	}

	private void clickCartBtn() {
		cartBtn.click();
	}

	private void clickViewCartBtn() {
		viewCartBtn.click();
	}

	public CartPage navigateToViewCart() {
		clickCartBtn();
		clickViewCartBtn();
		return new CartPage();
	}

	public boolean verifyNaveenLogo() {
		logger.info("verifying logo is displayed");
		return logo.isDisplayed();
	}

	private void enterSearchData(String searchData) {
		searchInputBox.sendKeys(searchData);
	}

	private void clickSearch() {
		searchBtn.click();
	}

	// Information List
	private <T> T clickInformationListItem(String item, Class<T> pageClass) {
		for (WebElement element : informationWebElementList) {
			if (element.getText().equalsIgnoreCase(item)) {
				element.click();
				return PageFactory.initElements(driver, pageClass);
			}
		}
		throw new RuntimeException("Information Item not found: " + item);
	}

	public AboutUsPage clickAboutUsItem(String itemToClick) {
		return clickInformationListItem(itemToClick, AboutUsPage.class);
	}

	public DeliveryInformationPage clickDeliveryInformation(String itemToClick) {
		return clickInformationListItem(itemToClick, DeliveryInformationPage.class);
	}

	public PrivacyPolicyPage clickPrivacyPolicyItem(String itemToClick) {
		return clickInformationListItem(itemToClick, PrivacyPolicyPage.class);
	}

	public TermsAndConditionsPage clickTermsAndConditionsItem(String itemToClick) {
		return clickInformationListItem(itemToClick, TermsAndConditionsPage.class);
	}

	// Customer Service List
	private <T> T clickCustomerServiceListItem(String item, Class<T> pageClass) {
		for (WebElement element : customerServiceWebElementList) {
			if (element.getText().equalsIgnoreCase(item)) {
				element.click();
				return PageFactory.initElements(driver, pageClass);
			}
		}
		throw new RuntimeException("Customer Service Item not found: " + item);
	}

	public ContactUsPage clickContactUsItem(String itemToClick) {
		return clickCustomerServiceListItem(itemToClick, ContactUsPage.class);
	}

	public SiteMapPage clickSiteMapItem(String itemToClick) {
		return clickCustomerServiceListItem(itemToClick, SiteMapPage.class);
	}

	// Extras List
	private <T> T clickExtrasListItem(String item, Class<T> pageClass) {
		for (WebElement element : extrasWebElementList) {
			if (element.getText().equalsIgnoreCase(item)) {
				element.click();
				return PageFactory.initElements(driver, pageClass);
			}
		}
		throw new RuntimeException("Extras Item not found: " + item);
	}

	public BrandsPage clickBrandsItem(String itemToClick) {
		return clickExtrasListItem(itemToClick, BrandsPage.class);
	}

	public GiftCertificatesPage clickGiftCertificatesItem(String itemToClick) {
		return clickExtrasListItem(itemToClick, GiftCertificatesPage.class);
	}

	public SpecialsPage clickSpecialsItem(String itemToClick) {
		return clickExtrasListItem(itemToClick, SpecialsPage.class);
	}

	public ProductSearchPage submitSearchData(String searchData) {
		enterSearchData(searchData);
		clickSearch();
		return new ProductSearchPage();
	}

	public String getSuccessAlert() {

		return successAlert.getText();
	}

}
