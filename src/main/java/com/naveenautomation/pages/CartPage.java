package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.TestBases.TestBase;

public class CartPage extends TestBase {
	public CartPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content h1")
	WebElement cartHeader;

	public String getCartPageHeader() {
		return cartHeader.getText();
	}

}
