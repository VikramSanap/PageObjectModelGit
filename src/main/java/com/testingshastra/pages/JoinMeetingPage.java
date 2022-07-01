package com.testingshastra.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

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
