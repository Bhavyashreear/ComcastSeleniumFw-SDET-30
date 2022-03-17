package com.crm.GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Connection conn=null;
public void connectToDb() throws Throwable
{
	Driver driver = new Driver();
	DriverManager.registerDriver(driver);
	conn=DriverManager.getConnection(IPathConstants.dbURL, IPathConstants.dbUsername, IPathConstants.dbPassword);
}
/**
 * This method will close database connection
 * @throws Throwable
 */
public void closeDB() throws Throwable
{
	conn.close();
}
/**
 * This method will execute the query and written the data
 * @param query
 * @param Columnindex
 * @param expData
 * @return
 * @throws Throwable 
 */
public String executeQueryAndGetData(String query,int Columnindex,String expData) throws Throwable
{
	String data=null;
	boolean flag=false;
	ResultSet result=conn.createStatement().executeQuery(query);
	while(result.next())
	{
		data=result.getString(Columnindex);
		if(data.equalsIgnoreCase(expData))
		{
			flag=true;//flag rising
			break;
		}
	}
	if(flag)
	{
		System.out.println(data+"....>data verified");
		return expData;
	}
	else
	{
		System.out.println("data not verified");
		return"";
	}
	}
}