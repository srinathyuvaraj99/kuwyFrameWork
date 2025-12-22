package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.ConfigReader;



public class BaseClass  {
	//WebDriver driver;
		
	
	@BeforeMethod (alwaysRun = true)
		public void launchPage() throws IOException
		{
		    ConfigReader cr = new ConfigReader();
		    String currentBrowser = cr.get("browserName");
		    BrowserFactory bf = new BrowserFactory();
		    WebDriver driver = bf.createInstance(currentBrowser);
			driver.manage().window().maximize();
		    DriverManager.setDriver(driver);
		    String baseUrl = cr.get("baseUrl");
			driver.get(baseUrl);
	    }
	
	
	@AfterMethod (alwaysRun = true)
		public void tearDown() 
		{
		WebDriver driver= DriverManager.getDriver();
		driver.quit();
		DriverManager.unLoad();
		}


	
	

}
