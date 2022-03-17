package com.crm.ContactsTest;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.CreateContactsPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.crm.GenericLibrary.ListerImplementationClass.class)
public class CreateConTest extends BaseClass {
		@Test(groups="smokeSuite")
		
		public void createConTest() throws Throwable
		
		{
			
			 String lastName=eLib.readDataFromexcel("Orgname",1,2)+"_"+jLib.getRandomNumber();
			 
				//Step 3: navigate to Contacts link
				HomePage hp = new HomePage(driver);
				hp.ClickonContactsLnk();
				
				ContactPage cp=new ContactPage(driver);
				cp.clickonCreateContactImg();
								
				CreateContactsPage ccp = new CreateContactsPage(driver);
				ccp.createNewContacts(lastName);
					 Assert.fail();
	}
		@Test
		public void Samplescript1()
		{
			System.out.println("sample testcase 1");
		}
		@Test
		public void Samplescript2()
		{
			System.out.println("sample testcase 2");
		}
		@Test
		public void Samplescript3()
		{
			System.out.println("sample testcase 3");
		}
	}
	
