package com.qa.examples.seleniumcucumberexample.stepdefs;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.qa.examples.seleniumcucumberexample.utils.SeleniumHooks;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BingStepDefinitions {
	
	private WebDriver webDriver;
	
	// constructor injection
	public BingStepDefinitions(SeleniumHooks hooks) {
		this.webDriver = hooks.getWebDriver();
	}
	
	@When("the user requests {word}")
	public void theUserRequests(String site) {
	    webDriver.get(site);
	}

	@Then("the user should be on the Bing home page")
	public void theUserShouldBeOnTheBingHomePage() {
		assertEquals("Bing", webDriver.getTitle());
	}
}
