package com.nms.radwinAutomation.pages;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {

	protected WebDriver driver;
	protected Logger log;

	private By create_button = By.id("adminMenuFormSubmitBtn");
	private By new_button = By.id("btnAdminMenuAdd");
	private By message = By.xpath("//span[normalize-space(text())='Success']//following-sibling::p");
	private String drpValue = "(//li[normalize-space(text())='%s'])[last()]";

	public BasePageObject(WebDriver driver, Logger log) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		this.log = log;

	}

	protected void openUrl(String url) {
		driver.get(url);
	}

	protected String getCurrentPageTitle() {
		return driver.getTitle();
	}

	protected WebElement find(By locator) {
		return driver.findElement(locator);
	}

	protected List<WebElement> findAll(By locator) {
		return driver.findElements(locator);
	}

	protected void click(By locator) {
		waitForVisibilityOf(locator, 30);
		find(locator).click();
	}

	protected void type(By locator, String text) {
		waitForVisibilityOf(locator, 5);
		find(locator).sendKeys(text);
	}

	protected void createButton() {
		find(create_button).click();
	}

	protected void newButton() {
		find(new_button).click();
	}

	protected String messageString() {

		waitFor(ExpectedConditions.visibilityOfElementLocated(message), 30);
		return driver.findElement(message).getText();
	}

	protected void comboboxSelection(By locator, String text) {

		Select select = new Select(find(locator));
		select.selectByVisibleText(text);
	}

	/*protected void selectItem(By locator, String text) throws InterruptedException {
        Thread.sleep(5000);
		click(locator);
		List<WebElement> data = findAll(locator);
		try {
			for (WebElement result : data) {
				if (result.getText().equalsIgnoreCase(text)) {
					result.click();
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
*/
	
	public void selectItem(By locator, String txt) throws InterruptedException {
		
		//WebElement element = find(drp);
		//WebElement element_txt = find(drp_txt);
		find(locator).click();
		Thread.sleep(5000);
		find(locator).sendKeys(txt);
		//driver.findElement(By.xpath(String.format(drpValue, txt))).click();
  }
	

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	protected void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
		timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(condition);
	}

	protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {

		int attempt = 0;
		while (attempt < 2) {
			try {

				waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
						(timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
				break;
			} catch (StaleElementReferenceException e) {
				// TODO: handle exception
			}

			attempt++;
		}

	}

	protected Alert switchToAlert() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.alertIsPresent());
		return driver.switchTo().alert();
	}

	public void switchToframe(By locator) {
		driver.switchTo().frame(find(locator));

	}

	public void scrollToBottom() {
		log.info("scrolling to bottom of the page");
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void hoverOverElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

	}

	protected void performDragAndDrop(By from, By to) {
		// Actions action = new Actions(driver);
		// action.dragAndDrop(find(from), find(to)).build().perform();

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript(
				"function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
						+ "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n"
						+ "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
						+ "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n"
						+ "return event;\n" + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
						+ "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
						+ "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
						+ "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n"
						+ "}\n" + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
						+ "var dragStartEvent =createEvent('dragstart');\n"
						+ "dispatchEvent(element, dragStartEvent);\n" + "var dropEvent = createEvent('drop');\n"
						+ "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
						+ "var dragEndEvent = createEvent('dragend');\n"
						+ "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
						+ "var source = arguments[0];\n" + "var destination = arguments[1];\n"
						+ "simulateHTML5DragAndDrop(source,destination);",
				find(from), find(to));

	}

	protected void switchToWindowWithTitle(String expectedTitle) {
		String firstWindow = driver.getWindowHandle();

		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> windowIterator = allWindows.iterator();

		while (windowIterator.hasNext()) {

			String windowHadle = windowIterator.next().toString();
			if (!windowHadle.equals(firstWindow)) {
				driver.switchTo().window(windowHadle);
				if (getCurrentPageTitle().equals(windowHadle)) {
					break;
				}
			}

		}
	}

	/** Add cookie */
	public void setCookie(Cookie ck) {
		log.info("Adding cookie " + ck.getName());
		driver.manage().addCookie(ck);
		log.info("Cookie added");
	}

	/** Get cookie value using cookie name */
	public String getCookie(String name) {
		log.info("Getting value of cookie " + name);
		return driver.manage().getCookieNamed(name).getValue();
	}

	public String getProperties(String Key) {

		FileReader reader = null;
		try {
			reader = new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\data.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties p = new Properties();
		try {
			p.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return p.getProperty(Key);

	}

}
