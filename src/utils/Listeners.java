package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.DriverManager;

public class Listeners implements ITestListener{
	
	ExtentReports extent = new ExtentReports();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	ConfigReader cr = new ConfigReader();

	static int i = 0;
	@Override
	public void onStart(ITestContext context) {
		String reportPath="";
		try {
			reportPath = cr.get("reportPath");
		} catch (IOException e) {
			e.printStackTrace();
		}
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath+"outputReport.html");
		extent.attachReporter(reporter);
		
	}
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest("UserCreation");
		extentTest.set(test);
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		i=i+1;
		// TODO Auto-generated method stub
		extentTest.get().pass("Test"+i+" is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String screenShotPath="";
		
		try {
			screenShotPath = cr.get("screenShotPath");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		i=i+1;
		try {
			//TakeScreenshot.takeScreenshot((WebDriver)result.getTestContext().getAttribute("driver"));
			WebDriver driver = DriverManager.getDriver();
			TakeScreenshot.takeScreenshot(driver);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();  
		} catch (IOException e) {
			e.printStackTrace();
		}
		extentTest.get().fail("Test"+i+" is failed due to "+result.getThrowable(),MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath+"test.png").build());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		i=i+1;
		extentTest.get().skip("Test"+i+" is skipped");
	}



	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
