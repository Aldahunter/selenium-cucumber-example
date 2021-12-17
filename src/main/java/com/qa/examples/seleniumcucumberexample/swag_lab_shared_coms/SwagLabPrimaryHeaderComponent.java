package com.qa.examples.seleniumcucumberexample.swag_lab_shared_coms;

import com.qa.examples.seleniumcucumberexample.swag_lab_pom.ISwagLabPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SwagLabPrimaryHeaderComponent {

    WebDriver webDriver;
    ISwagLabPage parentPage;

    public SwagLabPrimaryHeaderComponent(WebDriver driver, ISwagLabPage parentPage) {
        this.webDriver = driver;
        this.parentPage = parentPage;
    }

    @FindBy(id="bm-burger-button")
    WebElement burgerMenu;
    @FindBy(className="shopping_cart_link")
    WebElement shoppingCartLink;
    @FindBy(className="shopping_cart_badge")
    WebElement shoppingCartBardge;


    public int readShoppingCartBadge() {
        return Integer.parseInt(shoppingCartBardge.getText().strip());
    }

    public void clickOnShoppingCart() {
        shoppingCartLink.click();
    }

}
