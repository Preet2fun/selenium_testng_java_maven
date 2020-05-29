package com.nms.radwinAutomation.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nms.radwinAutomation.base.TestUtilities;
import com.nms.radwinAutomation.pages.DropDownPage;
import com.nms.radwinAutomation.pages.WelcomePageObject;


public class DropDownTests extends TestUtilities {

	@Test
	public void dropDOwnSelect() {
		// Login to welcome page
		WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
		welcomePageObject.openPage();

		// select dropdown page
		DropDownPage dropDownPage = welcomePageObject.clickFormDropDownLink();

		// select option from dropdown
		dropDownPage.selectFromDropDown(2);

		// verify all boxes all checked
		System.out.println(dropDownPage.getSelectFromDropDown());
		Assert.assertTrue(dropDownPage.getSelectFromDropDown().contains("Option 2"), "Option 2 has not been selected");

	}

}
