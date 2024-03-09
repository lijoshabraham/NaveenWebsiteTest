package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.TestBases.TestBase;

public class RewardPointsPage extends TestBase {
	public RewardPointsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#content h1")
	WebElement rewardPointsHeading;

	public String getRewardPointsHeading() {
		return rewardPointsHeading.getText();
	}

}
