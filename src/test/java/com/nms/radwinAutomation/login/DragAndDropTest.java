package com.nms.radwinAutomation.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nms.radwinAutomation.base.TestUtilities;
import com.nms.radwinAutomation.pages.DragAndDropPage;
import com.nms.radwinAutomation.pages.WelcomePageObject;



public class DragAndDropTest extends TestUtilities {
	
	@Test
	public void dargAnddropTest() {
	
	//login to welcome page
	WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
	welcomePageObject.openPage();
	
	//click on  drap and drop link
	DragAndDropPage dragAndDropPage = welcomePageObject.clickOnDragAndDrop();
	
	String ColumnAText1 = dragAndDropPage.getColumnAText();
	System.out.println(ColumnAText1);
	
	//performing drag and drop funtions
	dragAndDropPage.dragAndDrop();
	
	String ColumnAText = dragAndDropPage.getColumnAText();
	System.out.println(ColumnAText);
	Assert.assertTrue(ColumnAText.equals("B"),"Column A header should be B, but it is: " + ColumnAText);
	
	String ColumnBText = dragAndDropPage.getColumnBText();
	System.out.println(ColumnBText);
	Assert.assertTrue(ColumnBText.equals("A"),"Column B header should be A, but it is: " + ColumnBText);
	
	
	}
	

}
