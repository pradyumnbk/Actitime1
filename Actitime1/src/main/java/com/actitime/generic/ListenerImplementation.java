package com.actitime.generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener{

	ExtentReports report;
	ExtentTest tests;
	public void onTestStart(ITestResult result) {
		tests = report.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
	tests.log(Status.PASS, result.getMethod().getMethodName()+"is passed");
	}

	public void onTestFailure(ITestResult result)
	{
		tests.log(Status.FAIL, result.getMethod().getMethodName()+"is failed");
		tests.log(Status.FAIL, result.getThrowable());
		String screenshotPath=null;
		try {
			screenshotPath = WebdriverCommonLibCls.takeScreenShot(BaseCls.staticDriver, result.getMethod().getMethodName());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tests.addScreenCaptureFromPath(screenshotPath);
	}

	public void onTestSkipped(ITestResult result) {
		tests.log(Status.SKIP, result.getMethod().getMethodName()+"is skipped");
		tests.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	
	public void onStart(ITestContext result) {
		File file=new File(System.getProperty("user.dir")+"/ExtentReport.html");
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(file);
		htmlReport.config().setDocumentTitle("Actitime version 1.0");
		htmlReport.config().setReportName("Test Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		//add all the configurations to extent report
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("platform", "windows 10");
		report.setSystemInfo("app url", "http://demo.actitime.com");
		report.setSystemInfo("reporter name", "pradyumn barik");
		
		 
	}

	public void onFinish(ITestContext context) {
	
		report.flush();
	}
	
}
