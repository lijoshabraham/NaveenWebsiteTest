package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.TestBases.TestBase;

public class NewsletterPage extends TestBase {

	public NewsletterPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".radio-inline:first-of-type input")
	WebElement subscribeNewsletterRadioBtn;

	@FindBy(css = ".pull-right input")
	WebElement continueBtn;

	private void clickSubscribeNewsletterRadioBtn() {
		subscribeNewsletterRadioBtn.click();
	}

	private void clickContinueBtn() {
		continueBtn.click();
	}

	public MyAccountPage submitNewsletterSubscription() {
		clickSubscribeNewsletterRadioBtn();
		clickContinueBtn();
		return new MyAccountPage();
	}

}
