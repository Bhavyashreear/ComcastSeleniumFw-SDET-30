package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
@Test(dataProvider="getData")
public void sampleDataProvider(String Name,String model,int quantity)
{
System.out.println(Name+"   "+model+"  "+quantity);
}

@DataProvider
	public Object[][] getData()
{
	Object[][] obj=new Object[4][3];
	
	obj[0][0]="Mi";
	obj[0][1]="11 pro max";
	obj[0][2]=25;
	
	obj[1][0]="iPhone";
	obj[1][1]="12 pro";
	obj[1][2]=10;
	
	obj[2][0]="Vivo";
	obj[2][1]="18 pro";
	obj[2][2]=20;
	
	obj[3][0]="samsung";
	obj[3][1]="80s series";
	obj[3][2]=29;
	
	return obj;
	
}
}
