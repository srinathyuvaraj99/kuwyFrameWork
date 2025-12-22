package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {
	//WebDriver driver;
	public static void takeScreenshot(WebDriver driver) throws IOException {
		
		File f = new File("C:\\Users\\Srinath\\SelenimFW\\AutomationFrameWork\\src\\reports\\Screenshots\\test.png");
		File screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, f);
		
		
	}

}
