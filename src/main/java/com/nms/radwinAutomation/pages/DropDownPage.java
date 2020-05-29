package com.nms.radwinAutomation.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage extends BasePageObject {

	private By dropdown = By.id("dropdown");
	
	public DropDownPage(WebDriver driver, Logger log) {
		// TODO Auto-generated constructor stub
		super(driver,log);
	}
	
	public void selectFromDropDown(int i) {
		log.info("Selecting from available drop down menu");
		WebElement element = find(dropdown);
		Select dropdown = new Select(element);
		dropdown.selectByIndex(i);
		//dropdown.selectByValue(value);
		//dropdown.selectByVisibleText(text);
		
	}
	
	public String getSelectFromDropDown() {
		log.info("Getting value of selected optoin");
		WebElement element = find(dropdown);
		Select dropdown = new Select(element);
		String selectedOption = dropdown.getFirstSelectedOption().getText();
		return selectedOption;
		
	}
	
	
	
}
