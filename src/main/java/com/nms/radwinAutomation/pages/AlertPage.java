package com.nms.radwinAutomation.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage extends BasePageObject {

	private By alert = By.xpath("//button[contains(text(),'Click for JS Alert')]");
	private By confirm = By.xpath("//button[contains(text(),'Click for JS Confirm')]");
	private By prompt = By.xpath("//button[contains(text(),'Click for JS Prompt')]");
	private By resultTextLocator = By.id("result");
	
	public AlertPage(WebDriver driver, Logger log) {
		// TODO Auto-generated constructor stub
		super(driver, log);
	}
	
	public void clickAlert() {
		log.info("Clicking for ALert");
		click(alert);
	}
	
	public void clickConfirm() {
		log.info("Clicking for confirm");
		click(confirm);
	}

	public void clickPrompt() {
		log.info("Clicking for prompt");
		click(prompt);
	}
	
	public String getAlertText() {
		Alert alert = switchToAlert();
		String alertText = alert.getText();
		log.info("Alert says : " + alertText);
		return alertText;
	
	}
	
	public void acceptAlert() {
		log.info("Switching to alert and pressing OK button");
		Alert alert = switchToAlert();
		alert.accept();
		
	}
	
	public void cancelAlert() {
		log.info("Switching to alert and pressing OK button");
		Alert alert = switchToAlert();
		alert.dismiss();
	}
	
	public String getResultText() {
		
		String resultText = find(resultTextLocator).getText();
		log.info("Alert result text : " + resultText);
		return resultText;
	}
	
}
