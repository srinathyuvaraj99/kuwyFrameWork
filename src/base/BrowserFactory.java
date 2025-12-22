package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserFactory {
	
	public WebDriver createInstance(String browserName) {
		WebDriver driver;
		
		switch (browserName.toLowerCase())
		{
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default :
			throw new IllegalArgumentException("Invalid broswer : "+browserName);
		}  
		return driver;
	}

}
