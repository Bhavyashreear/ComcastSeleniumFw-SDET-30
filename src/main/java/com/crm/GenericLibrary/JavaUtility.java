package com.crm.GenericLibrary;

import java.util.Date;
import java.util.Random;

/**
 * This class consists of generic methods wrt java
 * @author vishwa
 *
 */
public class JavaUtility {
	
	/**
	 * This method will generate a random number and return it to user
	 * @return
	 */
public int getRandomNumber()
{
	Random ran = new Random();
	int random = ran.nextInt(500);
	return random;
}

/**
 * This method will generate current suystem date and return it to user
 * @return
 */
public String getSystemDate()
{
	Date d = new Date();
	String date = d.toString();
	return date;
}
/**
 * This method will generate System date and return date in formate
 * @return
 */

public String getSystemDateinFormate()
{
	Date d = new Date();
	String d1 = d.toString();
	String[] date = d1.split(" ");
	
	 String mon = date[1];
	 String day = date[2];
	 String time=date[3].replace(":", "-");
	 String year = date[5];
	
	 String DateFormate = day+"-"+mon+"-"+year+"-"+time;
	return DateFormate;
	 
	
	
}

}
