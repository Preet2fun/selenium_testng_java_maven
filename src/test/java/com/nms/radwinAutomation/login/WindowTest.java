package com.nms.radwinAutomation.login;


import java.sql.Time;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nms.radwinAutomation.base.TestUtilities;
import com.nms.radwinAutomation.pages.NewWindowPage;
import com.nms.radwinAutomation.pages.WelcomePageObject;
import com.nms.radwinAutomation.pages.WindowPage;


public class WindowTest extends TestUtilities {
	
	@Test
	public void windowSwitch() {
		
		// clicking on window page
		WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
		welcomePageObject.openPage();
		
		//scrolling page
		sleep(5000);
		welcomePageObject.scrollToBottom();
		sleep(5000);
		
		
		//click on clcickhere button
		WindowPage windowPage = welcomePageObject.clickFormWindowLink();
		windowPage.clickOnclickhere();
		
		//move to next window switch
		NewWindowPage newWindowPage = windowPage.switchToNewWindow();
		
		//verifying we are on new window
		String pageSource = newWindowPage.getPageSource();
		
		Assert.assertTrue(pageSource.contains("New Window"),"New page source doesn't contain expected text");
		
		
	}

}
