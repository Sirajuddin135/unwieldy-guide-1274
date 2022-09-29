package com.cims.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class CIMSDB {
	public static Connection provideConnection() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/cimsdb";
		
		try {
			conn = DriverManager.getConnection(url, "root", "root");	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
