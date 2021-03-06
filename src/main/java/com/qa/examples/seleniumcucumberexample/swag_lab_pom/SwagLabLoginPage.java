package com.qa.examples.seleniumcucumberexample.swag_lab_pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SwagLabLoginPage implements ISwagLabPage {
	
	public static final String URL = "https://www.saucedemo.com/";
	public static final String EXPECTED_TITLE = "Swag Labs";
	private WebDriver webDriver;

	@Override
	public String getURL() { return URL; }
	
	
	@FindBy(id="user-name")
	private WebElement usernameInp;
	@FindBy(id="password")
	private WebElement passwordInp;
	@FindBy(id="login-button")
	private WebElement loginBtn;
	@FindBy(css="h3[data-test='error']")
	private WebElement errorMsg;
	
	
	public SwagLabLoginPage(WebDriver driver) {
		this.webDriver = driver;
		
		webDriver.get(URL);
		if (!webDriver.getTitle().equals(EXPECTED_TITLE)) {
			String exceptionMsg = String.format("The Swag Lab Login Page did not load (%f)", URL);
			throw new IllegalStateException(exceptionMsg);
		}
	}
	
	
	public SwagLabLoginPage enterLoginDetailslogin(String username, String password) {
		Actions loginDetailsActions = new Actions(webDriver);
		loginDetailsActions.sendKeys(usernameInp, username).sendKeys(passwordInp, password).perform();
		return this;
	}
	
	public ISwagLabPage clickLoginButton() {
		Actions loginButtonActions = new Actions(webDriver);
		loginButtonActions.click(loginBtn).perform();
		return SwagLabUtilities.getSwagLabPage(webDriver, this);
	}
	
	
	public ISwagLabPage login(String username, String password) {
		return enterLoginDetailslogin(username, password).clickLoginButton();
	}
	
	public String getErrorMessage() {
		return errorMsg.getText();
	}

}
