package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReaddatafromExcelSheetTest {
@Test
public void readdatafromExcel() throws Throwable
{
//step1:load excel file
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
	
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet1");
	Row ro = sh.getRow(0);

	//create a cell write new data
	Cell ce = ro.getCell(1);
	
	//read the data from excel
	String value = ce.getStringCellValue();
	System.out.println(value);

}

}
