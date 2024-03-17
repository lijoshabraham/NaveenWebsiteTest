package com.naveenautomation.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.TestBases.TestBase;
import com.naveenautomation.utility.Utility;

public class DeliveryInformationPage extends TestBase{
	public DeliveryInformationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content p")
	WebElement deliveryPageHeader;

	public String getdeliveryPageHeader() {
		return Utility.getTextFromWebelement(deliveryPageHeader);
	}
	
}
