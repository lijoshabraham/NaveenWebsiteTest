package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.naveenautomation.TestBases.TestBase;

public class CategoryAndPath24Page extends TestBase {
	public CategoryAndPath24Page() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#input-sort")
	WebElement sortDropdown;
	
	@FindBy(css = "#content .row>div:first-of-type .caption h4")
	WebElement firstProduct;

	private void selectSort(String name) {
		selectElement(sortDropdown, name);
	}
	
	public String getFirstProductName() {
		return firstProduct.getText();
	}

	public CategoryAndPath24Page SubmitSort(String sort) {
		selectSort(sort);
		return new CategoryAndPath24Page();
	}

	private void selectElement(WebElement element, String text) {
		Select sc = new Select(element);

		try {
			sc.selectByVisibleText(text);
		} catch (Exception e) {
			sc.selectByValue(text);
		}
	}

}
