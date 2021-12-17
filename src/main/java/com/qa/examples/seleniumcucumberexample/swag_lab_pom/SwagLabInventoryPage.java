package com.qa.examples.seleniumcucumberexample.swag_lab_pom;

import java.util.List;

import com.qa.examples.seleniumcucumberexample.swag_lab_inventory_coms.SwagLabInventoryItemsComponent;
import com.qa.examples.seleniumcucumberexample.swag_lab_shared_coms.SwagLabPrimaryHeaderComponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabInventoryPage implements ISwagLabPage {
	
	public static final String URL = "https://www.saucedemo.com/inventory.html";
	public static final String EXPECTED_TITLE = "Swag Labs";
	private WebDriver webDriver;

	@Override
	public String getURL() { return URL; }

	
	@FindBy(className = "inventory_item")
	private List<WebElement> inventoryItems;
	@FindBy(className = "shopping_cart_badge")
	private WebElement shoppingCartBadge;
	
	private SwagLabPrimaryHeaderComponent primaryHeader;
	private SwagLabInventoryItemsComponent productsTable;

	 
	public SwagLabInventoryPage(WebDriver driver) {
		this.webDriver = driver;
		
		webDriver.get(URL);
		if (!webDriver.getTitle().equals(EXPECTED_TITLE)) {
			String exceptionMsg = String.format("The Swag Lab Home Page did not load (%f)", URL);
			throw new IllegalStateException(exceptionMsg);
		}

		primaryHeader = new SwagLabPrimaryHeaderComponent(webDriver, this);
		PageFactory.initElements(webDriver, primaryHeader);
		productsTable = new SwagLabInventoryItemsComponent(webDriver, this);
		PageFactory.initElements(webDriver, productsTable);
	}

	
	public SwagLabInventoryPage addItemToCart(String itemName) {
		return productsTable.addItemToCart(itemName);
	}
	
	public SwagLabInventoryPage addItemsToCart(List<String> itemNames) {
		return productsTable.addItemsToCart(itemNames);
	}
	
	public int readShoppingCartBadge() {
		return primaryHeader.readShoppingCartBadge();
	}
}
