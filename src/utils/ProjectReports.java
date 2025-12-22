package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ProjectReports {
	protected void startReport()
	{
		ExtentSparkReporter reporter = new ExtentSparkReporter(
				"C:\\Users\\Srinath\\SelenimFW\\AutomationFrameWork\\src\\reports\\outputReport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest Test = extent.createTest("UserCreation");
	}

}
