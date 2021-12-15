package com.qa.examples.seleniumcucumberexample.swagLabPOMs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwagLabLoginPage implements ISwagLabPage {
	public static final String URL = "https://www.saucedemo.com/";
	public static final String expectedTitle = "Swag Labs";
	@Override
	public String getURL() { return URL; }
	@Override
	public String getExpectedTitle() { return expectedTitle; }

	private WebDriver driver;
	
	private By usenameInpSelector = By.id("user-name");
	private By passwordInpSelector = By.id("password");
	private By loginBtnSelector = By.id("login-button");
	private By errorMsgSelector = By.cssSelector("h3[data-test='error']");
	
	
	public SwagLabLoginPage(WebDriver driver) {
		this.driver = driver;
		
		driver.get( getURL() );
		
		if (!driver.getTitle().equals( getExpectedTitle() )) {
			String exceptionMsg = String.format("The Swag Lab Login Page did not load (%f)", getURL() );
			throw new IllegalStateException(exceptionMsg);
		}
	}
	
	
	public SwagLabLoginPage enterLoginDetailslogin(String username, String password) {
		driver.findElement(usenameInpSelector).sendKeys(username);
		driver.findElement(passwordInpSelector).sendKeys(password);
		return this;
	}
	
	public ISwagLabPage clickLoginButton() {
		driver.findElement(loginBtnSelector).click();
		return SwagLabUtilites.getSwagLabPage(this, driver);
	}
	
	
	public ISwagLabPage login(String username, String password) {
		return enterLoginDetailslogin(username, password).clickLoginButton();
	}
	
	public String getErrorMessage() {
		return driver.findElement(errorMsgSelector).getText();
	}

}
