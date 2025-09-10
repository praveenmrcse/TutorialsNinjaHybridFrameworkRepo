package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReport {
	
	public static ExtentReports generateExtentReport() {
		
		ExtentReports extentReports=new ExtentReports();
		
		File extentReportFile=new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReporter.html");
		ExtentSparkReporter extentSparkReport= new ExtentSparkReporter(extentReportFile);
		
		extentSparkReport.config().setTheme(Theme.DARK);
		extentSparkReport.config().setReportName("Tutorials Ninja Automation Test Results Reports");
		extentSparkReport.config().setDocumentTitle("TN Automation");
		
		extentReports.attachReporter(extentSparkReport);
		
		Properties prop=new Properties();
		File filePath1=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		try{
			FileInputStream fis=new FileInputStream(filePath1);
			prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		extentReports.setSystemInfo("Application URL", prop.getProperty("url"));
		extentReports.setSystemInfo("Browser Name", prop.getProperty("browserName"));
		extentReports.setSystemInfo("Email", prop.getProperty("validEmail"));
		extentReports.setSystemInfo("Password", prop.getProperty("validPassword"));
		
		return extentReports;
		
	}

}
