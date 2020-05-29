package com.nms.radwinAutomation.login;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nms.radwinAutomation.base.TestUtilities;
import com.nms.radwinAutomation.pages.LoginPage;
import com.nms.radwinAutomation.pages.SecureAreaPage;
import com.nms.radwinAutomation.pages.WelcomePageObject;


public class PositiveLogInTests extends TestUtilities {

	@Parameters({"username", "password" })
	@Test(priority = 1)
	public void positiveTest(String username, String password) {

		log.info("Starting PostiveTest");

		
		
		
		// open main page
		WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
		welcomePageObject.openPage();
		log.info("Main page is opened.");
		// takeScreenshot("Welcomepage");

		// Click on Form Authentication link
		LoginPage loginPage = welcomePageObject.clickFormAuthenticationLink();

		// Login functionality execution
		SecureAreaPage secureAreaPage = loginPage.logIn(username, password);

		// Add new cookie
		Cookie ck = new Cookie("username", "tomsmith", "the-internet.herokuapp.com", "/", null);
		loginPage.setCookie(ck);


		// Get cookies
		String cookieName = secureAreaPage.getCookie("username");
		log.info("Username cookie: " + cookieName);
		String session = secureAreaPage.getCookie("rack.session");
		log.info("Session cookie: " + session);

		// verifications
		// new url
		Assert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());

		// log out button is visible
		Assert.assertTrue(secureAreaPage.isLogOutButtonVisible(), "Logout Button is not visible");

		// Successful log in message
		String expectedSuccessMessage = "You logged into a secure area!";
		String actualSuccessMessage = secureAreaPage.getSuccessMessage();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);

	}
}
