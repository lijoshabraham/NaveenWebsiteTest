package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.TestBases.TestBase;

public class EditAccountPage extends TestBase {
	public EditAccountPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-firstname")
	WebElement firstName;

	@FindBy(id = "input-lastname")
	WebElement lastName;

	@FindBy(css = ".clearfix input")
	WebElement submitBtn;

	private void enterFirstName(String firstName) {
		logger.info("Entering first name" + firstName);
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
	}

	private void enterLastName(String lastName) {
		logger.info("Entering last name" + lastName);
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
	}



	private void clickSubmitBtn() {
		submitBtn.click();
	}

	public MyAccountPage updateAccountDetails(String firstName, String lastName) {
		enterFirstName(firstName);
		enterLastName(lastName);
		clickSubmitBtn();
		return new MyAccountPage();

	}

}
