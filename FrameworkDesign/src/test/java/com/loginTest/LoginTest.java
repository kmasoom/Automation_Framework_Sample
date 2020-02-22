package com.loginTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.testng.annotations.Test;

import com.pageFactoryInitializer.LoginPageFactory;
import com.propertyutils.AppProperties;
import com.utility.BrowserFactory;

@PropertySource("classpath:application-${spring.profiles.active}.properties")
@SpringBootTest(classes = {AppProperties.class})
@Component
public class LoginTest extends LoginPageFactory {
	@Autowired
	private AppProperties appProperties;
	BrowserFactory factory=new BrowserFactory();



	@Test
	public void login() {
	loginPage().enterUserName(appProperties.getUsername123()).enterPassword(appProperties.getPassword()).clickLogin();
	}
	
	
}
