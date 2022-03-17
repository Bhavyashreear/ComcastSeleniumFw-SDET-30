package com.crm.OrganizationTests;

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
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationsPage;
@Listeners(com.crm.GenericLibrary.ListerImplementationClass.class)
public class CreateOrgwithIndustryType extends BaseClass {
@Test
public void createOrgwithIndustryTypeTest() throws Throwable
{
	
	
	 String Orgname=eLib.readDataFromexcel("Orgname",1,2)+"_"+jLib.getRandomNumber();
	 String indType = eLib.readDataFromexcel("Orgname", 2,5);
	 
					
				/*Step 4: navigate to organizations link*/
			HomePage hp = new HomePage(driver);
			hp.ClickonOrgLnk();
			
			/*step5:click on create organiztaion button*/
			 OrganizationsPage op = new OrganizationsPage(driver);
			 op.clickonCreateorgImg();
			 Assert.fail();
			 
			 /*step6:enter mandatory fields and save*/
			 CreateOrganizationPage cop = new CreateOrganizationPage(driver);
			 cop.createNewOrg(Orgname, indType);
			 
			 
			
			
	}
	}

