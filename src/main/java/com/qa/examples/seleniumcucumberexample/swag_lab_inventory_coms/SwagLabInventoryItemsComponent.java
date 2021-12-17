package com.qa.examples.seleniumcucumberexample.swag_lab_inventory_coms;

import java.util.List;

import com.qa.examples.seleniumcucumberexample.swag_lab_pom.SwagLabInventoryPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SwagLabInventoryItemsComponent {

    WebDriver webDriver;
    SwagLabInventoryPage parentPage;

    public SwagLabInventoryItemsComponent(WebDriver driver, SwagLabInventoryPage parentPage) {
        this.webDriver = driver;
        this.parentPage = parentPage;
    }


    private String getAddToCartButtonId(String itemName) {
		return "add-to-cart-" + itemName.strip().toLowerCase().replace(' ', '-');
	}
	
	private WebElement getAddToCartButton(String itemName) {
		return webDriver.findElement( By.id(getAddToCartButtonId(itemName)) );
	}
	
	public SwagLabInventoryPage addItemToCart(String itemName) {
		getAddToCartButton(itemName).click();
		return parentPage;
	}
	
	public SwagLabInventoryPage addItemsToCart(List<String> itemNames) {
		for (String itemName : itemNames) {
			addItemToCart(itemName);
		}
		return parentPage;
	}

}
