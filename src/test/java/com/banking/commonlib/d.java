package com.banking.commonlib;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class d extends TestListenerAdapter{

	public void onTestSuccess(ITestResult result) {
		System.out.println(result + "test success");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println(result + "test fail");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println(result + "test skipped");
	}

	public void onTestStart(ITestResult result) {
		System.out.println(result + "test start");
	}
	

}
