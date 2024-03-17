package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.TestBases.TestBase;
import com.naveenautomation.utility.Utility;

public class AccountRegisterPage extends TestBase {
	public AccountRegisterPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-firstname")
	WebElement firstName;

	@FindBy(id = "input-lastname")
	WebElement lastName;

	@FindBy(id = "input-email")
	WebElement email;

	@FindBy(id = "input-telephone")
	WebElement phone;

	@FindBy(id = "input-password")
	WebElement password;

	@FindBy(id = "input-confirm")
	WebElement confirmPassword;

	@FindBy(css = ".buttons input:first-of-type")
	WebElement checkBox;
	
	@FindBy(css = ".buttons input:last-of-type")
	WebElement continueBtn;

	private void getFirstName(String firstName) {
		Utility.sendText(this.firstName, firstName);
	}

	private void getLastName(String lastName) {
		Utility.sendText(this.lastName, lastName);
	}

	private void getEmail(String email) {
		Utility.sendText(this.email, email);
	}

	private void getPhone(String phone) {
		Utility.sendText(this.phone, phone);
	}

	private void getPassword(String password) {
		Utility.sendText(this.password, password);
	}

	private void getConfirmPassword(String password) {
		Utility.sendText(this.confirmPassword, password);
	}

	private void clickCheckBox() {
		Utility.clickOnElement(checkBox);
	}
	
	private void clickContinueBtn() {
		Utility.clickOnElement(continueBtn);
	}


	public AccountSuccessPage submitRegistrationDetails(String firstName, String lastName, String email, String phone,
			String pwd, String confirmPwd) {
		getFirstName(firstName);
		getLastName(lastName);
		getEmail(email);
		getPhone(phone);
		getPassword(pwd);
		getConfirmPassword(confirmPwd);
		clickCheckBox();
		clickContinueBtn();
		return new AccountSuccessPage();
	}

}
