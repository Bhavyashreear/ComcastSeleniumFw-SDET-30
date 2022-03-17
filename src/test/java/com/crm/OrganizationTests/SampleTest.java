package com.crm.OrganizationTests;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;

public class SampleTest {
	@Test
	public void sampleTest() throws Throwable
	{
		
ExcelFileUtility eLib = new ExcelFileUtility();

String OrgName = eLib.readDataFromexcel("Sheet1", 1, 1);

System.out.println(OrgName);
}
}