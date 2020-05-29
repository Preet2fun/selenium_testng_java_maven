package com.nms.radwinAutomation.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject {
	
	
	
	private By userNameLocator = By.xpath("//input[@name='userName']");
	private By passwordNameLocator = By.xpath("//input[@name='password']");
	private By SignInButton = By.id("loginFormSubmitBtn");
	
	public LoginPage(WebDriver driver, Logger log) {
		// TODO Auto-generated constructor stub
		super(driver,log);
	}
	
	public SecureAreaPage logIn(String username, String password) {
		
		log.info("Executing Login info with" + "username : " + username + " password : " + password );
		type(userNameLocator, username);
		type(passwordNameLocator, password);
		click(SignInButton);

		return new SecureAreaPage(driver, log);
		
	}
 
	
	
	
}
