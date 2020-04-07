package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.automationpractice.utilities.WebUtilitiesMethods;

public class RegisterPage {
	private WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By firstName = By.id("customer_firstname");
	By lastName = By.id("customer_lastname");
	By password = By.id("passwd");
	By addressFirstName = By.id("firstname");
	By addressLastName = By.id("lastname");
	By address = By.id("address1");
	By city = By.id("city");
	By state = By.id("id_state");
	By postalCode = By.id("postcode");
	By mobilePhone = By.id("phone_mobile");
	By registerButton = By.id("submitAccount");
	
	public void fillFirstName() {
		WebUtilitiesMethods.fillElement(driver, firstName, "Jhon");
	}
	
	public void fillLastName() {
		WebUtilitiesMethods.fillElement(driver, lastName, "Stewart");
	}
	
	public void fillPassword() {
		WebUtilitiesMethods.fillElement(driver, password, "1234ABCD");
	}
	
	public void fillAddress() {
		WebUtilitiesMethods.fillElement(driver, address, "Street Address");
	}
	
	public void fillCity() {
		WebUtilitiesMethods.fillElement(driver, city, "New York");
	}
	
	public void fillState() {
		new Select(driver.findElement(state)).selectByVisibleText("New York");
	}
	
	public void fillPostalCode() {
		WebUtilitiesMethods.fillElement(driver, postalCode, "12345");
	}
	
	public void fillMobilePhone() {
		WebUtilitiesMethods.fillElement(driver, mobilePhone, "12457856");
	}
	
	public void clickRegisterButton() {
		WebUtilitiesMethods.clickOnElement(driver, registerButton);
	}
	
}
