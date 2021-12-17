package com.qa.examples.seleniumcucumberexample.swag_lab_checkout_coms;

import com.qa.examples.seleniumcucumberexample.swag_lab_pom.SwagLabCheckoutCompletePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SwagLabCheckoutCompleteContainerComponent {

    WebDriver webDriver;
    SwagLabCheckoutCompletePage parentPage;

    public SwagLabCheckoutCompleteContainerComponent(WebDriver driver, SwagLabCheckoutCompletePage swagLabCheckoutCompletePage) {
        this.webDriver = driver;
        this.parentPage = swagLabCheckoutCompletePage;
    }


	@FindBy(className = "complete-header")
	WebElement orderCompleteMsg;


    public String getOrderCompleteMsg() {
        return orderCompleteMsg.getText();
    }

}
