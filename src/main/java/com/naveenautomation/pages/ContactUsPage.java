package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.TestBases.TestBase;

public class ContactUsPage extends TestBase {

	public ContactUsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-name")
	WebElement name;

	@FindBy(id = "input-email")
	WebElement email;

	@FindBy(id = "input-enquiry")
	WebElement enquiryMessage;

	@FindBy(css = ".pull-right input")
	WebElement submitBtn;

	@FindBy(css = "#content p")
	WebElement enquirySuccessMessage;

	private void enterName(String name) {
		logger.info("Entering Name" + name);
		this.name.sendKeys(name);
	}

	private void enterEmail(String email) {
		this.email.sendKeys(email);
	}

	private void enterEnquiryMessage(String message) {
		this.enquiryMessage.sendKeys(message);
	}

	private void clickSubmitBtn() {
		submitBtn.click();
	}
	
	public String validateContactFormSubmitMessage() {
		return enquirySuccessMessage.getText();
	}

	public ContactUsPage submitContactForm(String name, String email, String message) {
		enterName(name);
		enterEmail(email);
		enterEnquiryMessage(message);
		clickSubmitBtn();
		return new ContactUsPage();

	}

}
