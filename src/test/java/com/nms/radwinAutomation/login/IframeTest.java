package com.nms.radwinAutomation.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nms.radwinAutomation.base.TestUtilities;
import com.nms.radwinAutomation.pages.IframePage;
import com.nms.radwinAutomation.pages.WelcomePageObject;



public class IframeTest extends TestUtilities {
	
	@Test
	public void iFrameTest() {
		
		//clicking iframe page 
		
		WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
		welcomePageObject.openPage();
		
		
		//click on iframe link
		IframePage iframePage = welcomePageObject.clickforiframe();
		
		//switch to iframe and get text
		String text = iframePage.getTextOfFrame();
		System.out.println(text);
		
		//validation of message
		Assert.assertTrue(text.equals("Your content goes here."), "Alert message is not expected. \nShould be 'Your content goes here.', but it is '" + text + "'");
		
		
		
		
	}
	

}
