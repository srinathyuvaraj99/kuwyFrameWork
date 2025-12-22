package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties prop;
	private static final String configPath = System.getProperty("user.dir")+"\\src\\testData\\config.properties";
	
	public Properties getProperties() throws IOException {
		FileInputStream fis = new FileInputStream(new File(configPath));
		prop=new Properties();
		prop.load(fis);
		return prop;		
	}
	
	public String get(String key) throws IOException {
		return getProperties().getProperty(key);
	}

}
