package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyFilePRACTICE {
	@Test
	public void propertyFile() throws Throwable
	{
		//Step 1: read the file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//Step 2: Create Obj of Properties
		Properties pObj = new Properties();
		pObj.load(fis);
		
		//Step 3:read the data
		String URL = pObj.getProperty("username");
		
		//Verification
		System.out.println(URL);
    
	}
}
