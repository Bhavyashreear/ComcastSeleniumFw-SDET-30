package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {
@Test
public void SampleJDBCExecuteUpdate() throws SQLException
{
	Connection con = null;
try
{
	//step1:register the database
	Driver driverRef = new Driver();
	DriverManager.registerDriver(driverRef);
	
	//step2:get connection from database
	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
	
	//step3:issue create statement
	Statement stat = con.createStatement();
	
	//step4:execute a quary
	//insert into student valuse('Adarsh',11,'Japan');
	int result = stat.executeUpdate("insert into students values(6,'Veena','Female')");
	if(result==1)
	{
		System.out.println("data added successfully");
	}
	else
	{
		System.out.println("data not added");
	}
}
	finally
	//step45:close the database
	{
		con.close();
	System.out.println("connection closed");
}
}
}
