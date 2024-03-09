package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.TestBases.TestBase;

public class OrderHistoryPage extends TestBase {
	public OrderHistoryPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content h1")
	WebElement orderHistoryHeading;

	public String getOrderHistoryHeading() {
		return orderHistoryHeading.getText();
	}

}
