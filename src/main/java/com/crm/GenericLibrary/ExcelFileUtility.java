package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains generic methods to read and write data into excel sheet
 * @author vishwa
 *
 */

public class ExcelFileUtility {
	// static final String IPathConstants = null;
	//private static final String Excelpath = null;
	//private Date value;
	/**
	 * 	
	 * @param Sheetname
	 * @param rowno
	 * @param celno
	 * @return
	 * @throws Throwable
	 */
public String readDataFromexcel(String Sheetname,int rowno,int celno) throws Throwable
{
	 FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(Sheetname);
	Row ro = sh.getRow(rowno);
	Cell cel = ro.getCell(celno);
	String value = cel.getStringCellValue();
	return value;
	
}
public void writedataintoExcel(String SheetName,int rowno,int celno,String value) throws Throwable
{
	FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(SheetName);
	Row ro = sh.getRow(rowno);
	 Cell cel = ro.createCell(celno);
	 cel.setCellValue(value);
	 FileOutputStream fos=new FileOutputStream(IPathConstants.ExcelPath);
	 wb.write(fos);
}

public Object[][] readmultipleDataFromExcel(String SheetName) throws Throwable
{
	FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(SheetName);
	int LastRow=sh.getLastRowNum();
	int lastCell=sh.getRow(0).getLastCellNum();
	
	Object[][] data = new Object[LastRow][lastCell];
	
	for(int i=0;i<LastRow;i++)
	{
		for(int j=0;j<lastCell;j++)
		{
			data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();		
		}
	}



return data;
}


}