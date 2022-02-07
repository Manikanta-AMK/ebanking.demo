package com.banking.genriclib;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class extentreport2 {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	

	public void onStart(ITestContext testContext) {
		String dateName = new SimpleDateFormat("dd-MMM-yyyy").format(new Date());
		String reportDestination = "C:\\\\Users\\\\Windows 10\\\\git\\\\repository\\\\zohocrm\\\\reports\\\\TestReports.html"
				+ dateName + ".html";

		// String reportDestination1 = Constants.mainFile + Constants.test_path +
		// Constants.ExtentFile_path + dateName+ ".html";

		sparkReporter = new ExtentSparkReporter(reportDestination);
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Host Name", "Localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User Name", "AMK");
		sparkReporter.config().setReportName("smoke Report");
		sparkReporter.config().setTheme(Theme.DARK);
	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName()); // create new entry in the report
		test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
		test.info("************passed ********************");
	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName()); // create new entry in the report
		test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
		test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent
										
	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName()); // create new entry in th report
		test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
	}

	public void onFinish(ITestContext testContext) {
		extent.flush();
	}

}
