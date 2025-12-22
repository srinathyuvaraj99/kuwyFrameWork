package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {
	private int count = 0;
	final int maxCount = 0;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if (count<maxCount) {
			count++;
			return true;
		}
		
		return false;
	}

}
