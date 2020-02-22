package com.pageFactoryInitializer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.pageObjectModel.LoginPageObjectModel;
import com.utility.CommonSeleniumMethods;


public class LoginPageFactory extends CommonSeleniumMethods {
	
	
	public LoginPageObjectModel loginPage()
	{
		return PageFactory.initElements(driver, LoginPageObjectModel.class);
	}

}
