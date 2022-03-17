package com.crm.ContactsTest;

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
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactsformultipleDataTest {
	//create object for all utilities
		PropertyFileUtility pLib=new PropertyFileUtility();
		ExcelFileUtility eLib=new ExcelFileUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		JavaUtility jLib=new JavaUtility();
		
		@Test(dataProvider="OrgtestData")
		public void createContactsformultipleData(String Contacts) throws Throwable
		{
			WebDriverManager.chromedriver().setup();
			WebDriverManager.firefoxdriver().setup();
			
			//read data
			String BROWSER = pLib.readDatafromPropertyFile("browser");
			String URL = pLib.readDatafromPropertyFile("url");
			String USERNAME = pLib.readDatafromPropertyFile("username");
			String PASSWORD = pLib.readDatafromPropertyFile("password");
			
			String contact = Contacts+jLib.getRandomNumber();
			
			//launch application
			WebDriver driver=null;
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				driver=new ChromeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("FIREFOX"))
			{
				driver=new FirefoxDriver();
			}
			else{
				System.out.println("invalid browser");
			}
			
			wLib.maximizeWindow(driver);
			wLib.waitForElementTobeClickable(driver);
			driver.get("http:localhost:8888/");
			
			//login to application
			LoginPage lp = new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			Reporter.log("login Successful",true);
			
			//navigate to organization
			HomePage hp = new HomePage(driver);
			hp.ClickonContactsLnk();
			Reporter.log("navigated to Contactslink",true);
			
			//create org
			ContactPage op = new ContactPage(driver);
			op.clickonCreateContactImg();
			Reporter.log("click on create Contactslink",true);
			
			//create new org
			CreateOrganizationPage cop = new CreateOrganizationPage(driver);
			cop.createNewOrg(Contacts);
			Reporter.log("Create contacts with industry type",true);
			
			//validate
			ContactInfoPage iop = new ContactInfoPage(driver);
			String  actHeader= iop.ContactNameInfo();
			if(actHeader.contains(Contacts))
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
		(name="ContactstestData")
		public Object[][] getData() throws Throwable
		{
			Object[][] data = eLib.readmultipleDataFromExcel("Contactsmultipledata");
			return data;
		}

}
