package com.naveenautomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenautomation.TestBases.TestBase;

public class Utility extends TestBase {

	//Explicit wait
	public static WebElement waitForElementClickable(WebDriver driver, WebElement element, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

    public static WebElement waitForVisibilityOfElement(WebDriver driver, By by, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static WebElement waitForVisibilityOfElement(WebDriver driver, WebElement element, int timeoutInSeconds) {
        By by = getByFromWebElement(element);
        return waitForVisibilityOfElement(driver, by, timeoutInSeconds);
    }
    
    public static void waitForAlert(WebDriver driver, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.alertIsPresent());
    }
	

	public static void takeFailedTestScreenShot(String testCaseName) {
		// Get the current date and Time
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		// Save the screen shot in a file
		File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Save the screenshot
		try {
			FileUtils.copyFile(screenShotFile,
					new File("./FailedScreenShot\\" + "_" + testCaseName + "_" + timeStamp + ".jpeg"));
		} catch (IOException e) {
			System.out.println("Unable to save or take screen shot of failed test " + testCaseName);

		}

	}

	public static String generateRandomEmail() {
		String email = RandomStringUtils.randomNumeric(3);
		String emailID = "Lijosh" + email + "@gmail.com";
		return emailID;
	}

	public static int generateRandomInt(int length) {
		Random random = new Random();
		return random.nextInt(length);
	}

	public static String generateRandomString(int length) {

		String uuid = UUID.randomUUID().toString();
		return uuid.replaceAll("-", "").substring(0, length);
	}

	public static Date generateRandomDate() {
		return new Date();
	}

	public static String generateRandomPassword() {
		String randomStringForPassword = RandomStringUtils.randomNumeric(3);
		String password = "Manager@" + randomStringForPassword;
		return password;
	}

	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {

		}
	}
	
	private static By getByFromWebElement(WebElement element) {
	    String[] elementDetails = element.toString().split(" -> ")[1]
	            .replaceFirst("(?s)(.*)\\]", "$1")
	            .split(": ");
	    
	    String locatorType = elementDetails[0].trim();
	    String locatorValue = elementDetails[1].trim();

	    switch (locatorType) {
	        case "id":
	            return By.id(locatorValue);
	        case "name":
	            return By.name(locatorValue);
	        case "xpath":
	            return By.xpath(locatorValue);
	        case "css selector":
	            return By.cssSelector(locatorValue);
	        case "tag name":
	            return By.tagName(locatorValue);
	        case "link text":
	            return By.linkText(locatorValue);
	        case "partial link text":
	            return By.partialLinkText(locatorValue);
	        case "class name":
	            return By.className(locatorValue);
	        default:
	            throw new IllegalArgumentException("Unsupported locator type: " + locatorType);
	    }
	}

}
