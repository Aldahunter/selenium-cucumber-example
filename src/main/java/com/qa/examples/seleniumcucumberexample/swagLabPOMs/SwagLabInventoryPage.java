package com.qa.examples.seleniumcucumberexample.swagLabPOMs;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SwagLabInventoryPage implements ISwagLabPage {
	public static final String URL = "https://www.saucedemo.com/inventory.html";
	private static final String expectedTitle = "Swag Labs";
	
	private WebDriver webDriver;
	
	
	@Override
	public String getURL() { return URL; }
	@Override
	public String getExpectedTitle() { return expectedTitle; }

	
	@FindBy(className = "inventory_item")
	private List<WebElement> inventoryItems;

	
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
}
