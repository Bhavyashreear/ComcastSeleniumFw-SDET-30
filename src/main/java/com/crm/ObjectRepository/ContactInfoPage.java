package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class ContactInfoPage extends WebDriverUtility {
	//step1:Declaration
		@FindBy(xpath="//span[@class='dvHeaderText']")
		private WebElement headerText;
		
		//step2:initilization
		public ContactInfoPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
	}

		//utilization
		public WebElement getHeaderText() {
			return headerText;
		}
		
		
		//business library
		public String ContactNameInfo()
		{
			String ContactInfo = headerText.getText();
			return ContactInfo;
		}

		
}
