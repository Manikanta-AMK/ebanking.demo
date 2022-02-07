package com.banking.commonlib;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listeners implements ITestListener {
	
	public void onStart(ITestContext arg) 
	{
		System.out.println("Start Test Execution...!!!" + arg.getName());
	}

	public void onFinish(ITestContext arg)
	{
		System.out.println("Finish Test Execution...!!!" + arg.getName());
	}

	public void onTestStart(ITestResult tr) 
	{
		System.out.println("Starting the Test Execution ...!!!" + tr.getName());
	}

	public void onTestSkipped(ITestResult tr)
	{
		System.out.println("Skipped the Test Execution...!!!" + tr.getName());
	}

	public void onTestSuccess(ITestResult tr) 
	{
		System.out.println("Passed the Test Execution...!!!" + tr.getName());
	}

	public void onTestFailure(ITestResult tr) 
	{
		System.out.println("Failed the Test Execution...!!!" + tr.getName());
	}

}
