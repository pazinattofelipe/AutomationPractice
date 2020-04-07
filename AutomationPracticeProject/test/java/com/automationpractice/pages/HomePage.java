package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automationpractice.utilities.WebUtilitiesMethods;

public class HomePage {
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By signInButton = By.className("login");
	
	public void clickSignInButton() {
		WebUtilitiesMethods.clickOnElement(driver, signInButton);
	}
}
