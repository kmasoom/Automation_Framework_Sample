package com.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.propertyutils.AppProperties;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory extends AbstractTestNGSpringContextTests{

	public static WebDriver driver;
	@Autowired
	private AppProperties appProperties;
	public WebDriver createDriver(String browser, String url) {
	// WebDriver driver =null;
	Browser browserTypes = Browser.valueOf(browser);
	switch (browserTypes) {
	case chrome:
	WebDriverManager.chromedriver().setup();
	ChromeOptions Options = new ChromeOptions();
	Options.addArguments("disable-infobars");
	Options.addArguments("--ignore-certifcate-errors");
	Options.addArguments("--disable-notifications");
	driver = new ChromeDriver(Options);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(url);
	break;
	case chrome_headless:
	WebDriverManager.chromedriver().setup();
	ChromeOptions chromeOptions = new ChromeOptions();
	chromeOptions.addArguments("--headless");
	chromeOptions.addArguments("--disable-gpu");
	chromeOptions.addArguments("--no-sandbox");
	chromeOptions.addArguments("window-size=1200,1100");
	chromeOptions.addArguments("--disable-extensions");
	chromeOptions.addArguments("--disable-dev-shm-usage");
	driver = new ChromeDriver(chromeOptions);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(url);
	break;

	default:
	try {
	throw new Exception("Please Provide a Valid Browser");
	} catch (Exception e) {
	e.printStackTrace();
	}
	}

	return driver;
	}
	@BeforeMethod
	public void setUp(){
	createDriver(appProperties.getBrowser(),appProperties.getUrl());
	}

	@AfterMethod
	public void tearDown(){
	driver.quit();
	}
	private enum Browser {
	//
	chrome,
	//
	chrome_headless;
	}
}
