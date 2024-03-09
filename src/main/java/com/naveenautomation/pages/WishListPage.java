package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.TestBases.TestBase;

public class WishListPage extends TestBase {

	public WishListPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content h2")
	WebElement wishListPageHeader;

	public String getWishListPageHeader() {
		return wishListPageHeader.getText();
	}

}
