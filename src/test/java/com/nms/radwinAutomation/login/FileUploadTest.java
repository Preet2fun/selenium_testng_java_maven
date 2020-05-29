package com.nms.radwinAutomation.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nms.radwinAutomation.base.TestUtilities;
import com.nms.radwinAutomation.pages.FileUploadPage;
import com.nms.radwinAutomation.pages.WelcomePageObject;


public class FileUploadTest extends TestUtilities {

	//clicking on file upload url
	
	@Test(dataProvider="files")
	public void fileUpload(int no, String filename) {
		
		log.info("Starting fileUploadTest #" + no + " for " + filename);
		
		//opening main page
		WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
		welcomePageObject.openPage();
		
		//opening link of fileupload 
		FileUploadPage fileUploadPage = welcomePageObject.clickOnFileUpload();
		
		//select file location
		//String filename = "image.png";
		fileUploadPage.selectFile(filename);
		
		//upload file
		fileUploadPage.pushUploadButton();
		
		//getting text of uploaded file
		String filetext = fileUploadPage.getUploadedFileText();
		
		//validating uploaded file
		Assert.assertTrue(filetext.contains(filename), "Alert message is not expected. \nShould be" + filename + ", but it is " + filetext );
		
		
		
	}
	
	
	
	
}
