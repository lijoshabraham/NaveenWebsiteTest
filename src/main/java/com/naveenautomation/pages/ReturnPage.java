package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.TestBases.TestBase;

public class ReturnPage extends TestBase {

	public ReturnPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content h1")
	WebElement returnPageHeading;

	public String getreturnPageHeading() {
		return returnPageHeading.getText();
	}

}
