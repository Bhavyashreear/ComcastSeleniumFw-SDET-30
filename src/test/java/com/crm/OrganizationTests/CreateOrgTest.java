package com.crm.OrganizationTests;

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
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationsPage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.crm.GenericLibrary.ListerImplementationClass.class)
public class CreateOrgTest extends BaseClass {
	@Test(groups="regressionsSuite")
	public void createOrgTest() throws Throwable
	{
	
	 
	 String OrgName=eLib.readDataFromexcel("Orgname",1,2)+"_"+jLib.getRandomNumber();
	 
				
			/*Step 4: navigate to organizations link*/
		HomePage hp = new HomePage(driver);
		hp.ClickonOrgLnk();
		Assert.fail();
		
		/*step5:click on create organiztaion button*/
		 OrganizationsPage op = new OrganizationsPage(driver);
		 op.clickonCreateorgImg();
		 
		 /*step6:enter mandatory fields and save*/
		 CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		 cop.createNewOrg(OrgName);
		 
		 /*step7:verification*/
		 OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		 String actOrgName = oip.OrgNameInfo();
		 if(actOrgName.contains(OrgName))
		 {
			 System.out.println(actOrgName+"......>data verified");
		 }
		 else
		 {
			 System.out.println("data verified");
		 }
		
}
	@Test(groups="smokeSuite")
	 public void testscript()
	 {
		 System.out.println("This is test script 2");
	 }
}