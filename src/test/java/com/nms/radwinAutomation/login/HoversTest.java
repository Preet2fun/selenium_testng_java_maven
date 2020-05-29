package com.nms.radwinAutomation.login;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nms.radwinAutomation.base.TestUtilities;
import com.nms.radwinAutomation.pages.HoversPage;
import com.nms.radwinAutomation.pages.WelcomePageObject;


public class HoversTest extends TestUtilities {
	
	@Test
	public void hoversTest() throws InterruptedException {
		
		//login to welcome page
		WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
		welcomePageObject.openPage();
		
		//click on hovers page link
		HoversPage hoversPage = welcomePageObject.clickOnHovers();
		
		// Open User 2 profile
		hoversPage.openUserProfile(2);
		
		//verifiey correct user profile opended 
		Assert.assertTrue(hoversPage.getCurrentUrl().contains("/users/2"), "Url of opened page is not expected User 1 page url");
		
		
	}
	
	
	
	

}
