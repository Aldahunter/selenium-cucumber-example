package com.qa.examples.seleniumcucumberexample.swag_lab_pom;

import com.qa.examples.seleniumcucumberexample.swag_lab_checkout_coms.SwagLabCheckoutInfoFormComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SwagLabCheckoutPage implements ISwagLabPage {
	
	public static final String URL = "https://www.saucedemo.com/checkout-step-one.html";
	public static final String EXPECTED_TITLE = "Swag Labs";
	private WebDriver webDriver;

	@Override
	public String getURL() { return URL; }

	
	private SwagLabCheckoutInfoFormComponent checkoutInfoForm;

	 
	public SwagLabCheckoutPage(WebDriver driver) {
		this.webDriver = driver;
		
		webDriver.get(URL);
		if (!webDriver.getTitle().equals(EXPECTED_TITLE)) {
			String exceptionMsg = String.format("The Swag Lab Cart Page did not load (%f)", URL);
			throw new IllegalStateException(exceptionMsg);
		}

		checkoutInfoForm = new SwagLabCheckoutInfoFormComponent(webDriver, this);
		PageFactory.initElements(webDriver, checkoutInfoForm);
	}


	public SwagLabCheckoutPage enterFirstname(String firstname) {
		return checkoutInfoForm.enterFirstnameInptBox(firstname);
	}
	public String getFirstnameInpt() {
		return checkoutInfoForm.getFirstnameInpt();
	}


	public SwagLabCheckoutPage enterLastname(String lastname) {
		return checkoutInfoForm.enterLastnameInptBox(lastname);
	}
    public String getLastnameInpt() {
		return checkoutInfoForm.getLastnameInpt();
    }


	public SwagLabCheckoutPage enterPostcode(String postcode) {
		return checkoutInfoForm.enterPostcodeInptBox(postcode);
	}
    public String getPostcodeInpt() {
		return checkoutInfoForm.getPostcodeInpt();
    }
}
