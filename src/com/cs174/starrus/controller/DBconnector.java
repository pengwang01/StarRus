package com.cs174.starrus.controller;
import java.sql.*;

import oracle.jdbc.driver.*;

public class DBconnector {
	private Connection conn = null;
	private String strConn = "jdbc:oracle:thin:@uml.cs.ucsb.edu:1521:xe"; 
	private String strUsername = "cs174a_pengwang01";
	private String strPassword = "5891775";
	
	
	public DBconnector(){
	}
	
	public void connect() throws SQLException{
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			conn = DriverManager.getConnection(strConn,strUsername,strPassword);
	}
	
	public void disconnect() throws SQLException{
		conn.close();
	}

	public Connection getConnection(){
		return conn;
	}
	
	public void test() throws SQLException { 
		// Create a Statement
		Statement stmt = conn.createStatement(); // Specify the SQL Query to run
		ResultSet rs = stmt.executeQuery ("SELECT * FROM customer"); // Iterate through the result and print the data
		System.out.println("result:");
		//System.out.println(rs.toString());
		while(rs.next()){
			System.out.println(rs.getString(1) +  rs.getString(2) + rs.getString(3));
		}
		// don't miss this
		rs.close();
	}
}
