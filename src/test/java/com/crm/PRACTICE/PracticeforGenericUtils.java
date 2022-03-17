package com.crm.PRACTICE;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;

public class PracticeforGenericUtils {
@Test
public void practice() throws Throwable
{
	JavaUtility jLib = new JavaUtility();
	int ran = jLib.getRandomNumber();
	String dat = jLib.getSystemDateinFormate();
	String date = jLib.getSystemDate();
	System.out.println(ran + date);
	System.out.println(dat);
	
	PropertyFileUtility pLib = new PropertyFileUtility();
	String brows = pLib.readDatafromPropertyFile("browser");
	System.out.println(brows);
}
}
