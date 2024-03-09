package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.TestBases.TestBase;

public class TransactionsPage extends TestBase {

	public TransactionsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content h1")
	WebElement transactionsPageHeading;

	public String getTransactionsPageHeading() {
		return transactionsPageHeading.getText();
	}

}
