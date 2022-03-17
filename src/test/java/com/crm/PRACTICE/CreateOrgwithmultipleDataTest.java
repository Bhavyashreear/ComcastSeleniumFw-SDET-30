package com.crm.PRACTICE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgwithmultipleDataTest {

	//create object for all utilities
	PropertyFileUtility pLib=new PropertyFileUtility();
	ExcelFileUtility eLib=new ExcelFileUtility();
	WebDriverUtility wLib=new WebDriverUtility();
	JavaUtility jLib=new JavaUtility();
	
	@Test(dataProvider="OrgtestData")
	public void createOrgwithmultipleData(String OrgName,String indType) throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		
		//read data
		String BROWSER = pLib.readDatafromPropertyFile("browser");
		String URL = pLib.readDatafromPropertyFile("url");
		String USERNAME = pLib.readDatafromPropertyFile("username");
		String PASSWORD = pLib.readDatafromPropertyFile("password");
		
		String orgname = OrgName+jLib.getRandomNumber();
		
		//launch application
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else{
			System.out.println("invalid browser");
		}
		
		wLib.maximizeWindow(driver);
		wLib.waitForElementTobeClickable(driver);
		driver.get("http://localhost:8888/");
		
		//login to application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		Reporter.log("login Successful",true);
		
		//navigate to organization
		HomePage hp = new HomePage(driver);
		hp.ClickonOrgLnk();
		Reporter.log("navigated to orglink",true);
		
		//create org
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickonCreateorgImg();
		Reporter.log("click on create orglink",true);
		
		//create new org
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createNewOrg(orgname, indType);
		Reporter.log("Create org with industry type",true);
		
		//validate
		OrganizationInfoPage iop = new OrganizationInfoPage(driver);
		String  actHeader= iop.OrgNameInfo();
		if(actHeader.contains(orgname))
		{
			System.out.println("passed");
		}
		else
		{
			System.out.println("failed");
		}
		Reporter.log("verification succesfull",true);
		
		//logout
		hp.signOutofApp(driver);
		
		driver.quit();
	}
	
	@DataProvider
	(name="OrgtestData")
	public Object[][] getData() throws Throwable
	{
		Object[][] data = eLib.readmultipleDataFromExcel("orgnamemultipledata");
		return data;
	}
}
