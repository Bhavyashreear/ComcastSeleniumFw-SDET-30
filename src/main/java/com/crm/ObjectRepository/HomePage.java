package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
//step1:Declaration
	@FindBy(linkText="Organizations")
	private WebElement organizationLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText="Oppurtunities")
	private WebElement oppurtunitiesLnk;
	
	@FindBy(linkText="Products")
	private WebElement productsLnk;
	
	@FindBy(linkText="More")
	private WebElement MoreLnk;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignsLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLnk;
	
	//step2:initilization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//step3:generate getters

	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getOppurtunitiesLnk() {
		return oppurtunitiesLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getMoreLnk() {
		return MoreLnk;
	}

	public WebElement getCampaignsLnk() {
		return campaignsLnk;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignoutLnk() {
		return signoutLnk;
	}
	
	//Business library
	public void ClickonOrgLnk()
	{
		organizationLnk.click();
	}
	
	public void ClickonContactsLnk()
	{
		contactsLnk.click();
	}
	
	public void signOutofApp(WebDriver driver)
	{
		mouseHover(driver,administratorImg);
		signoutLnk.click();
		
	}
}
