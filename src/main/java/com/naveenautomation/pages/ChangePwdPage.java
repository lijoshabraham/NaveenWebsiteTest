package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.TestBases.TestBase;

public class ChangePwdPage extends TestBase {

	public ChangePwdPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-password")
	WebElement pwd;

	@FindBy(id = "input-confirm")
	WebElement confirmPwd;

	@FindBy(css = "div.buttons.clearfix input")
	WebElement continueBtn;

	private void enterPwd(String pwd) {
		logger.info("Entering Password" + pwd);
		this.pwd.sendKeys(pwd);
	}

	private void enterConfirmPwd(String pwd) {
		confirmPwd.sendKeys(pwd);
	}

	private void clickContinueBtn() {
		continueBtn.click();
	}

	public MyAccountPage updatePassword(String pwd, String confirmPwd) {
		enterPwd(pwd);
		enterConfirmPwd(confirmPwd);
		clickContinueBtn();
		return new MyAccountPage();

	}

}
