package com.crm.OrganizationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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

public class CreateOrganizationTest extends BaseClass
{
@Test
public void CreateOrganizationTest() throws Throwable

{
	//step1:launch the browser
	WebDriverManager.chromedriver().setup();
	WebDriverManager.firefoxdriver().setup();

    String Orgname = eLib.readDataFromexcel("Orgname", 0, 3);

     
			/*Step 4: navigate to organizations link*/
		HomePage hp = new HomePage(driver);
		hp.ClickonOrgLnk();
		String ExpData="Organizations";
		String actData=driver.findElement(By.linkText("Organizations")).getText();
		Assert.assertEquals(actData, ExpData);
		
		SoftAssert sa=new SoftAssert();
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickonCreateorgImg();
		String expHeader="Creating New Organizations";
		String actHeader=driver.findElement(By.xpath("//span[@class='IvtHeaderText']")).getText();
		sa.assertEquals(actHeader,expHeader);
		
		
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createNewOrg(Orgname);
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String catOrgName=oip.OrgNameInfo();
		Reporter.log(Orgname+"org created",true);
				 
		 }
}