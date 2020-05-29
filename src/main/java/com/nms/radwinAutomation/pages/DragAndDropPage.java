package com.nms.radwinAutomation.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragAndDropPage extends BasePageObject {

	private By columnA = By.id("column-a");
	private By columnB = By.id("column-b");
	
	public DragAndDropPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

    public void dragAndDrop() {
    	//drag A box into B box
    	log.info("Drag and drop A box to B box");
    	performDragAndDrop(columnA, columnB);
    }

    public String getColumnAText() {
    	log.info("getting text of column A");
    	String text = find(columnA).getText();
    	return text;
    }
    
    public String getColumnBText() {
    	log.info("getting text of column B");
    	String text = find(columnB).getText();
    	return text;
    }
    
}
