package com.crm.PRACTICE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class Delete5thContact extends BaseClass 
{
	@Test
	public void delete5thContact()
	{
		HomePage hp = new HomePage(driver);
		hp.ClickonContactsLnk();
		
		List<WebElement> wb = driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		WebElement w=wb.get(2);
		w.click();
		WebElement del = driver.findElement(By.xpath("//table[@class='lvt_small']/tbody/tr[7]/td[10]/a[.='del']"));
		del.click();
		wLib.acceptAlert(driver);
		
		
	}

}
