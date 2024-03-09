package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.TestBases.TestBase;

public class SpecialsPage extends TestBase {
	public SpecialsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content h2")
	WebElement specialsPageHeader;

	public String validatespecialsPageHeader() {
		return specialsPageHeader.getText();
	}

}
