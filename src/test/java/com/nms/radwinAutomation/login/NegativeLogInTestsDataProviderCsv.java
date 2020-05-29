package com.nms.radwinAutomation.login;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nms.radwinAutomation.base.CsvDataProviders;
import com.nms.radwinAutomation.base.TestUtilities;
import com.nms.radwinAutomation.pages.LoginPage;
import com.nms.radwinAutomation.pages.SecureAreaPage;
import com.nms.radwinAutomation.pages.WelcomePageObject;


public class NegativeLogInTestsDataProviderCsv extends TestUtilities {

	@Test(priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void negativeLogInTestsDataProviderCsv(Map<String, String> testData) {
		// Data
		String no = testData.get("no");
		String username = testData.get("username");
		String password = testData.get("password");
		String expectedErrorMessage = testData.get("expectedMessage");
		String description = testData.get("description");

		log.info("Starting negativeLogInTest #" + no + " for " + description);

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
