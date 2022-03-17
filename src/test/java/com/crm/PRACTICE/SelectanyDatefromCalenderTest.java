package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SelectanyDatefromCalenderTest
{
	@Test
	public void calender()
	{
		
		String date="4";
		String monthandYear="September 2022";
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		
		Actions action=new Actions(driver);
		action.moveByOffset(5, 5).click().perform();
		
		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		String arrowXpath="//span[@aria-label='Next Month']";
		String datexpath="//div[.='"+monthandYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date+"']";
		
		for(;;){
		try
		{
			driver.findElement(By.xpath(datexpath)).click();
			break;
		}
		catch(Exception e)
		{
			driver.findElement(By.xpath(arrowXpath)).click();
		}
	}	
	}
}
