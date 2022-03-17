package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice2 {
	@Test(dataProvider="getData")
	public void sampleDataProvider(String Name,String model)
	{
	System.out.println(Name+"   "+model);
	}

	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj=new Object[6][2];
	

	obj[0][0]="lenova";
	obj[0][1]="ideapad 330";
	
	
	obj[1][0]="dell";
	obj[1][1]="12 pro";
	
	
	obj[2][0]="Vivo";
	obj[2][1]="18 pro";
	
	
	obj[3][0]="samsung";
	obj[3][1]="80s series";
	
	
	obj[4][0]="oneplus";
	obj[4][1]="6s pro";
	
	
	obj[5][0]="huwei";
	obj[5][1]="y7 prime 2018 series";
	
	
	return obj;
}

}