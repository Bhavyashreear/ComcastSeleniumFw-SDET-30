package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class ContactPage extends WebDriverUtility {
	
	//step1:declaration
		@FindBy(xpath="//img[@alt='Create Contact...']")
		private WebElement createContactsLookupImg;
		
		//step2:initiliztation
		public ContactPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}

		//step3:utilization
		public WebElement getCreateContactsLookupImg() 
		{
			return createContactsLookupImg;
		}
		
		//Business library
		public void clickonCreateContactImg()
		{
			createContactsLookupImg.click();
		}

}
