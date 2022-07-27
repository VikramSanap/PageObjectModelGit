package com.ijmeet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * This is a Join Meeting Page of {@code ijmeet.com}
 * this class contains all the {@code WebElements } present on the Join Meeting Paage
 * and elememt specific methods to perform various actions on specific {@code WebElement} 
 * @author Vikram Ashok Sanap
 *
 */	
public class JoinMeetingPage {
	
	@FindBy(css ="h2.m-txt")  //*****ALTERNATE***** @FindBy(how = HOW.CSS, using = "h2.m-txt") 	
	public WebElement quickJoinMeetingTitle;
	
	public String getQuickJoinMeetingTitle() {
		return quickJoinMeetingTitle.getText();
	}
	
//*******************************ALTERNATE WAY**********************************
//	UIKeyword keyword = UIKeyword.getInstance();
//
//	@FindBy(css ="h2.m-txt")
//	public WebElement quickJoinMeetingTitle;
//	
//	public JoinMeetingPage() {
//		PageFactory.initElements(keyword.driver,JoinMeetingPage.class);
//	}
//	public String getQuickJoinMeetingTitle() {
//	return quickJoinMeetingTitle.getText();
//	}

}
