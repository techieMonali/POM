package com.irctc.util;

import java.io.IOException;

import org.testng.ITestContext;  
import org.testng.ITestListener;  
import org.testng.ITestResult;

import com.irctc.base.testBase;  

public class listener extends testBase implements ITestListener   
{  
@Override  
public void onTestStart(ITestResult result) {  
// TODO Auto-generated method stub  
}  
  
@Override  
public void onTestSuccess(ITestResult result) {  
// TODO Auto-generated method stub  
System.out.println("Success of test cases and its details are : "+result.getName());  
}  
  
@Override  
public void onTestFailure(ITestResult result) {  
// TODO Auto-generated method stub  
	try {
		testUtil.takeScreenshot();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
System.out.println("Failure of test cases and its details are : "+result.getName());  
}  
  
@Override  
public void onTestSkipped(ITestResult result) {  
// TODO Auto-generated method stub  
System.out.println("Skip of test cases and its details are : "+result.getName());  
}  
  
@Override  
public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
// TODO Auto-generated method stub  
System.out.println("Failure of test cases and its details are : "+result.getName());  
}  
  
@Override  
public void onStart(ITestContext context) {  
// TODO Auto-generated method stub  
}  
  
@Override  
public void onFinish(ITestContext context) {  
// TODO Auto-generated method stub  
}  
}  