package com.automationpractice.steps;

import java.util.concurrent.TimeUnit;

import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.MyAccountPage;
import com.automationpractice.pages.RegisterPage;
import com.automationpractice.pages.SignInPage;

public class WebStepsClass extends Steps {

	private static WebDriver driver;

	@BeforeScenario()
	public void beforeScenario() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver","test/java/chromedriver.exe");		
			ChromeOptions options = new ChromeOptions();
			DesiredCapabilities capabilities = new DesiredCapabilities();
			options.addArguments("--disable-extensions");
			options.addArguments("--incognito");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			options.merge(capabilities);
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}

	}
	
	@Given("I navigate to Home page")
	public void navigateToHome() {
		driver.get("http://automationpractice.com/index.php");
	}
	
	@Given("I navigate to Register New Account for $emailAddressRegister")
	@When("I navigate to Register duplicated account for $emailAddressRegister")
	public void clickOnSignIn(@Named("emailAddressRegister") String emailAddressRegister) {
		HomePage homePage = new HomePage(driver);
		homePage.clickSignInButton();
		
		SignInPage signInPage = new SignInPage(driver);
		signInPage.fillEmailAddress(emailAddressRegister);
		signInPage.clickCreateAccountButton();
	}
	
	@When("I fill my details in the Register form")
	public void fillDetailsRegisterForm() {
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.fillFirstName();
		registerPage.fillLastName();
		registerPage.fillPassword();
		registerPage.fillAddress();
		registerPage.fillCity();
		registerPage.fillState();
		registerPage.fillPostalCode();
		registerPage.fillMobilePhone();
		
	}
	
	@When("I submit the Register New Account")
	public void submitRegisterFormNewAccount() {
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.clickRegisterButton();
	}
	
	@When("I Sign in with user $emailAddressRegister")
	public void logOnApplication(@Named("emailAddressRegister") String emailLogin) {
		HomePage homePage = new HomePage(driver);
		homePage.clickSignInButton();
		
		SignInPage signInPage = new SignInPage(driver);
		signInPage.fillEmailLogin(emailLogin);
		signInPage.fillPasswordLogin("54321");
		signInPage.clickLoginButton();
		
	}
	
	@When("I log with only my email $emailAddressRegister")
	public void logOnApplicationEmailOnly(@Named("emailAddressRegister") String emailLogin) {
		HomePage homePage = new HomePage(driver);
		homePage.clickSignInButton();
		
		SignInPage signInPage = new SignInPage(driver);
		signInPage.fillEmailLogin(emailLogin);
		signInPage.clickLoginButton();
		
	}
	
	@Then("my account is registered successfully")
	public void validateAccountCreatedSuccessfully() {
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		String currentLoggedUserLabelText = myAccountPage.getCurrentUserLogged(driver);
		
		myAccountPage.clickOnSignOutButton();
		
		Assert.assertEquals("Scenario failed, expected User: 'Jhon Stewart' but found User: "
							+ currentLoggedUserLabelText 
							, "Jhon Stewart", currentLoggedUserLabelText);
	}
	
	@Then("I receive an error message indicating the email address is already registered")
	public void validateDuplicatedAccountErrorMessage() {
		SignInPage signInPage = new SignInPage(driver);
		String duplicatedErrorMessage =	signInPage.returnDuplicatedErrorMessage();
		Assert.assertEquals("Scenario failed, expected error message: An account using this email address has already been registered. Please enter a valid password or request a new one."
							+ " but found the following: " + duplicatedErrorMessage,
							"An account using this email address has already been registered. Please enter a valid password or request a new one.",
							duplicatedErrorMessage);
	}
	
	@Then("I am unable to log on the application")
	public void validateUnableToLogin() {
		SignInPage signInPage = new SignInPage(driver);
		String authenticationErrorMessage = signInPage.returnLoginErrorMessage();
		
		Assert.assertNotNull("Scenario failed, expected error message: 'Authentication failed.' or 'Password is required.'"
							+ " but there was no error message", authenticationErrorMessage);
	}
	
	@AfterStory
	public void afterStory() {
		driver.quit();
	}

}
