package com.crm.OrganizationTests;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationSelectTest {
		@Test
		
		public void createOrganizationSelectTest() throws Throwable
		{
			 WebDriverManager.firefoxdriver().setup();
			 WebDriverManager.chromedriver().setup();
			 
			PropertyFileUtility pLib=new PropertyFileUtility();
			JavaUtility jLib=new JavaUtility();
			ExcelFileUtility eLib=new ExcelFileUtility();
			WebDriverUtility wLib=new WebDriverUtility();
			
			/*step1:read all necessary data*/
			 String BROWSER=pLib.readDatafromPropertyFile("browser");
			 String URL=pLib.readDatafromPropertyFile("url");
			 String USERNAME=pLib.readDatafromPropertyFile("username");
			 String PASSWORD=pLib.readDatafromPropertyFile("password");
			 
			 String OrgName=eLib.readDataFromexcel("Orgname",1,2)+"_"+jLib.getRandomNumber();
			
		
			/*Step 2: launch the browser*/
			WebDriver driver=null;
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("firefox"))
			{
				driver = new FirefoxDriver();
			}
			else
			{
				System.out.println("invalid browser");
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(URL);
			
			
			 
			//Step3:login to application*/
				LoginPage lp = new LoginPage(driver);
				lp.loginToApp(USERNAME, PASSWORD);

					
					/*Step 4: navigate to organizations link*/
				HomePage hp = new HomePage(driver);
				hp.ClickonOrgLnk();
				
				/*step5:click on create organiztaion button*/
				 OrganizationsPage op = new OrganizationsPage(driver);
				 op.clickonCreateorgImg();
				
			
			
			/*Step 6: enter mandatory fields and save*/
			driver.findElement(By.name("accountname")).sendKeys(OrgName);
			Select s1=new Select(driver.findElement(By.name("industry")));
			s1.selectByVisibleText("Healthcare");
			
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			/*Step 7: logout of application*/
			hp.signOutofApp(driver);
			
			/*Step 8: close the browser*/
			driver.quit();
		 
	}
	}

