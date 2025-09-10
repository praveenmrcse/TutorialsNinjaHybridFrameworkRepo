package com.tutorialsninja.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.qa.utils.Utilities;
import com.tutorialsninja.qa.utils.extentReport;

public class MyListeners implements ITestListener{
	
	ExtentReports extentReports;
	ExtentTest extentTest;
	
	@Override
	public void onStart(ITestContext context) {
		
		extentReports = extentReport.generateExtentReport();
		
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		extentTest = extentReports.createTest(result.getName());
		extentTest.log(Status.INFO, "Executing the test: " +result.getName());
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentTest.log(Status.PASS, result.getName()+" got executed successfully");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
				
		WebDriver driver=null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}		
		String destinationFilePath=Utilities.captureScreenshot(driver, result.getName());
		extentTest.addScreenCaptureFromPath(destinationFilePath);		
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, result.getName()+" failed the test");		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, result.getName()+" skipped the test");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
		
		String extentReportFilePath=System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html";
		File reportFilePath=new File(extentReportFilePath);
		
		try {
			Desktop.getDesktop().browse(reportFilePath.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
