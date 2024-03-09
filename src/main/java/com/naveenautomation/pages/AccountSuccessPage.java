package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.TestBases.TestBase;

public class AccountSuccessPage extends TestBase {
	public AccountSuccessPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content h1")
	WebElement accountCreatedHeader;

	public String getAccountCreatedHeader() {
		return accountCreatedHeader.getText();
	}

}