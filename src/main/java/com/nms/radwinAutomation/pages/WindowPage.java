package com.nms.radwinAutomation.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowPage extends BasePageObject {

	public WindowPage(WebDriver driver, Logger log) {
		// TODO Auto-generated constructor stub
		super(driver, log);
		
	}
	
	private By clickhere = By.xpath("//a[contains(text(),'Click Here')]");
	
	public NewWindowPage clickOnclickhere() {
		log.info("clicking on click here link");
		click(clickhere);
		return new NewWindowPage(driver,log);
	}
		
	public NewWindowPage switchToNewWindow() {
		log.info("Switching to new window");
		switchToWindowWithTitle("New Window");
		return new NewWindowPage(driver,log);
		
	}
}
