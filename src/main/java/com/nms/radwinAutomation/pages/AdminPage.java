package com.nms.radwinAutomation.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminPage extends BasePageObject {

	private By credentialProfile = By.xpath("//span[contains(text(),'Credential Profiles')]");
	private By discoveryProfile = By.xpath("//span[contains(text(),'Network Discovery Profiles')]");
	private By profileName = By.xpath("//input[@name='credentialProfileName']");
	private By discoveryProfileName = By.xpath("//input[@name='discoveryName']");
	private By Community = By.xpath("//input[@name='community']");
	private By Departments = By.xpath("//span[@class='select2-selection select2-selection--multiple']");
	private By deviceip = By.xpath("//input[@name='hostAddress']");
	private By RpeId = By.xpath("//label[contains(text(),'RPE')]//following-sibling::span");
	//private By RpeId_text = By.xpath("//input[@type='search']");
	private By DeviceType = By.xpath(".//*[@id='discoveryForm']/fieldset/div[2]/section[2]/label[2]/span/span[1]/span");
	private By CredentialProfile = By.xpath(".//*[@id='discoveryForm']/fieldset/div[2]/section[3]/section/label[3]/span/span[1]/span");
	private By Tags = By.xpath(".//*[@id='discoveryForm']/fieldset/div[3]/section/label[2]/span/span[1]/span");
	
	
	

	public AdminPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	public void clickCredentialProfile() {
		log.info("Opening Credential Profile");
		click(credentialProfile);
		log.info("Opening Credential Profile");

	}

	public void createCredentialProfile(String name, String community) {
		log.info("Creating Credential Profile");
		newButton();
		type(profileName, name);
		type(Community, community);
		// comboboxSelection(Departments, text);
		createButton();
		log.info("Credential Profile created successfully");

	}

	public String verifycreateCredentialProfile() {

		log.info("Verifying credential profile creation");
		return messageString();

	}
	
	public void clickDiscoveryProfile() {
		log.info("Opening Discovery Profile");
		click(discoveryProfile);
		log.info("Opening Discovery Profile");

	}
	
	public void createDiscoveryProfile(String name, String ip, String RPE, String deviceType, String credentialProfile, String tags) throws InterruptedException {
		log.info("Creating Credential Profile");
		newButton();
		type(discoveryProfileName, name);
		type(deviceip, ip);
		//selectItem(RpeId, RPE);
		selectItem(DeviceType, deviceType);
		selectItem(CredentialProfile,credentialProfile);
		selectItem(Tags, tags);
		createButton();
		log.info("Credential Profile created successfully");

	}

	public String verifycreateDiscoveryProfile() {

		log.info("Verifying credential profile creation");
		return messageString();

	}
	
	
	

}
