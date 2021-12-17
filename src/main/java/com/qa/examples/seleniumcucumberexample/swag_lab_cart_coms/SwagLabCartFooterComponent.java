package com.qa.examples.seleniumcucumberexample.swag_lab_cart_coms;

import com.qa.examples.seleniumcucumberexample.swag_lab_pom.ISwagLabPage;
import com.qa.examples.seleniumcucumberexample.swag_lab_pom.SwagLabCartPage;
import com.qa.examples.seleniumcucumberexample.swag_lab_pom.SwagLabUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SwagLabCartFooterComponent {

    WebDriver webDriver;
    SwagLabCartPage parentPage;

    public SwagLabCartFooterComponent(WebDriver driver, SwagLabCartPage parentPage) {
        this.webDriver = driver;
        this.parentPage = parentPage;
    }


	@FindBy(id="checkout")
	WebElement checkoutBtn;


    public ISwagLabPage clickCheckoutBtn() {
		checkoutBtn.click();
		return SwagLabUtilities.getSwagLabPage(webDriver, parentPage);
	}

}
