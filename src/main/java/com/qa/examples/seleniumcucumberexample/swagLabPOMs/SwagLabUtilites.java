package com.qa.examples.seleniumcucumberexample.swagLabPOMs;

import org.openqa.selenium.WebDriver;

class SwagLabUtilites {
	
	static public ISwagLabPage getSwagLabPage(ISwagLabPage currentPage, WebDriver webDriver){
		String newUrl = webDriver.getCurrentUrl();
		
		if (newUrl.equals(currentPage.getURL())) { return currentPage; }
		
		switch (newUrl) {
			case SwagLabHomePage.URL:
				return new SwagLabHomePage(webDriver);
			case SwagLabLoginPage.URL:
				return new SwagLabLoginPage(webDriver);
			default:
				throw new IllegalStateException(String.format("No Swing Lab POM was found for '%s'", newUrl));
		}
	}

}
