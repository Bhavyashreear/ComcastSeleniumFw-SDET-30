

package com.crm.GenericLibrary;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;
import com.mysql.cj.xdevapi.Result;

public class ListerImplementationClass implements ITestListener
{
	ExtentReports report;
	ExtentTest test;
	
public void onTestStart(ITestResult result) 
{
	String MethodName = result.getMethod().getMethodName();
	//Reporter.log(MethodName + "---testScript execution started");
	test=report.createTest(MethodName);
}

public void onTestSuccess(ITestResult result) 
{
	String MethodName = result.getMethod().getMethodName();
	//Reporter.log(MethodName + "---testScript execution successfull -pass");
	test.log(Status.PASS, MethodName+"..........>passed");
}
public void onStart(ITestContext context) 
{
	//Exceute will start here
	/*configure the report */
	ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtentReports/Report"+new JavaUtility().getSystemDateinFormate()+".html");
	htmlReport.config().setDocumentTitle("SDET-30Execution Report");
	htmlReport.config().setTheme(Theme.DARK);
	htmlReport.config().setReportName("Selenium Execution REport");
	
	report=new ExtentReports();
	report.attachReporter(htmlReport);
	report.setSystemInfo("Base-Browser", "Chrome");
	report.setSystemInfo("OS", "Windows");
	report.setSystemInfo("base-url", "http://localhost:8888");
	report.setSystemInfo("Reporter Name", "Vishwa");
}
	public void onFinish(ITestContext context)
	{
		//consolidate all the reports and check the report
		report.flush();
	}

	

	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
	}

	public void onTestFailedWithTimeout(ITestResult result) 
	{
		
		
	}

	public void onTestFailure(ITestResult result) 
	{
		String path=null;
		
		String MethodName = result.getMethod().getMethodName()+"-";
		
		//Reporter.log(MethodName + "---testScript failed",true);
		
		//step1:configure screen shot name
		String screenshotName = MethodName + new JavaUtility().getSystemDateinFormate();
		System.out.println(screenshotName);
		
		//step2:using screeenshot method from webdriver utility
		
			try {
				//new WebDriverUtility().getScreenShot(BaseClass.sDriver, screenshotName);
				EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseClass.sDriver);
				File src = eDriver.getScreenshotAs(OutputType.FILE);
				//String pa=Sysdtem.getProperty("user.dir")+"/ScreenShots/"+screenshotName+.PNG";
				 path="./ScreenShots/"+screenshotName+".png";
				File dst=new File(path);
				Files.copy(src,dst);
			} catch (Throwable e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		test.log(Status.FAIL, MethodName+".........>failed");
		//it will capture the exception and log it in the report
		test.log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromPath(path);
	}
	

	
	public void onTestSkipped(ITestResult result)
	{
		String MethodName = result.getMethod().getMethodName();
		//Reporter.log(MethodName + "---testScript Skipped");
		test.log(Status.SKIP, MethodName+"......>skipped");
		//it will capture  the exception and log it in the report
		test.log(Status.SKIP, result.getThrowable());
	}

	
}
