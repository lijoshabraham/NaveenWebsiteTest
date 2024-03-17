package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.TestBases.TestBase;
import com.naveenautomation.utility.Utility;

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
		Utility.sendText(this.pwd, pwd);
	}

	private void enterConfirmPwd(String pwd) {
		Utility.sendText(confirmPwd, pwd);
	}

	private void clickContinueBtn() {
		Utility.clickOnElement(continueBtn);
	}

	public MyAccountPage updatePassword(String pwd, String confirmPwd) {
		enterPwd(pwd);
		enterConfirmPwd(confirmPwd);
		clickContinueBtn();
		return new MyAccountPage();

	}

}
