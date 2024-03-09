package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.TestBases.TestBase;

public class RecurringPaymentsPage extends TestBase {
	public RecurringPaymentsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content h1")
	WebElement recurringPaymentHeading;

	public String getRecurringPaymentHeading() {
		return recurringPaymentHeading.getText();
	}

}
