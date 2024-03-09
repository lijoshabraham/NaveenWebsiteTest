package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.TestBases.TestBase;

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
		this.firstName.sendKeys(firstName);
	}

	private void getLastName(String lastName) {
		this.lastName.sendKeys(lastName);
	}

	private void getEmail(String email) {
		this.email.sendKeys(email);
	}

	private void getPhone(String phone) {
		this.phone.sendKeys(phone);
	}

	private void getPassword(String password) {
		this.password.sendKeys(password);
	}

	private void getConfirmPassword(String password) {
		this.confirmPassword.sendKeys(password);
	}

	private void clickCheckBox() {
		checkBox.click();
	}
	
	private void clickContinueBtn() {
		continueBtn.click();
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
