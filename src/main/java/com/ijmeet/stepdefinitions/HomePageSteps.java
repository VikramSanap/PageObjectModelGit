package com.ijmeet.stepdefinitions;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.ijmeet.config.Application;
import com.ijmeet.keyword.UIKeyword;

import io.cucumber.java.en.*;

public class HomePageSteps {
	UIKeyword keyword = UIKeyword.getInstance();
	public RemoteWebDriver driver = null;

	@When("Chrome browser is launched")
	public void chrome_browser_is_launched() {
		Application app = new Application();
		String browserName = app.getBrowser();
		System.out.println("BROWSER NAME IS :"+browserName);
		keyword.openBrowser(browserName);
		this.driver = keyword.getDriver();
//		keyword.openBrowser("chrome");
		
	}

	@When("the url of the application is launched")
	public void the_url_of_the_application_is_launched() {
		Application app = new Application();
		driver.get(app.getQaAppUrl());
//		String url = "https://www.ijmeet.com";
//		keyword.launchUrl(url);

	}

	@Then("Verify the title of the home parge")
	public void verify_the_title_of_the_home_parge() {
		this.driver = keyword.getDriver();
		String actual = driver.getTitle();
		Assert.assertEquals(actual, "IJmeet");
	}

}
