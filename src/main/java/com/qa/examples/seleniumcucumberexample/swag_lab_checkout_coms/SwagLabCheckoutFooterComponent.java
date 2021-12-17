package com.qa.examples.seleniumcucumberexample.swag_lab_checkout_coms;

import com.qa.examples.seleniumcucumberexample.swag_lab_pom.ISwagLabPage;
import com.qa.examples.seleniumcucumberexample.swag_lab_pom.SwagLabCheckoutInfoPage;
import com.qa.examples.seleniumcucumberexample.swag_lab_pom.SwagLabCheckoutOverviewPage;
import com.qa.examples.seleniumcucumberexample.swag_lab_pom.SwagLabUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SwagLabCheckoutFooterComponent {

    WebDriver webDriver;
    ISwagLabPage parentPage;

    public SwagLabCheckoutFooterComponent(WebDriver driver, SwagLabCheckoutInfoPage swagLabCheckoutPage) {
        this.webDriver = driver;
        this.parentPage = swagLabCheckoutPage;
    }
    public SwagLabCheckoutFooterComponent(WebDriver driver, SwagLabCheckoutOverviewPage swagLabCheckoutPage) {
        this.webDriver = driver;
        this.parentPage = swagLabCheckoutPage;
    }


	@FindBy(id="continue")
	WebElement continueBtn;
    @FindBy(id="finish")
	WebElement finishBtn;


    public ISwagLabPage clickContinueBtn() {
        continueBtn.click();
        return SwagLabUtilities.getSwagLabPage(webDriver, parentPage);
    }
    public ISwagLabPage clickFinishBtn() {
        finishBtn.click();
        return SwagLabUtilities.getSwagLabPage(webDriver, parentPage);
    }

}
