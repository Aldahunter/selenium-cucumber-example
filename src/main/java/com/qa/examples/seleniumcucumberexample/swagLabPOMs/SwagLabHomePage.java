package com.qa.examples.seleniumcucumberexample.swagLabPOMs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SwagLabHomePage implements ISwagLabPage {
	public static final String URL = "https://www.saucedemo.com/inventory.html";
	public static final String expectedTitle = "Swag Labs";
	@Override
	public String getURL() { return URL; }
	@Override
	public String getExpectedTitle() { return expectedTitle; }

	private WebDriver driver;

	private By inventoryItemDivSelector = By.className("inventory_item");
	

	public SwagLabHomePage(WebDriver driver) {
		this.driver = driver;
		
		driver.get( getURL() );

		if (!driver.getTitle().equals( getExpectedTitle() )) {
			String exceptionMsg = String.format("The Swag Lab Home Page did not load (%f)", getURL());
			throw new IllegalStateException(exceptionMsg);
		}
	}

	public List<WebElement> getInventoryItems() {
		return driver.findElements(inventoryItemDivSelector);
	}
}
