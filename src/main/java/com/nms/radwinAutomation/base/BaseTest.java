package com.nms.radwinAutomation.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

// By using @Listeners annotation here we don't need to define Listeners class at all xml suite file 
@Listeners({ com.nms.radwinAutomation.base.TestListener.class })
public class BaseTest {

	protected WebDriver driver;
	protected Logger log;
	protected String testSuiteName;
	protected String testName;
	protected String testMethodName;
	

	@Parameters({ "browser"})
	@BeforeMethod(alwaysRun = true)
	public void setUp(Method method, @Optional("chrome") String browser, ITestContext ctx) {
		// current Thread
		long id = Thread.currentThread().getId();
        System.out.println("Before-method. Thread id is: " + id);
		
		// test Name
		String testName = ctx.getCurrentXmlTest().getName();
		log = LogManager.getLogger(testName);

		// Create driver
		BrowserDriverFactory factory = new BrowserDriverFactory(browser, log);
		driver = factory.createDriver();
		driver.manage().window().maximize();

		this.testSuiteName = ctx.getSuite().getName();
		this.testName = testName;
		this.testMethodName = method.getName();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult testResult) {
		
		// current Thread
				long id = Thread.currentThread().getId();
		        System.out.println("After-method. Thread id is: " + id);

		if (!testResult.isSuccess()) {

			System.out.println("***** Error " + testResult.getName() + " test has failed *****");
			String methodName = testResult.getMethod().getMethodName();
			// ITestContext context = testResult.getTestContext();
			// WebDriver driver = (WebDriver) context.getAttribute("driver");
			takeScreenShot(methodName, driver);

		}

		System.out.println("Close driver");
		// Close browser
		driver.quit();
	}

	public void takeScreenShot(String methodName, WebDriver driver) {

		String filePath = System.getProperty("user.dir") + File.separator + "test-output" + File.separator
				+ "screenshots" + File.separator + getTodaysDate() + File.separator + testSuiteName + File.separator
				+ testName + File.separator + testMethodName + File.separator + getSystemTime() + " " + methodName
				+ ".png";

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in d drive with test method name
		try {
			FileUtils.copyFile(scrFile, new File(filePath));
			System.out.println("***Placed screen shot in " + filePath + " ***");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String getTodaysDate() {
		return (new SimpleDateFormat("yyyyMMdd").format(new Date()));
	}

	// Current time in HHmmssSSS
	private String getSystemTime() {
		return (new SimpleDateFormat("HHmmssSSS").format(new Date()));
	}

}
