package com.qa.examples.seleniumcucumberexample.swagLabPOMs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SwagLabUtilites {
	
	static public ISwagLabPage getSwagLabPage(WebDriver webDriver, String gotoUrl) {
		switch (gotoUrl) {
			case SwagLabHomePage.URL:
				return PageFactory.initElements(webDriver, SwagLabHomePage.class);
			case SwagLabLoginPage.URL:
				return PageFactory.initElements(webDriver, SwagLabLoginPage.class);
			default:
				throw new IllegalStateException(String.format("No Swing Lab POM was found for '%s'", gotoUrl));
		}
	}
	
	static public ISwagLabPage getSwagLabPage(WebDriver webDriver, ISwagLabPage currentPage){
		String currentUrl = webDriver.getCurrentUrl();
		if ((currentPage != null) && currentUrl.equals( currentPage.getURL() )) { return currentPage; }
		else { return getSwagLabPage(webDriver, currentUrl); }
	}

}
