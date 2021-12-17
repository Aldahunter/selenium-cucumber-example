package com.qa.examples.seleniumcucumberexample.stepdefs;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.qa.examples.seleniumcucumberexample.swag_lab_pom.ISwagLabPage;
import com.qa.examples.seleniumcucumberexample.swag_lab_pom.SwagLabInventoryPage;
import com.qa.examples.seleniumcucumberexample.swag_lab_pom.SwagLabLoginPage;
import com.qa.examples.seleniumcucumberexample.swag_lab_pom.SwagLabUtilities;
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
		screenshotManager.takeAndSaveScreenshot(webDriver, screenshotDir + "0-userLoggedIn.png");
		assertEquals(SwagLabInventoryPage.URL, webDriver.getCurrentUrl());
	}
	
	
	@When("the user adds items to the cart")
	public void theUserAddsItemsToTheCart(io.cucumber.datatable.DataTable dataTable) throws IOException {
	    List<String> checkoutItems = dataTable.asList(String.class);
	    swagLabPage = ((SwagLabInventoryPage) swagLabPage).addItemsToCart(checkoutItems);
		screenshotManager.takeAndSaveScreenshot(webDriver, screenshotDir + "1-itemsAddedToCart.png");
	    assertEquals(checkoutItems.size(), ((SwagLabInventoryPage) swagLabPage).readShoppingCartBadge());
	}
	
	@When("the user navigates to the cart")
	public void theUserNavigatesToTheCart() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
		swagLabPage = ((SwagLabInventoryPage) swagLabPage).clickOnBasket();
	    assertEquals(SwagLabCartPage.URL, webDriver.getCurrentUrl());
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
