package com.automationpractice.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import org.springframework.http.ResponseEntity;

import com.automationpractice.utilities.RestUtilitiesMethods;
import com.jayway.restassured.path.json.JsonPath;


public class RestStepsClass extends Steps {
	
	final static String BASE_URL = "https://swapi.co";
	final static String PEOPLE = "/api/people/";
	
	String URI = null;
	Boolean isResultFound = false;

	@Given("I create a get request to search for people")
	public void createRequestUri() {
		URI = BASE_URL + PEOPLE;
	}
	
	@When("I search for $valueSearch")
	public void sendRequest(@Named("valueSearch") String valueSearch) {
		String nextPage = URI;
		
		do {
			ResponseEntity<String> response = RestUtilitiesMethods.runRestRequest(nextPage);
			
			if (response.getBody().contains(valueSearch)) {
				isResultFound = true;
				break;
			}
			
			nextPage = JsonPath.from(response.getBody()).get("next");
			
		} while (nextPage!=null);
		
	}
	
	@Then("my search specification is found in the response")
	public void validate() {
		Assert.assertTrue("Result has not been found", isResultFound);
	}
}
