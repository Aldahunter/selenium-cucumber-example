package com.qa.examples.seleniumcucumberexample.swag_lab_pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SwagLabInventoryPage implements ISwagLabPage {
	public static final String URL = "https://www.saucedemo.com/inventory.html";
	private static final String EXPECTED_TITLE = "Swag Labs";
	
	private WebDriver webDriver;
	
	
	@Override
	public String getURL() { return URL; }
	@Override
	public String getExpectedTitle() { return EXPECTED_TITLE; }

	
	@FindBy(className = "inventory_item")
	private List<WebElement> inventoryItems;
	@FindBy(className = "shopping_cart_badge")
	private WebElement shoppingCartBadge;

	
	public SwagLabInventoryPage(WebDriver driver) {
		this.webDriver = driver;
		
		webDriver.get( getURL() );
		if (!webDriver.getTitle().equals( getExpectedTitle() )) {
			String exceptionMsg = String.format("The Swag Lab Home Page did not load (%f)", getURL());
			throw new IllegalStateException(exceptionMsg);
		}
	}

	
	public List<WebElement> getInventoryItems() {
		return inventoryItems;
	}
	
	private String getAddToCartButtonId(String itemName) {
		return "add-to-cart-" + itemName.strip().toLowerCase().replace(' ', '-');
	}
	
	private WebElement getAddToCartButton(String itemName) {
		return webDriver.findElement( By.id(getAddToCartButtonId(itemName)) );
	}
	
	public SwagLabInventoryPage addItemToCart(String itemName) {
		getAddToCartButton(itemName).click();
		return this;
	}
	
	public SwagLabInventoryPage addItemsToCart(List<String> itemNames) {
		for (String itemName : itemNames) {
			addItemToCart(itemName);
		}
		return this;
	}
	
	public int getNumberOfItemsInCart() {
		return Integer.parseInt(shoppingCartBadge.getText());
	}
}
