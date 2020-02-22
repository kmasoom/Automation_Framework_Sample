package com.utility;

import org.openqa.selenium.WebElement;

public class CommonSeleniumMethods extends BrowserFactory {
	
	public void sendKeys(WebElement element, String value) {
		try {
		element.sendKeys(value);
		} catch (Exception e) {

		}
		}

		public boolean click(WebElement element) {
		try {
		element.click();
		return true;
		} catch (Exception e) {

		}
		return false;
		}


}
