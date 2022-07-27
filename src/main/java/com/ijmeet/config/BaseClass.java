package com.ijmeet.config;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.ijmeet.keyword.UIKeyword;

public class BaseClass {
	UIKeyword keyword = UIKeyword.getInstance();
	  public RemoteWebDriver driver = null;

//	@Parameters("browserName")
	@BeforeMethod
	public void setup() {
//		public void setup(@Optional String browserName) {
//		Application app = new Application();
//		if (browserName==null) {
//			browserName = app.getBrowser();
//			System.out.println("Launching browser :"+browserName);
//		}
//		keyword.openBrowser(browserName);
//		this.driver = keyword.getDriver();
//		driver.get(app.getQaAppUrl());
		
		keyword.openBrowser("chrome");
		String url = "https://www.ijmeet.com";
		keyword.launchUrl(url);
	}
		
	@AfterMethod
	public void tearDown() {
		keyword.quitBrowser();
	}
}
