package com.crm.GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public PropertyFileUtility pLib=new PropertyFileUtility();
	public JavaUtility jLib=new JavaUtility();
	public ExcelFileUtility eLib=new ExcelFileUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public DatabaseUtility dbLib=new DatabaseUtility();
	public WebDriver driver=null;
	
	public static WebDriver sDriver;
	 //..>initialize it to driver
	
	@BeforeSuite(groups={"regressionsSuite","smokeSuite"})
	
	public void connectDataBase()
	{
		//dbLib.connectToDb();
		
		Reporter.log("=========db connection successsfull========",true);
	}
	
	@BeforeClass(groups={"regressionsSuite","smokeSuite"})
	//@Parameters("BROWSER")
	//@BeforeTest
	public void launchBrowser() throws Throwable
	{
		//read data from propertyfile
		String BROWSER = pLib.readDatafromPropertyFile("browser");
		String URL = pLib.readDatafromPropertyFile("url");
		
		//create Runtimepolymorphism
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}else{
			System.out.println("invalid browser");
		}
		sDriver=driver; 
		wLib.maximizeWindow(driver);
		wLib.waitForElementTobeClickable(driver);
		driver.get("http://localhost:8888");
		Reporter.log("=========browser launch successful===========",true);
	}
	
	@BeforeMethod(groups={"regressionsSuite","smokeSuite"})
	public void login() throws Throwable
	{
		String USERNAME = pLib.readDatafromPropertyFile("username");
		String PASSWORD = pLib.readDatafromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		Reporter.log("==========login successful===========",true);
}
	@AfterMethod(groups={"regressionsSuite","smokeSuite"})
	public void logout()
	{
		HomePage hp = new HomePage(driver);
		hp.signOutofApp(driver);
		Reporter.log("=========logout successful========",true);
		
	}
	@AfterClass(groups={"regressionsSuite","smokeSuite"})
	//@AfterTest
	public void closeBrowser()
	{
		driver.quit();
		Reporter.log("==============browser close successful==========",true);
	}
	@AfterSuite(groups={"regressionsSuite","smokeSuite"})
	public void closeDb()
	{
		//dbLib.closeDB()
		Reporter.log("==========DB close successful=============",true);
	}
}
