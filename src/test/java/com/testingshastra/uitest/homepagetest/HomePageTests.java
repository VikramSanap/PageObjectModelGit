package com.testingshastra.uitest.homepagetest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.testingshastra.config.BaseClass;
import com.testingshastra.keyword.UIKeyword;
import com.testingshastra.pages.HomePage;
import com.testingshastra.pages.JoinMeetingPage;

public class HomePageTests extends BaseClass {
	UIKeyword keyword = UIKeyword.getInstance();

	@Test
	public void verifyTitleOfHomePage() {
		String expectedTitle = "IJmeet";
		Assert.assertEquals(keyword.driver.getTitle(), expectedTitle);
	}
	
	@Test
	public void verifyifUserRedirectsToJoinMeetingPage() {
		HomePage home = PageFactory.initElements(keyword.driver,HomePage.class);
		home.clickOnJoinMeetingTab();
		JoinMeetingPage joinMeeting = PageFactory.initElements(keyword.driver, JoinMeetingPage.class);
		String actual = joinMeeting.getQuickJoinMeetingTitle();
		Assert.assertTrue(actual.contains("Quick"));
		System.out.println("TITLE OF QUICK JOIN MEETING "+actual);
	}
	
	
//	*******************************ALTERNATE WAY**********************************
//	@Test
//	public void verifyifUserRedirectsToJoinMeetingPage() {
//		HomePage home = new HomePage();
//		home.clickOnJoinMeetingTab();
//		JoinMeetingPage joinMeeting = new JoinMeetingPage();
//		String actual = joinMeeting.getQuickJoinMeetingTitle();
//		Assert.assertTrue(actual.contains("Quick"));
//	}
	
	@Test
	public void printAllInfoLinks() {
		HomePage home = PageFactory.initElements(keyword.driver, HomePage.class);
		home.getTextOfInfoLinks();
	}
	
	@Test
	public void validateAllTheLinksOfHomePage() throws IOException {
		HomePage home = new HomePage();
		List<WebElement> links = home.getAllLinks();
		Iterator<WebElement> itr = links.iterator();
		while(itr.hasNext()) {
			String url = itr.next().getAttribute("href");
			try {
				HttpsURLConnection con = (HttpsURLConnection)(new URL(url).openConnection());
				int code = con.getResponseCode();
				System.out.println("Url :"+url+"Status code :"+code);
				Assert.assertFalse(code>=400, "Link is broken"+url);
			}catch(MalformedURLException e) {
				System.out.println("Url :"+url);
			}
		}
		int number = links.size(); 
		System.out.println("Total number of links :"+number);

	}
	
}
