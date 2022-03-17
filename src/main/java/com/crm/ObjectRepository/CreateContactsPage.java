package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateContactsPage extends WebDriverUtility {
	
	//step1:declaration
			@FindBy(name="lastname")
			private WebElement lastNameEdt;
			
			@FindBy(xpath="//input[@name='account_name'/following-sibling::img[@alt='Select']")
			private WebElement orgNameLookupImg;
			
			@FindBy(name="leadsource")
			private WebElement leadsourceDropDown;
			
			@FindBy(xpath="//input[@title='Save [Alt+S]']")
			private WebElement saveBtn;
			
			@FindBy(name="search_text")
			private WebElement searchEdt;
			
			@FindBy(name="search")
			private WebElement searchBtn;

		

			
			//initialization
			public CreateContactsPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}

			//utilization
			public WebElement getLastNameEdt() {
				return lastNameEdt;
			}

			public WebElement getOrgNameLookupImg() {
				return orgNameLookupImg;
			}

			public WebElement getLeadsourceDropDown() {
				return leadsourceDropDown;
			}

			public WebElement getSaveBtn() {
				return saveBtn;
			}

			public WebElement getSearchEdt() {
				return searchEdt;
			}

			public WebElement getSearchBtn() {
				return searchBtn;
			}
			
			//business library
			public void createNewContacts(String lastName)
			{
				lastNameEdt.sendKeys(lastName);
				saveBtn.click();
			}
		
			public void createNewContacts(String lastName,String leadSource)
			{
				lastNameEdt.sendKeys(lastName);
				select(leadSource,leadsourceDropDown);
				saveBtn.click();
			}
			
			public void createNewContacts(WebDriver driver,String lastName,String leadSource, String Orgname)
			{
				lastNameEdt.sendKeys(lastName);
				orgNameLookupImg.click();
			switchToWindow(driver,"Accounts");
			searchEdt.sendKeys(Orgname);
				searchBtn.click();
				driver.findElement(By.xpath("//a[text()='"+Orgname+"']")).click();
				switchToWindow(driver,"Contacts");
				saveBtn.click();
				
			}
}
			
