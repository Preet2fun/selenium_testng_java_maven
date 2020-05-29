package com.nms.radwinAutomation.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePageObject {

	private String pageUrl = "https://the-internet.herokuapp.com/secure"; 
	private By logout = new By.ByXPath("//*[@class='icon-2x icon-signout']");
	private By message = new By.ById("flash-messages");
	private By flash = new By.ById("flash");
	
	
	public SecureAreaPage(WebDriver driver, Logger log) {
		// TODO Auto-generated constructor stub
		super(driver,log);	
	}
	
	public String getPageUrl() {
		return pageUrl;
	}
	
	public boolean isLogOutButtonVisible() {
		return find(logout).isDisplayed();
	}
	
	public String getSuccessMessage() {
		return find(message).getText();
	}
	
	public void waitForErrorMessage() {
		waitForVisibilityOf(flash, 5);
	}
	
	public String getErrorMessageText() {
		return find(flash).getText();
	}
	
}
