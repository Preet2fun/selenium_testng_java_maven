package com.nms.radwinAutomation.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxPage extends BasePageObject {

	private By checkbox = By.xpath("//input[@type='checkbox']");

	public CheckBoxPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	public void selectAllCheckBoxes() {
		log.info("checking all unchecked box");
		List<WebElement> checkboxes = findAll(checkbox);
		for (WebElement checkbox : checkboxes) {
			if (!checkbox.isSelected()) {
				checkbox.click();
			}
		}

	}

	public boolean areAllCheckBoxSelected() {
		log.info("Checking all element is selected or not");
		List<WebElement> checkboxes = findAll(checkbox);
		for (WebElement checkboxe : checkboxes) {
			if (!checkboxe.isSelected()) {
				return false;
			}
		}
		return true;
	}

}
