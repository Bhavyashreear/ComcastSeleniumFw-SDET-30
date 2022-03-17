package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteDataVerification {
	@Test
	public void sampleJDBCExecuteQuery () throws Throwable
	{
		String expData = "bhavya";
		//step 1:register the database
		Driver d=new Driver();
		DriverManager.registerDriver(d);
		
		//step 2: get connector from database-- provide db name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
		
		//step 3 :issue create statement
		Statement state = con.createStatement();
		
		//execute query--> provide tablename
		ResultSet result = state.executeQuery("select * from students;");
		while(result.next())
		{
			String actData = result.getString(2);
			System.out.println(actData);
			if(expData.equalsIgnoreCase(actData))
			{
				System.out.println(actData+"  Data is verified");
				break;
			}else
				{
				System.out.println("not verified");
				}
			}
		
			
		//close database
		con.close();
	}
	
}
