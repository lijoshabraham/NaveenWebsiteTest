package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.TestBases.TestBase;

public class AccountLogoutPage extends TestBase{
	
	public AccountLogoutPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content p")
	WebElement accountLogoutSuccessText;

	public String getAccountLogoutSuccessText() {
		return accountLogoutSuccessText.getText();
	}

	

}
