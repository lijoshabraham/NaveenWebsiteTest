package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.TestBases.TestBase;
import com.naveenautomation.utility.Utility;

public class CategoryAndPath24Page extends TestBase {
	public CategoryAndPath24Page() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#input-sort")
	WebElement sortDropdown;
	
	@FindBy(css = "#content .row>div:first-of-type .caption h4")
	WebElement firstProduct;

	private void selectSort(String name) {
		Utility.selectFromDropDownUsingVisibleText(sortDropdown, name);
	}
	
	public String getFirstProductName() {
		return Utility.getTextFromWebelement(firstProduct);
	}

	public CategoryAndPath24Page SubmitSort(String sort) {
		selectSort(sort);
		return new CategoryAndPath24Page();
	}

}
