package com.qa.examples.seleniumcucumberexample.utils;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class SeleniumHooks {

	private WebDriver webDriver;
	private ScreenshotManager screenshotManager;
	
	@Before("@selenium")
	public void setup() throws Exception {
		if (webDriver == null) {
			webDriver = WebDriverFactory.getDriver();
		}
		screenshotManager = new ScreenshotManager();
	}
	
	@After("@selenium")
	public void teardown() {
		webDriver.quit();
	}
	
	public WebDriver getWebDriver() {
		return this.webDriver;
	}
	
	public ScreenshotManager getScreenshotManager() {
		return this.screenshotManager;
	}
}
