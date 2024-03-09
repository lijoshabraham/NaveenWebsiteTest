package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.TestBases.TestBase;

public class TermsAndConditionsPage extends TestBase{
	public TermsAndConditionsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content p")
	WebElement termsAndConditionsHeader;

	public String getTermsAndConditionsHeader() {
		return termsAndConditionsHeader.getText();
	}

}
