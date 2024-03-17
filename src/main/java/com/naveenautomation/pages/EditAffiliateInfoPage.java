package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.TestBases.TestBase;
import com.naveenautomation.utility.Utility;

public class EditAffiliateInfoPage extends TestBase {
	public EditAffiliateInfoPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-company")
	WebElement company;

	@FindBy(id = "input-website")
	WebElement website;

	@FindBy(id = "input-tax")
	WebElement taxId;

	@FindBy(id = "input-cheque")
	WebElement chequePayeeName;

	@FindBy(css = ".clearfix .pull-right input:first-of-type")
	WebElement agreeBtn;

	@FindBy(css = ".clearfix .pull-right input:last-of-type")
	WebElement continueBtn;

	private void enterCompanyName(String name) {
		Utility.sendText(company, name);
	}

	private void enterWebsite(String name) {
		Utility.sendText(website, name);
	}

	private void enterTaxId(String name) {
		Utility.sendText(taxId, name);
	}

	private void enterChequePayeeName(String name) {
		Utility.sendText(chequePayeeName, name);
	}

	public MyAccountPage submitAffiliateInformation(String company, String website, String taxId, String payeName) {
		enterCompanyName(company);
		enterWebsite(website);
		enterTaxId(taxId);
		enterChequePayeeName(payeName);
		Utility.clickOnElement(continueBtn);
		return new MyAccountPage();

	}

}
