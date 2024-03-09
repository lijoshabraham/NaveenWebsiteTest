package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.TestBases.TestBase;

public class SiteMapPage extends TestBase{
	public SiteMapPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content h1")
	WebElement siteMapHeader;

	public String getsiteMapHeader() {
		return siteMapHeader.getText();
	}

}
