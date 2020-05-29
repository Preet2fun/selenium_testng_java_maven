package com.nms.radwinAutomation.base;




import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserDriverFactory {

	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private String browser;
	private Logger log;
	
	public BrowserDriverFactory(String browser, Logger log) {
		this.browser = browser.toLowerCase();
		this.log = log;
	}
	
	public WebDriver createDriver() {
		
		log.info("Creating driver :" + browser);
		
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver.set(new ChromeDriver());
			break;
			
		case "firefox":
			System.setProperty("webdriver.firefox.driver","src/main/resources/geckodriver.exe");
			driver.set(new FirefoxDriver());
			break;
			
		case "chromeheadless":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");
			driver.set(new ChromeDriver(chromeOptions));
			break;
			
		case "firefoxheadless":
			System.setProperty("webdriver.firefox.driver","src/main/resources/geckodriver.exe");
			FirefoxBinary firefoxBinary = new FirefoxBinary();
			firefoxBinary.addCommandLineOptions("--headless");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setBinary(firefoxBinary);
			driver.set(new FirefoxDriver(firefoxOptions));
			break;	

		default:
			System.out.println("do not able to start browser" + browser + ", Staring chrome browser");
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver.set(new ChromeDriver());
			
			break;
		}
		
		return driver.get();
		
	}
	
	
}
