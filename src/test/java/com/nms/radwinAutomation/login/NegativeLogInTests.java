package com.nms.radwinAutomation.login;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nms.radwinAutomation.base.TestUtilities;
import com.nms.radwinAutomation.pages.LoginPage;
import com.nms.radwinAutomation.pages.SecureAreaPage;
import com.nms.radwinAutomation.pages.WelcomePageObject;



public class NegativeLogInTests extends TestUtilities {

	


	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 1)
	public void negativeTest(String username, String password, String expectedErrorMessage) {
		log.info("Starting negativeTest");
		
		// open main page
		WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
		welcomePageObject.openPage();
		log.info("Page opened");


		// Click on Form Authentication link
		LoginPage loginPage = welcomePageObject.clickFormAuthenticationLink();
		

		// enter username and password
		SecureAreaPage secureAreaPage = loginPage.logIn(username, password);
		

		// Verification
		secureAreaPage.waitForErrorMessage();
		String actualErrorMessage = secureAreaPage.getErrorMessageText();
		System.out.println("Actual : " + actualErrorMessage);
		System.out.println("Expected : " + expectedErrorMessage);
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
				"actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
						+ expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage);
	}


	
}
