package com.qa.examples.seleniumcucumberexample.swag_lab_pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SwagLabUtilities {

	private SwagLabUtilities() {}
	
	public static ISwagLabPage getSwagLabPage(WebDriver webDriver, String gotoUrl) {
		switch (gotoUrl) {
			case SwagLabInventoryPage.URL:
				return PageFactory.initElements(webDriver, SwagLabInventoryPage.class);
			case SwagLabLoginPage.URL:
				return PageFactory.initElements(webDriver, SwagLabLoginPage.class);
			case SwagLabCartPage.URL:
				return PageFactory.initElements(webDriver, SwagLabCartPage.class);
			case SwagLabCheckoutInfoPage.URL:
					return PageFactory.initElements(webDriver, SwagLabCheckoutInfoPage.class);
			case SwagLabCheckoutOverviewPage.URL:
					return PageFactory.initElements(webDriver, SwagLabCheckoutOverviewPage.class);
			case SwagLabCheckoutCompletePage.URL:
					return PageFactory.initElements(webDriver, SwagLabCheckoutCompletePage.class);
			default:
				throw new IllegalStateException(String.format("No Swing Lab POM was found for '%s'", gotoUrl));
		}
	}
	
	public static ISwagLabPage getSwagLabPage(WebDriver webDriver, ISwagLabPage currentPage){
		String currentUrl = webDriver.getCurrentUrl();
		if ((currentPage != null) && currentUrl.equals( currentPage.getURL() )) { return currentPage; }
		else { return getSwagLabPage(webDriver, currentUrl); }
	}

}
