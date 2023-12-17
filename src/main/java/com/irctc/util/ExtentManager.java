package com.irctc.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.irctc.base.testBase;

public class ExtentManager extends testBase {
	 private static ExtentReports extent;
	         
	    public static ExtentReports createInstance(String fileName) {
	         
	    	ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
	             
	        htmlReporter.config().setTheme(Theme.DARK);
	        htmlReporter.config().setDocumentTitle(fileName);
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName(fileName);
	         
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("Release No", "22");
	        extent.setSystemInfo("Environment", "QA");
	        extent.setSystemInfo("Build no", "B-12673");
	               
	        return extent;
	    }
}
