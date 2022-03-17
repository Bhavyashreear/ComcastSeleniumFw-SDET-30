package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class OrganizationsPage extends WebDriverUtility {

	//step1:declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgLookupImg;
	
	//step2:initiliztation
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//step3:utilization
	public WebElement getCreateOrgLookupImg() {
		return createOrgLookupImg;
	}
	
	//Business library
	public void clickonCreateorgImg()
	{
		createOrgLookupImg.click();
	}
	
	
}
