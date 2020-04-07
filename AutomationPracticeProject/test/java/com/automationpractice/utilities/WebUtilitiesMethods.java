package com.automationpractice.utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebUtilitiesMethods {
	
	public static void clickOnElement(WebDriver driver, By locator) {
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
			driver.findElement(locator).click();
			
		} catch (Exception e) {
			Assert.fail("Failed to click on element locator '"+ locator +"'. Exception: " + e);
		}
	}
	
	public static void fillElement(WebDriver driver, By locator, String testData) {
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
			driver.findElement(locator).sendKeys(testData);
			
		} catch (Exception e) {
			Assert.fail("Failed to click on element locator '"+ locator +"'. Exception: " + e);
		}
	}
	
	public static String returnTextElement(WebDriver driver, By locator) {
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		String elementText = null;
		
		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
			elementText = driver.findElement(locator).getText();
			
		} catch (Exception e) {
			Assert.fail("Failed to click on element locator '"+ locator +"'. Exception: " + e);
		}
		
		return elementText;
	}
	
}
