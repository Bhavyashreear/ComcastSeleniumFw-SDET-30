package com.crm.PRACTICE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class PrintLastName extends BaseClass
{
	@Test
	public void printLastNameTest()
	{
		HomePage hp = new HomePage(driver);
		hp.getContactsLnk().click();
		
	    List<WebElement> wb = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[4]"));
	    int co = wb.size();
	      
	    
	    for(int i=1; i<co; i++)
	    {
	    	WebElement w=wb.get(i);
	    	System.out.println(w.getText());
	   
	}

}
}
