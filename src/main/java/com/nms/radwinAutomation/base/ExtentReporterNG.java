package com.nms.radwinAutomation.base;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	static ExtentReports extent;
	
	public static ExtentReports extentReportGenerator() {
		
		String path = System.getProperty("user.dir") + File.separator + "test-output" + "Report" + ".html"; ; 
				
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Web Appplication Automation");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Pratik Patel");
		return extent;
		
	}
	

}
