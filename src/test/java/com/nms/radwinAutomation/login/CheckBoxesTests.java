package com.nms.radwinAutomation.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nms.radwinAutomation.base.TestUtilities;
import com.nms.radwinAutomation.pages.CheckBoxPage;
import com.nms.radwinAutomation.pages.WelcomePageObject;


public class CheckBoxesTests extends TestUtilities {

	@Test
	public void selectingTwoCheckBox() {

		// Login to welcome page
		WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
		welcomePageObject.openPage();

		// select check box page
		CheckBoxPage checkBoxPage = welcomePageObject.clickFormCheckBoxLink();

		// select all check box
		checkBoxPage.selectAllCheckBoxes();

		// verify all boxes all checked
		System.out.println(checkBoxPage.areAllCheckBoxSelected());
		Assert.assertTrue(checkBoxPage.areAllCheckBoxSelected(), "All check box are not selected");

	}

}
