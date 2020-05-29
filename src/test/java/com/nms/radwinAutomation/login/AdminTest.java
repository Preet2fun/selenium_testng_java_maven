package com.nms.radwinAutomation.login;

import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nms.radwinAutomation.base.CsvDataProviders;
import com.nms.radwinAutomation.base.TestUtilities;
import com.nms.radwinAutomation.pages.AdminPage;
import com.nms.radwinAutomation.pages.SignInPage;
import com.nms.radwinAutomation.pages.WelcomePageObject;

public class AdminTest extends TestUtilities {

	@Test(priority = 1,dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void createCredentialProfile(Map<String, String> testData) {

		// Reading data from csv file
		String name = testData.get("name");
		String community = testData.get("community");
		String expectedMessage = testData.get("expectedMessage");
		//String department = testData.get("department");

		// Step 1 : opening the webportal URL
		WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
		welcomePageObject.openPage();

		// Step 2: sign in the portal using required credential
		SignInPage signInPage = new SignInPage(driver, log);
		SignInPage loginPage = signInPage.signIn();

		// Step 3: verifications of login user using signout button on page.
		String loginUser = loginPage.getLoginUserName();
		System.out.println("Login user Name is : " + loginUser);
		assertTrue(loginUser.contains("Hi, admin"),
				"expected Login user is admin but we have user " + loginUser + " available");

		// Step 4: select admin section and go to credential profile tab
		AdminPage adminPage = welcomePageObject.clickOnAdminLink();
		adminPage.clickCredentialProfile();

		// Step 5 : fill allrequired deatils to create credential profile
		adminPage.createCredentialProfile(name, community);

		// Step 6 : verify credential profile create functionality
		Assert.assertTrue(adminPage.verifycreateCredentialProfile().equals(expectedMessage),
				"expected result message is : " + expectedMessage + " , but we got message"
						+ adminPage.verifycreateCredentialProfile());

	}
	
	@Test(priority = 2,dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void createDiscoveryProfile(Map<String, String> testData) throws InterruptedException {

		// Reading data from csv file
		String name = testData.get("name");
		String ip = testData.get("ip_host");
		String RPE = testData.get("RPE");
		String deviceType = testData.get("DeviceType");
		String credentialProfile = testData.get("DeviceType");
		String tags = testData.get("DeviceType");
		String expectedMessage = testData.get("expectedMessage");

		// Step 1 : opening the webportal URL
		WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
		welcomePageObject.openPage();

		// Step 2: sign in the portal using required credential
		SignInPage signInPage = new SignInPage(driver, log);
		SignInPage loginPage = signInPage.signIn();

		// Step 3: verifications of login user using signout button on page.
		String loginUser = loginPage.getLoginUserName();
		System.out.println("Login user Name is : " + loginUser);
		assertTrue(loginUser.contains("Hi, admin"),
				"expected Login user is admin but we have user " + loginUser + " available");

		// Step 4: select admin section and go to credential profile tab
		AdminPage adminPage = welcomePageObject.clickOnAdminLink();
		adminPage.clickDiscoveryProfile();

		// Step 5 : fill allrequired deatils to create credential profile
		adminPage.createDiscoveryProfile(name, ip, RPE, deviceType, credentialProfile, tags);

		// Step 6 : verify credential profile create functionality
		Assert.assertTrue(adminPage.verifycreateDiscoveryProfile().equals(expectedMessage),
				"expected result message is : " + expectedMessage + " , but we got message"
						+ adminPage.verifycreateDiscoveryProfile());

	}
	

}
