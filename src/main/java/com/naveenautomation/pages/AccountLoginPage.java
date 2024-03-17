package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.TestBases.TestBase;
import com.naveenautomation.utility.Utility;

public class AccountLoginPage extends TestBase {

	public AccountLoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-email")
	WebElement loginInput;

	@FindBy(id = "input-password")
	WebElement pwdInput;

	@FindBy(css = "#content .row>div:first-of-type a")
	WebElement newAccountContinueBtn;

	@FindBy(css = "#content div>div form>input")
	WebElement loginBtn;

	@FindBy(css = ".collapse>ul li:nth-of-type(6) a")
	WebElement phoneAndPDABtn;

	@FindBy(css = "div.alert")
	WebElement failureAlert;

	public String getFailureAlert() {
		return Utility.getTextFromWebelement(failureAlert);
	}

	public AccountRegisterPage clickNewAccountContinueBtn() {
		Utility.clickOnElement(newAccountContinueBtn);
		return new AccountRegisterPage();
	}

	public CategoryAndPath24Page clickphoneAndPDABtn() {
		Utility.clickOnElement(phoneAndPDABtn);
		return new CategoryAndPath24Page();
	}

	private void enterEmail(String email) {
		logger.info("Entering Email" + email);
		Utility.sendText(loginInput, email);
	}

	private void enterPassword(String pwd) {
		logger.info("Entering Password" + pwd);
		Utility.sendText(pwdInput, pwd);
	}

	private void clickLogin() {
		logger.info("Clicking login button");
		Utility.clickOnElement(loginBtn);
		loginBtn.click();
	}

	public MyAccountPage submitLogin(String email, String pwd) {
		enterEmail(email);
		enterPassword(pwd);
		clickLogin();
		return new MyAccountPage();
	}

}
