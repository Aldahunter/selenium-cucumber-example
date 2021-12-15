package com.qa.examples.seleniumcucumberexample.stepdefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.qa.examples.seleniumcucumberexample.swagLabPOMs.ISwagLabPage;
import com.qa.examples.seleniumcucumberexample.swagLabPOMs.SwagLabInventoryPage;
import com.qa.examples.seleniumcucumberexample.swagLabPOMs.SwagLabLoginPage;
import com.qa.examples.seleniumcucumberexample.swagLabPOMs.SwagLabUtilities;
import com.qa.examples.seleniumcucumberexample.utils.ScreenshotManager;
import com.qa.examples.seleniumcucumberexample.utils.SeleniumHooks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SwagLabsCheckoutStepDefinitions {
	
	WebDriver webDriver;
	ISwagLabPage swagLabPage;
	ScreenshotManager screenshotManager;
	String screenshotDir = ".\\target\\featureScreenshots\\SwagLabsCheckout\\";
	
	public SwagLabsCheckoutStepDefinitions(SeleniumHooks hooks) {
		this.webDriver = hooks.getWebDriver();
		this.screenshotManager = hooks.getScreenshotManager();
	}
	
	@Given("the user is logged in as {string}:{string}")
	public void theUserIsLoggedInAs(String username, String password) throws IOException {
		swagLabPage = SwagLabUtilities.getSwagLabPage(webDriver, SwagLabLoginPage.URL);
		swagLabPage = ((SwagLabLoginPage) swagLabPage).login(username, password);
		screenshotManager.takeAndSaveScreenshot(webDriver, screenshotDir + "0-successfulLoginTest.png");
		assertEquals(webDriver.getCurrentUrl(), SwagLabInventoryPage.URL);
	}
	
	
	@When("the user adds items to the cart")
	public void theUserAddsItemsToTheCart(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("the user navigates to the cart")
	public void theUserNavigatesToTheCart() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("the user proceeds to checkout")
	public void theUserProceedsToCheckout() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("the user enters their details")
	public void theUserEntersTheirDetails() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("the user proceeds to checkout overview")
	public void theUserProceedsToCheckoutOverview() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("the user confirms the transaction")
	public void theUserConfirmsTheTransaction() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
	@Then("a purchase verification should appear on the screen saying {string}")
	public void aPurchaseVerificationShouldAppearOnTheScreenSaying(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
