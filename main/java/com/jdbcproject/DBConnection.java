package com.jdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection DBConnect() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");//step 1 to load driver class
		//step 2 connection 
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/ipltemsjdbc","root","root");
		return con;
	}

}
