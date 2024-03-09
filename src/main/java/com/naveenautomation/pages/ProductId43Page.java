package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.TestBases.TestBase;

public class ProductId43Page extends TestBase {
	public ProductId43Page() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".form-group button")
	WebElement addtoCartBtn;

	@FindBy(css = "#content .btn-group button:first-of-type")
	WebElement addtoWishListBtn;

	@FindBy(css = "#product-product>div:first-of-type")
	WebElement successAlert;

	public void clickAddtoCartBtn() {

		addtoCartBtn.click();
	}

	public void clickAddtoWishListBtn() {

		addtoWishListBtn.click();
	}

	public String getSuccessAlert() {

		return successAlert.getText();
	}

}
