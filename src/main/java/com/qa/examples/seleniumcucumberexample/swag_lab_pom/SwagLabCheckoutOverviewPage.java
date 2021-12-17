package com.qa.examples.seleniumcucumberexample.swag_lab_pom;

import com.qa.examples.seleniumcucumberexample.swag_lab_checkout_coms.SwagLabCheckoutFooterComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SwagLabCheckoutOverviewPage implements ISwagLabPage {
	
	public static final String URL = "https://www.saucedemo.com/checkout-step-two.html";
	public static final String EXPECTED_TITLE = "Swag Labs";
	private WebDriver webDriver;

	@Override
	public String getURL() { return URL; }

	
	private SwagLabCheckoutFooterComponent checkoutFooter;

	 
	public SwagLabCheckoutOverviewPage(WebDriver driver) {
		this.webDriver = driver;
		
		webDriver.get(URL);
		if (!webDriver.getTitle().equals(EXPECTED_TITLE)) {
			String exceptionMsg = String.format("The Swag Lab Cart Page did not load (%f)", URL);
			throw new IllegalStateException(exceptionMsg);
		}

		checkoutFooter = new SwagLabCheckoutFooterComponent(webDriver, this);
		PageFactory.initElements(webDriver, checkoutFooter);
	}


    public SwagLabCheckoutCompletePage clickFinishBtn() {
        return (SwagLabCheckoutCompletePage) checkoutFooter.clickFinishBtn();
    }

}
