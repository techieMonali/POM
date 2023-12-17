package com.irctc.util;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.irctc.base.testBase;

public class listener extends testBase implements ITestListener {
	static Date d = new Date();
	static String fileName = "ExtentReport_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";

	private static ExtentReports extent = ExtentManager
			.createInstance(System.getProperty("user.dir") + "\\testResults\\reports\\" + fileName);

	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = extent
				.createTest(result.getTestClass().getName() + "     @TestCase : " + result.getMethod().getMethodName());
		testReport.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
// TODO Auto-generated method stub  
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE:- " + methodName.toUpperCase() + " - PASSED" + "</b>";
		Markup markup = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		testReport.get().pass(markup);
		System.out.println("Success of test cases and its details are : " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
// TODO Auto-generated method stub 
		String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());
        testReport.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
                + "</font>" + "</b >" + "</summary>" +excepionMessage.replaceAll(",", "<br>")+"</details>"+" \n");
         
        try {
 
        	testUtil.takeScreenshot();
            testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
                    MediaEntityBuilder.createScreenCaptureFromPath(testUtil.screenshotName)
                            .build());
        } catch (Exception e) {
 
        }
         
        String failureLogg="TEST CASE FAILED";
        Markup markup = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
        testReport.get().log(Status.FAIL, markup);
        
		/*try {
			testUtil.takeScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("Failure of test cases and its details are : " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
// TODO Auto-generated method stub  
		String methodName=result.getMethod().getMethodName();
        String logText="<b>"+"TEST CASE:- "+ methodName.toUpperCase()+ " - SKIPPED"+"</b>";     
        Markup markup = MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
        testReport.get().skip(markup);
		System.out.println("Skip of test cases and its details are : " + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
// TODO Auto-generated method stub  
		System.out.println("Failure of test cases and its details are : " + result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
// TODO Auto-generated method stub  
	}

	@Override
	public void onFinish(ITestContext context) {
		 if (extent != null) {
			 
	            extent.flush();
	        }
// TODO Auto-generated method stub  
	}
}