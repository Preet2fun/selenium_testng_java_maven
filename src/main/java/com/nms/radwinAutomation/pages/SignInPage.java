package com.nms.radwinAutomation.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInPage extends BasePageObject {

	private String username = getProperties("username");
	private String password = getProperties("password");

	private By userNameLocator = By.xpath("//input[@name='userName']");
	private By passwordNameLocator = By.xpath("//input[@name='password']");
	private By SignInButton = By.id("loginFormSubmitBtn");
	private By loginUserName = By.xpath("//span[@id='userName']");

	public SignInPage(WebDriver driver, Logger log) {
		// TODO Auto-generated constructor stub
		super(driver, log);
	}

	public SignInPage signIn() {

		log.info("Executing Login info with" + "username : " + username + " password : " + password);

		type(userNameLocator, username);
		type(passwordNameLocator, password);
		click(SignInButton);

		log.info("Login done Successfully");

		return new SignInPage(driver, log);

	}

	public String getLoginUserName() {
		waitFor(ExpectedConditions.elementToBeClickable(loginUserName), 30);
		return find(loginUserName).getText();
	}

}
