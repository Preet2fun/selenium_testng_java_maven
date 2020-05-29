package com.nms.radwinAutomation.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.nms.radwinAutomation.base.TestUtilities;
import com.nms.radwinAutomation.pages.AlertPage;
import com.nms.radwinAutomation.pages.WelcomePageObject;


public class AlertTest extends TestUtilities {

	//we are having hard assert in below test
	
	@Test
	public void confirmAlert() {
	
	// clicking on alert page
	WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
	welcomePageObject.openPage();
	
	//click on JS alert button
	AlertPage alertPage = welcomePageObject.clickFormAlertLink();
	alertPage.clickAlert();
	
	// get alert meassage 
	String alertMessaage = alertPage.getAlertText();
	
	//verify alert message
	Assert.assertTrue(alertMessaage.contains("I am a JS Alert"),"Alert message is not expected. \nShould be 'I am a JS Alert', but it is '" + alertMessaage + "'");
	
	//accept alert
	alertPage.acceptAlert();
	
	//verify alert message after accept
	String resultText = alertPage.getResultText();
	Assert.assertTrue(resultText.contains("You successfuly clicked an alert"),"Alert message is not expected. \nShould be '\"Alert message is not expected. \\nShould be 'I am a JS Alert', but it is '\" + alertMessaage + \"'\"', but it is '" + alertMessaage + "'");
	
	
	}
	
	@Test
	public void cancelAlert() {
		
		//we are having soft assert in below test
		
		SoftAssert softAssert = new SoftAssert();
		
		
		// clicking on alert page
		WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
		welcomePageObject.openPage();
		
		//click on JS alert button
		AlertPage alertPage = welcomePageObject.clickFormAlertLink();
		alertPage.clickConfirm();
		
		// get alert meassage 
		String alertMessaage = alertPage.getAlertText();
		
		//verify alert message
		softAssert.assertTrue(alertMessaage.contains("Pratik"),"Alert message is not expected. \nShould be 'I am a JS Confirm', but it is '" + alertMessaage + "'");
		//I am a JS Confirm
		
		//accept cancel
		alertPage.cancelAlert();
		
		//verify alert message after accept
		String resultText = alertPage.getResultText();
		softAssert.assertTrue(resultText.contains("Patel"),"Alert message is not expected. \nShould be '\"Alert message is not expected. \\nShould be 'You clicked: Cancel', but it is '\" + alertMessaage + \"'\"', but it is '" + alertMessaage + "'");
		//You clicked: Cancel
		
		softAssert.assertAll();
	}

}
