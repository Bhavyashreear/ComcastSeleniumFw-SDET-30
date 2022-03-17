package com.crm.PRACTICE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.HomePage;

public class ContactsCheckbox extends BaseClass
{
	@Test
	public void contactsCheckbox() throws Throwable
	{
	HomePage hp = new HomePage(driver);
	hp.ClickonContactsLnk();
	
    List<WebElement> wb = driver.findElements(By.xpath("//input[@type='checkbox']"));
    int co = wb.size();
    System.out.println(co);
   
    
    for(int i=1; i<co; i++)
    {
    	WebElement w=wb.get(i);
    	w.click();
    	 Thread.sleep(1000
    			 );
    }
    
	
	
	
	
}
}
