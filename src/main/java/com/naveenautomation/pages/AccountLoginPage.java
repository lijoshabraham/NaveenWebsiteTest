package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.TestBases.TestBase;

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
	
	public AccountRegisterPage clickNewAccountContinueBtn() {
		newAccountContinueBtn.click();
		return new AccountRegisterPage();
	}
	
	public CategoryAndPath24Page clickphoneAndPDABtn() {
		phoneAndPDABtn.click();
		return new CategoryAndPath24Page();
	}


	private void enterEmail(String email) {
		logger.info("Entering Email" + email);
		loginInput.sendKeys(email);
	}

	private void enterPassword(String pwd) {
		logger.info("Entering Password" + pwd);
		pwdInput.sendKeys(pwd);
	}

	private void clickLogin() {
		logger.info("Clicking login button");
		loginBtn.click();
	}

	public MyAccountPage submitLogin(String email, String pwd) {
		enterEmail(email);
		enterPassword(pwd);
		clickLogin();
		return new MyAccountPage();
	}

}
