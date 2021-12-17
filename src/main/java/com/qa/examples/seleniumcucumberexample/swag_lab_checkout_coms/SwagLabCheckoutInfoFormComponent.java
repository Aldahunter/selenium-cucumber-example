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
    @FindBy(id="last-name")
	WebElement lastnameInptBox;
    @FindBy(id="postal-code")
	WebElement postcodeInptBox;


    private String getInptBoxValue(WebElement inptBox) {
        return inptBox.getAttribute("value");
    }


    public SwagLabCheckoutPage enterFirstnameInptBox(String firstname) {
		firstnameInptBox.sendKeys(firstname);
		return parentPage;
	}
    public String getFirstnameInpt() {
        return getInptBoxValue(firstnameInptBox);
    }


    public SwagLabCheckoutPage enterLastnameInptBox(String lastname) {
        lastnameInptBox.sendKeys(lastname);
		return parentPage;
    }
    public String getLastnameInpt() {
        return getInptBoxValue(lastnameInptBox);
    }


    public SwagLabCheckoutPage enterPostcodeInptBox(String postcode) {
        postcodeInptBox.sendKeys(postcode);
		return parentPage;
    }
    public String getPostcodeInpt() {
        return getInptBoxValue(postcodeInptBox);
    }

}
