package com.crm.PRACTICE;

import org.testng.annotations.Test;

public class ReadDataFromcmdLineTest {
@Test
public void readDataFromcmdLine()
{
	String BROWSER = System.getProperty("browser");
	String URL = System.getProperty("URL");
	String USERNAME = System.getProperty("Username");
	String PASSWORD = System.getProperty("Password");
	
	System.out.println("browser name is======>"+BROWSER);
	System.out.println("Url is========>"+URL);
	System.out.println("Username is======>"+USERNAME);
	System.out.println("Password is======>"+PASSWORD);
}
}
