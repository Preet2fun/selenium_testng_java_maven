package com.nms.radwinAutomation.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject extends BasePageObject {

	private String url = getProperties("url");
	
	private By FormAuthentication = By.linkText("Form Authentication");
	private By checkboxLink = By.xpath("//a[contains(text(),'Checkboxes')]");
	private By dropDownLink = By.xpath("//a[contains(text(),'Dropdown')]");
	private By alertLink = By.xpath("//a[contains(text(),'JavaScript Alerts')]");
	private By window = By.xpath("//a[contains(text(),'Multiple Windows')]");
	private By iframe = By.xpath("//a[contains(text(),'WYSIWYG Editor')]");
	private By fileupload = By.xpath("//a[contains(text(),'File Upload')]");
	private By dragdrop = By.xpath("//a[contains(text(),'Drag and Drop')]");
	private By hovers = By.xpath("//a[contains(text(),'Hovers')]");
	private By adminlink = By.xpath("//a[@id='admin']");

	public WelcomePageObject(WebDriver driver, Logger log) {
		// TODO Auto-generated constructor stub
		super(driver, log);
	}

	public void openPage() {
		log.info("Opening Page " + url);
		openUrl(url);
		log.info("Page is scussefully opended");
	}
	
	public AdminPage clickOnAdminLink() {
		log.info("clicking on Admin page on welcome page");
		click(adminlink);
		log.info("admin page opended successfully");
		return new AdminPage(driver, log);
	}

	public LoginPage clickFormAuthenticationLink() {
		log.info("clicking Form Authentication page on welcome page");
		click(FormAuthentication);
		log.info("opened welcome page");
		return new LoginPage(driver, log);
	}

	public CheckBoxPage clickFormCheckBoxLink() {
		log.info("clicking Form checkbox page on welcome page");
		click(checkboxLink);
		log.info("opened checkbox page");
		return new CheckBoxPage(driver, log);
	}

	public DropDownPage clickFormDropDownLink() {
		log.info("clicking Form dropdown page on welcome page");
		click(dropDownLink);
		log.info("opened dropdown page");
		return new DropDownPage(driver, log);

	}

	public AlertPage clickFormAlertLink() {
		log.info("clicking Form dropdown page on welcome page");
		click(alertLink);
		log.info("opened dropdown page");
		return new AlertPage(driver, log);
	}

	public WindowPage clickFormWindowLink() {
		log.info("clicking Form dropdown page on welcome page");
		click(window);
		log.info("opened dropdown page");
		return new WindowPage(driver, log);
	}

	public IframePage clickforiframe() {
		log.info("clicking form iframe page on welcome page");
		click(iframe);
		log.info("opened iframe file");
		return new IframePage(driver, log);
	}

	public FileUploadPage clickOnFileUpload() {
		log.info("clicking form upload page on welcome page");
		click(fileupload);
		log.info("opened file upload link");
		return new FileUploadPage(driver, log);
	}

	public DragAndDropPage clickOnDragAndDrop() {
		log.info("clicking form drag and drop page on welcome page");
		click(dragdrop);
		log.info("opened file drag and drop link");
		return new DragAndDropPage(driver, log);

	}
	
	public HoversPage clickOnHovers() {
		log.info("clicking on hovers link on welcome page");
		click(hovers);
		log.info("opened hovers link");
		return new HoversPage(driver, log);
		
		
	}

}
