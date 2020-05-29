package com.nms.radwinAutomation.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestNG;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestListener extends TestNG implements ITestListener {

	Logger log;
	String testMethodName;
	String testName;

	ExtentReports extent = ExtentReporterNG.extentReportGenerator();
	ExtentTest test;

	//WebDriver driver = null;

	// below line will be used to make this as thread safe when we run classes in
	// parallel.
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		this.testMethodName = result.getMethod().getMethodName();
		log.info("[Starting " + testMethodName + " ]");
		test = extent.createTest(testMethodName);
		extentTest.set(test);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("[Test " + testMethodName + " passed]");
		extentTest.get().log(Status.PASS, result.getMethod().getMethodName() + "Passed Successfully");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

		log.info("[Test " + testMethodName + " failed]");
		extentTest.get().fail(result.getThrowable());

		/*
		 * // this line will get instance of class (object) whose method got failed
		 * Object testobj = result.getInstance();
		 * 
		 * //this line will get class whose method got failed Class clazz =
		 * result.getTestClass().getRealClass();
		 * 
		 * WebDriver driver = null; try { driver =
		 * (WebDriver)clazz.getDeclaredField("driver").get(testobj); } catch
		 * (IllegalArgumentException | IllegalAccessException | NoSuchFieldException |
		 * SecurityException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * try {
		 * extentTest.get().addScreenCaptureFromPath(takeScreenshot(testMethodName,
		 * driver)); } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		/*System.out.println("***** Error " + result.getName() + " test has failed *****");
		String methodName = result.getMethod().getMethodName();
		ITestContext context = result.getTestContext();
		WebDriver driver = (WebDriver) context.getAttribute("driver");
		takeScreenShot(methodName, driver);*/

	}

	/*public void takeScreenShot(String methodName, WebDriver driver) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in d drive with test method name
		try {
			FileUtils.copyFile(scrFile, new File(filePath + methodName + ".png"));
			System.out.println("***Placed screen shot in " + filePath + " ***");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		this.testName = context.getCurrentXmlTest().getName();
		this.log = LogManager.getLogger(testName);
		log.info("[TEST " + testName + " STARTED]");

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		log.info("[ALL " + testName + " FINISHED]");
		extent.flush();

	}

}
