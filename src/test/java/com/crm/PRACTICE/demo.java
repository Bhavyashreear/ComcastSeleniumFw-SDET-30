package com.crm.PRACTICE;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class demo {
@Test
public void demo() throws Throwable{

	FileInputStream fis = new FileInputStream("./src/test/resources/Data.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	System.out.println(wb.getSheet("Sheet1").getRow(1).getCell(0).toString());
	
}
}

