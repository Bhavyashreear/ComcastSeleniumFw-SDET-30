package com.crm.ContactsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.CreateContactsPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactwithOrgNameTest extends BaseClass{
	@Test
	public void createContactwithOrgNameTest() throws Throwable
	{
			
	 String LastName=eLib.readDataFromexcel("Contacts",1,4);
	 String OrgName = eLib.readDataFromexcel("Contacts", 2,4)+"_"+jLib.getRandomNumber();
	 
			
		/*Step 4: navigate to organizations link*/
	    HomePage hp = new HomePage(driver);
	   hp.ClickonOrgLnk();
	   
	   /*step5:click on create organiztaion button*/
		 OrganizationsPage op = new OrganizationsPage(driver);
		 op.clickonCreateorgImg();
		 
		 /*step6:enter mandatory fields and save*/
		 CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		 cop.createNewOrg(OrgName);
		 
		 hp.ClickonContactsLnk();
		 
	   ContactPage ccp=new ContactPage(driver);
	   ccp.clickonCreateContactImg();
	
	   CreateContactsPage ccp1=new CreateContactsPage(driver);
	   ccp1.createNewContacts(OrgName, LastName);
	 
	 
}	 
}
