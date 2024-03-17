package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.TestBases.TestBase;
import com.naveenautomation.utility.Utility;

public class AddressBookPage extends TestBase {

	public AddressBookPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div.buttons.clearfix div:last-of-type a")
	WebElement newAddressBtn;

	@FindBy(css = "div.alert")
	WebElement alertBannerText;

	public AddAddressPage clickNewAddressBtn() {
		Utility.clickOnElement(newAddressBtn);
		return new AddAddressPage();
	}

	public String getBannerText() {
		return Utility.getTextFromWebelement(alertBannerText);
	}

}
