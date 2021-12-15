package com.qa.examples.seleniumcucumberexample.stepdefs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.qa.examples.seleniumcucumberexample.swagLabPOMs.ISwagLabPage;
import com.qa.examples.seleniumcucumberexample.swagLabPOMs.SwagLabHomePage;
import com.qa.examples.seleniumcucumberexample.swagLabPOMs.SwagLabLoginPage;
import com.qa.examples.seleniumcucumberexample.swagLabPOMs.SwagLabUtilites;
import com.qa.examples.seleniumcucumberexample.utils.ScreenshotManager;
import com.qa.examples.seleniumcucumberexample.utils.SeleniumHooks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SwagLabsUserLoginsStepDefinitions {
	
	private WebDriver webDriver;
	private ScreenshotManager screenshotManager;
	private ISwagLabPage swagLabPage;
	
	private String screenshotDir = ".\\target\\featureScreenshots\\SwagLabsUserLogins\\";
	
	private String username;
	private String password;
	
	// constructor injection
	public SwagLabsUserLoginsStepDefinitions(SeleniumHooks hooks) {
		this.webDriver = hooks.getWebDriver();
		this.screenshotManager = hooks.getScreenshotManager();
	}
	
	@Given("the users username {string}")
	public void the_users_username(String username) {
	    this.username = username;
	}

	@Given("password {string}")
	public void password(String password) {
		this.password = password;
	}
	

	@When("the user requests {string}")
	public void the_user_requests(String url) throws IOException {
		swagLabPage = SwagLabUtilites.getSwagLabPage(webDriver, url);
		screenshotManager.takeAndSaveScreenshot(webDriver, screenshotDir + "successfulLoginTest - Pre Login Page.png");
		assertEquals(webDriver.getCurrentUrl(), url);
	}

	@When("enters their login details")
	public void enters_their_login_details() throws IOException, InterruptedException {
		swagLabPage = ((SwagLabLoginPage)swagLabPage).login(username, password);
	}
	

	@Then("they successfully login")
	public void they_successfully_login() throws IOException {
		screenshotManager.takeAndSaveScreenshot(webDriver, screenshotDir + "successfulLoginTest - Post Login Page.png");
		assertTrue(((SwagLabHomePage)swagLabPage).getInventoryItems().size() > 0);
	}
	
	@Then("they cannot login")
	public void they_cannot_login() {
	    assertEquals(webDriver.getCurrentUrl(), SwagLabLoginPage.URL);
	}

	@Then("are told error {string}")
	public void are_told(String errorMsg) {
		assertEquals(errorMsg, ((SwagLabLoginPage)swagLabPage).getErrorMessage());
	}
	
}
