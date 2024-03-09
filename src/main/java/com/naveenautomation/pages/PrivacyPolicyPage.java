package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.TestBases.TestBase;

public class PrivacyPolicyPage extends TestBase {

	public PrivacyPolicyPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content p")
	WebElement privacyPolicyHeader;

	public String getprivacyPolicyHeader() {
		return privacyPolicyHeader.getText();
	}

}
