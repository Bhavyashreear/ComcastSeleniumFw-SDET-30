package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {

	@Test
	public void sampleJDBCExecuteQuery() throws SQLException
	{
	//Step1:register the database
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//Step2: get connector from database-provide database name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
		
		//step3:issue create statement
		Statement state = con.createStatement();
		
		//step4:executequery-provide tablename
		ResultSet result = state.executeQuery("select * from students;");
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
			
		}
		
		//step5:close the database
		con.close();
	}
}
