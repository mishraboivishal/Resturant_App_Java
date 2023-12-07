package com.jdbc_config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {
	
	public Connection getConnection() throws SQLException{
		
		try {
			// 1register driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		// 2 create connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "RohanMYSQL1234");
		
		
		return con;
	}
	
	
}
