package com.nms.radwinAutomation.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HoversPage extends BasePageObject {

	private By avatarLocator = By.xpath("//div[@class='figure']");
	private By viewProfileLinkLocator = By.xpath(".//a[contains(text(),'View profile')]");
	//private By viewProfileLinkLocator = By.xpath("//h5[contains(text(),'name: user2')]");
	
	public HoversPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}
	
	public void openUserProfile(int i) throws InterruptedException {
		List<WebElement> avatars = findAll(avatarLocator);
		WebElement specificavatar = avatars.get(i-1);
		hoverOverElement(specificavatar);
		//Thread.sleep(5000);
		//waitFor(ExpectedConditions.visibilityOfElementLocated(viewProfileLinkLocator), 5);
		specificavatar.findElement(viewProfileLinkLocator).click();
		
		
	}

}
