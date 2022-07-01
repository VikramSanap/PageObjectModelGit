package com.testingshastra.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.testingshastra.keyword.UIKeyword;

public class HomePage {

	UIKeyword keyword = UIKeyword.getInstance();

	@FindBy(css = "div#navbarContent li:nth-child(1)")
	public WebElement joinMeetingTab;

	public void clickOnJoinMeetingTab() {
		joinMeetingTab.click();
	}

//	*******************************ALTERNATE WAY**********************************
//	UIKeyword keyword = UIKeyword.getInstance();
//
//	@FindBy(css = "div#navbarContent li:nth-child(1)")
//	public WebElement joinMeetingTab;
//	
//	public HomePage() {
//		PageFactory.initElements(keyword.driver,HomePage.class);
//	}
//	public void clickOnJoinMeetingTab() {
//		joinMeetingTab.click();
//	}

	@FindBy(css = "div#navbarContent li:nth-child(2)")
	public WebElement hostMeetingTab;

	public void clickOnHostMeetingTab() {
		hostMeetingTab.click();
	}

	@FindBy(css = "div#navbarContent li:nth-child(3)")
	public WebElement contctSalesTab;

	public void clickOnContactSalesTab() {
		contctSalesTab.click();
	}

	@FindBy(css = "div#navbarContent li:nth-child(4)")
	public WebElement signInTab;

	public void clickOnSignInTab() {
		signInTab.click();
	}

	@FindBy(css = "div#navbarContent li:nth-child(5)")
	public WebElement signUpTab;

	public void clickOnSignUpTab() {
		signUpTab.click();
	}

	@FindBy(css = "div#navbarContent li:nth-child(6)")
	public WebElement languageTab;

	public void clickOnLanguageTab() {
		languageTab.click();
	}

	@FindBy(css = "div.footer-last-view-support div:nth-child(3) li a")
	public List<WebElement> infoLinks;

	public void getTextOfInfoLinks() {
		Iterator<WebElement> itr = infoLinks.iterator();
		while (itr.hasNext())
			;
		System.out.println(itr.next().getText());
	}

	public List<WebElement> getAllLinks() {
		return keyword.driver.findElements(By.tagName("a"));

	}
}
