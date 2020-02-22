package com.pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utility.CommonSeleniumMethods;

public class LoginPageObjectModel {

	CommonSeleniumMethods methods = new CommonSeleniumMethods();
	@FindBy(name = "username")
	private WebElement userName;
	@FindBy(name = "password")
	private WebElement password;
	@FindBy(id = "tdb1")
	private WebElement loginBtn;

	public LoginPageObjectModel enterUserName(String value) {
	methods.sendKeys(userName, value);
	return this;
	}

	public LoginPageObjectModel enterPassword(String value) {
	methods.sendKeys(password, value);
	return this;
	}

	public LoginPageObjectModel clickLogin() {
	methods.click(loginBtn);
	return this;
	}
}
