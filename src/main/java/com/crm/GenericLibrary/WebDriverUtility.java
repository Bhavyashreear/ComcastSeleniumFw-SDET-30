package com.crm.GenericLibrary;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consits of all generic methods related to WenDriverActions
 * @author vishwa
 *
 */

public class WebDriverUtility {
	/**
	 * This method will maximize window
	 * @param driver
	 */
public void maximizeWindow(WebDriver driver)
{
	driver.manage().window().maximize();
}
/**b g
 * This method will wait for 20 seconds for the page to load
 * @param driver
 */
public void waitForElementTobeClickable(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}
/**
 * This method will wait for 10 seconds for an element to be clickable
 * @param driver
 * @param element
 */
public void waitForElementtobeClickable(WebDriver driver,WebElement element)
{
	WebDriverWait wait = new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
/**
 * This method will wait for 20 seconds for the element to be visible
 * @param driver
 * @param element
 */
public void waitForElementtobeVisible(WebDriver driver,WebElement element)
{
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOf(element));
}
/**
 * This method will select data from dropdown using index
 * @param element
 * @param index
 */
public void select(WebElement element,int index)
{
	Select sel = new Select(element);
	sel.selectByIndex(index);
}
/**
 * This method will select data from dropdown using visible text
 * @param element
 * @param text
 */
public void select(WebElement element,String text)
{
	Select sel = new Select(element);
	sel.selectByVisibleText(text);
}
/**
 * This method will select data from dropdown using visible text
 * @param value
 * @param element
 */
public void select(String value,WebElement element)
{
	Select sel = new Select(element);
	sel.selectByValue(value);
}
/**
 * This method will perform mousehover action
 * @param driver
 * @param element
 */
public void mouseHover (WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.moveToElement(element).perform();
	
}
/**
 * This method will perform drag and drop action
 * @param driver
 * @param src
 * @param target
 */
public void DragandDrop(WebDriver driver,WebElement src,WebElement target)
{
	Actions act=new Actions(driver);
	act.dragAndDrop(src, target).perform();
}
/**
 * This method will double click on element
 * @param driver
 * @param element
 */
public void DoubleClickAction(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.doubleClick(element);
}
/**
 * This method will double click on webpage
 * @param driver
 */
public void DoubleClickAction(WebDriver driver)
{
	Actions act=new Actions(driver);
	act.doubleClick().perform();
}
/**
 * This method will right click on webpage
 * @param driver
 */
public void RightClick(WebDriver driver)
{
	Actions act=new Actions(driver);
	act.contextClick().perform();
}
/**
 * This methos will right click on element
 * @param driver
 * @param element
 */
public void RightClick(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.contextClick(element).perform();
}
/**
 * This method will perform enter key
 * @param driver
 */
public void enterKeyPress(WebDriver driver)
{
	Actions act=new Actions(driver);
	act.sendKeys(Keys.ENTER).perform();
}
/**
 * This method will switch the frame based on index
 * @param driver
 * @param index
 */
public void SwitchtoFrame(WebDriver driver,int index)
{
	driver.switchTo().frame(index);
}
/**
 * This method will switch the frame based on nameorid
 * @param driver
 * @param nameorid
 */
public void SwitchtoFrame(WebDriver driver,String nameorid)
{
	driver.switchTo().frame(nameorid);
}
/**
 * This method will switch the frame based on address of the element
 * @param driver
 * @param address
 */
public void SwitchtoFrame(WebDriver driver,WebElement address)
{
	driver.switchTo().frame(address);
}
/**
 * This method will accept alert popup
 * @param driver
 */
public void acceptAlert(WebDriver driver)
{
	driver.switchTo().alert().accept();
}
/**
 * This method will cancel the alert popup
 * @param driver
 */
public void cancelAlert(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}
/**
 * This method will switch to window depending on partial window title
 * @param dribver
 * @param partialWinTitle
 */
public void switchToWindow(WebDriver driver,String partialWinTitle)
{
	//step1:use getwindowhandles to capture all window ids
	Set<String> windows = driver.getWindowHandles();
	
	//step2:iterate thru windows
	Iterator<String> it = windows.iterator();
	
	//step3:check whether there is next window
	while(it.hasNext())
	{
		//step4:capture current window id
		String winId = it.next();
		
		//step5:switch to current window and capture title
		String currentWinTitle = driver.switchTo().window(winId).getTitle();
		
		
		//step6:check whether the current window is expected
		if(currentWinTitle.contains(partialWinTitle))
		{
			break;
		}
		
	}
}
/**
 * This method will take screen shot and store it in folder called screenshot	
 * @param driver
 * @param screenShotName
 * @throws Throwable
 */
	public void getScreenShot(WebDriver driver,String screenShotName ) throws Throwable
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshot\\"+screenShotName+".png");
		Files.copy(src, dst);
	}
	/**
	 * This method will perform random scroll
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)","");
}
	/**
	 * This method will scroll until the specified element is found
	 * @param driver
	 * @param element
	 */
public void scrollAction(WebDriver driver,WebElement element)
{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	int y = element.getLocation().getY();
	js.executeScript("window.scrollBy(0,"+y+")",element);
	//js.executescript(argument[0].scrllIntoView()",element);
}
}
