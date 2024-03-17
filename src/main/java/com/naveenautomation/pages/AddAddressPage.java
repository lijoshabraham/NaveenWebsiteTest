package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.naveenautomation.TestBases.TestBase;
import com.naveenautomation.utility.Utility;

public class AddAddressPage extends TestBase {
	


	public AddAddressPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-firstname")
	WebElement firstName;

	@FindBy(id = "input-lastname")
	WebElement lastName;

	@FindBy(id = "input-company")
	WebElement companyName;

	@FindBy(id = "input-address-1")
	WebElement addressOne;

	@FindBy(id = "input-city")
	WebElement city;

	@FindBy(id = "input-postcode")
	WebElement postCode;

	@FindBy(id = "input-country")
	WebElement country;

	@FindBy(id = "input-zone")
	WebElement zone;

	@FindBy(css = "div.buttons.clearfix input")
	WebElement continueBtn;

	private void enterFirstName(String name) {
		Utility.sendText(firstName, name);
	}

	private void enterLastName(String name) {
		Utility.sendText(lastName, name);
	}

	private void enterCompany(String name) {
		Utility.sendText(companyName, name);
	}

	private void enterAddressOne(String name) {
		Utility.sendText(addressOne, name);
	}

	private void enterCity(String name) {
		Utility.sendText(city, name);
	}

	private void enterPostCode(String name) {
		Utility.sendText(postCode, name);
	}

	private void selectCountry(String name) {
		Utility.selectFromDropDownUsingVisibleText(country, name);
	}

	private void enterZone(String name) {
		Utility.selectFromDropDownUsingVisibleText(zone, name);
	}

	public AddressBookPage SubmitAddress(String name, String lastName, String company, String city, String address,
			String postalCode, String country, String zone) {
		enterFirstName(name);
		enterLastName(lastName);
		enterCompany(company);
		enterCity(city);
		enterAddressOne(address);
		enterPostCode(postalCode);
		selectCountry(country);
		enterZone(zone);
		continueBtn.click();

		return new AddressBookPage();
	}

}
