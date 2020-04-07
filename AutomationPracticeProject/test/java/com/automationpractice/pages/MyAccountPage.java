package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automationpractice.utilities.WebUtilitiesMethods;

public class MyAccountPage {
	private WebDriver driver;
	
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By userLoggedLabel = By.className("account");
	By signOutButton = By.xpath("//*[@id='header']/div[2]/div/div/nav/div[2]");
	
	public String getCurrentUserLogged(WebDriver driver) {
		return WebUtilitiesMethods.returnTextElement(driver, userLoggedLabel);
	}
	
	public void clickOnSignOutButton() {
		WebUtilitiesMethods.clickOnElement(driver, signOutButton);
	}
	
}
