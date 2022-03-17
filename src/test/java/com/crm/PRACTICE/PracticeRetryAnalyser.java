package com.crm.PRACTICE;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeRetryAnalyser {
@Test(retryAnalyzer=com.crm.GenericLibrary.RetryAnalyzerImplementation.class)

public void practiceRetry()
{
	System.out.println("this is test 1");
	Assert.fail();
	System.out.println("test is passed");
}
}
