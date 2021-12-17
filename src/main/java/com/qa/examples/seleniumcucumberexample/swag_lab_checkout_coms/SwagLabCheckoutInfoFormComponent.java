package com.qa.examples.seleniumcucumberexample.swag_lab_checkout_coms;

import com.qa.examples.seleniumcucumberexample.swag_lab_pom.SwagLabCheckoutPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SwagLabCheckoutInfoFormComponent {

    WebDriver webDriver;
    SwagLabCheckoutPage parentPage;

    public SwagLabCheckoutInfoFormComponent(WebDriver driver, SwagLabCheckoutPage swagLabCheckoutPage) {
        this.webDriver = driver;
        this.parentPage = swagLabCheckoutPage;
    }


	@FindBy(id="first-name")
	WebElement firstnameInptBox;


    public SwagLabCheckoutPage enterFirstnameInptBox(String firstname) {
		firstnameInptBox.sendKeys(firstname);
		return parentPage;
	}

    public String getFirstnameInpt() {
        return firstnameInptBox.getAttribute("value");
    }

}
