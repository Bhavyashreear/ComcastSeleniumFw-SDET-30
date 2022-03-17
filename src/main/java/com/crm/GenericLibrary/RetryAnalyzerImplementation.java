package com.crm.GenericLibrary;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementation implements IRetryAnalyzer{

	int count=1;
	int retryCount=5; //count varies it depends on test script
	
	public boolean retry(ITestResult result) 
	{
		while(count<retryCount)
		{
		count++;
		return true;
		
	}
		return false;
		
	}
}
