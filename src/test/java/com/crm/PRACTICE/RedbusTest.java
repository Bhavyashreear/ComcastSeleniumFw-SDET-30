package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RedbusTest {
@Test
public void calender()
{
	String date="15";
	String monthandYear="Jun 2022";
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://www.redbus.in/");
	
	driver.findElement(By.xpath("//span[@class='fl icon-calendar_icon-new icon-onward-calendar icon']")).click();
	String arrow = "//button[.='>']";
	String datepath = "//td[.='"+monthandYear+"']/ancestor::table[@class='rb-monthTable first last']/descendant::td[.='"+date+"']";
	for(;;)
	{
	try {
		driver.findElement(By.xpath(datepath)).click();
		break;
		
	} catch (Exception e)
	{
		driver.findElement(By.xpath(arrow)).click();
	}
}
}
}