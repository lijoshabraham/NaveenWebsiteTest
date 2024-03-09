package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.TestBases.TestBase;

public class ProductSearchPage extends TestBase{

	public ProductSearchPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[contains(text(), 'Search')]")
	WebElement searchHeader;

	public String verifySearchHeader() {
		return searchHeader.getText();
	}

}
