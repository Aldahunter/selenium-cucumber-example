package com.qa.examples.seleniumcucumberexample.swag_lab_pom;

import org.openqa.selenium.WebDriver;

public class SwagLabCheckoutCompletePage implements ISwagLabPage {
	
	public static final String URL = "https://www.saucedemo.com/checkout-complete.html";
	public static final String EXPECTED_TITLE = "Swag Labs";
	private WebDriver webDriver;

	@Override
	public String getURL() { return URL; }

	
	public SwagLabCheckoutCompletePage(WebDriver driver) {
		this.webDriver = driver;
		
		webDriver.get(URL);
		if (!webDriver.getTitle().equals(EXPECTED_TITLE)) {
			String exceptionMsg = String.format("The Swag Lab Cart Page did not load (%f)", URL);
			throw new IllegalStateException(exceptionMsg);
		}
	}

}
