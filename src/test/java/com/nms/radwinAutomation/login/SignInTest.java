package com.nms.radwinAutomation.login;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nms.radwinAutomation.base.TestUtilities;
import com.nms.radwinAutomation.pages.AdminPage;
import com.nms.radwinAutomation.pages.CheckBoxPage;
import com.nms.radwinAutomation.pages.SignInPage;
import com.nms.radwinAutomation.pages.WelcomePageObject;

public class SignInTest extends TestUtilities {

	@Test
	public void positiveTest() {

		log.info("Starting PostiveTest");
		
		//Step 1 : opening the webportal URL
		WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
		welcomePageObject.openPage();
		
		//Step 2: sign in the portal using required credential
		SignInPage signInPage = new SignInPage(driver, log);
		SignInPage loginPage = signInPage.signIn();
		
		//Step 3: verifications of login user using signout button on page.
		String loginUser = loginPage.getLoginUserName();
		System.out.println("Login user Name is : " + loginUser);
		assertTrue(loginUser.contains("Hi, admin"), "expected Login user is admin but we have user " + loginUser + " available");
		
		
		/*// select check box page
		AdminPage adminPage = welcomePageObject.clickOnAdminLink();
		System.out.println(adminPage.getCurrentUrl());
		adminPage.clickCredentialProfile();*/

		

	}

}
