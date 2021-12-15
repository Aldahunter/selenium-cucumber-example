package com.qa.examples.seleniumcucumberexample.utils;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class WebDriverHooks {

	private WebDriver webDriver;
	
	@Before("@selenium")
	public void setup() throws Exception {
		if (webDriver == null) {
			webDriver = WebDriverFactory.getDriver();
		}
	}
	
	@After("@selenium")
	public void teardown() {
		webDriver.quit();
	}
	
	public WebDriver getWebDriver() {
		return this.webDriver;
	}
}
