package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automationpractice.utilities.WebUtilitiesMethods;

public class SignInPage {
	private WebDriver driver;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By emailAddressField = By.id("email_create");
	By createAccountButton = By.id("SubmitCreate");
	By createAccountErrorMessage = By.id("create_account_error");
	
	By emailLogin = By.id("email");
	By passwordLogin = By.id("passwd");
	By loginButton = By.id("SubmitLogin");
	By loginErrorMessage = By.xpath("//*[@id='center_column']/div[1]/ol/li");
	
	public void fillEmailAddress(String newEmailAddres) {
		WebUtilitiesMethods.fillElement(driver, emailAddressField, newEmailAddres);
	}
	
	public void clickCreateAccountButton() {
		WebUtilitiesMethods.clickOnElement(driver, createAccountButton);
	}
	
	public String returnDuplicatedErrorMessage() {
		return WebUtilitiesMethods.returnTextElement(driver, createAccountErrorMessage);
	}
	
	public void fillEmailLogin(String emailLoginParameter) {
		WebUtilitiesMethods.fillElement(driver, emailLogin, emailLoginParameter);
	}
	
	public void fillPasswordLogin(String passwordLoginParameter) {
		WebUtilitiesMethods.fillElement(driver, passwordLogin, passwordLoginParameter);
	}
	
	public void clickLoginButton() {
		WebUtilitiesMethods.clickOnElement(driver, loginButton);
	}
	
	public String returnLoginErrorMessage() {
		return WebUtilitiesMethods.returnTextElement(driver, loginErrorMessage);
	}
}
