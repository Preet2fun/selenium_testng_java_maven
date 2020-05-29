package com.nms.radwinAutomation.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IframePage extends BasePageObject {

	private By locator = By.id("mce_0_ifr");
	private By editorlocator = By.id("tinymce");
	
	public IframePage(WebDriver driver, Logger log) {
		// TODO Auto-generated constructor stub
		super(driver, log);
	}
	
	public String getTextOfFrame() {
	         switchToframe(locator);
	         String text = find(editorlocator).getText();
	         log.info("Text from editor is : " + text);
	         return text;
		
	}
	
	
}
