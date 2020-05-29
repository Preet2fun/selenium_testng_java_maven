package com.nms.radwinAutomation.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage extends BasePageObject {

	private By chooseFile = By.id("file-upload");
	private By upload = By.id("file-submit");
	private By uploadedFilesLocator = By.id("uploaded-files");
	
	public FileUploadPage(WebDriver driver, Logger log) {
		// TODO Auto-generated constructor stub
		super(driver, log);
	}
	
	
	
	public void selectFile(String filename) {
		
		log.info("selecting file " + filename);
		String filepath = System.getProperty("user.dir") + "//src//main//resources//" + filename;
		type(chooseFile,filepath);
		log.info(filename + "has been selected");
		
	}
	
	public void pushUploadButton() {
		log.info("pressing upload image");
		click(upload);
	}
	
	
	public String getUploadedFileText() {
		
		log.info("getting text of uploaded file");
		String text = find(uploadedFilesLocator).getText();
		return text;
	}

}
