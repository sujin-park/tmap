package com.secondproject.util.db;

import java.sql.*;

public class DBConnection {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			System.out.println("드라이버로딩 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() {
		 Connection conn = null;
		 try {
			conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","kitri","kitri");
//			System.out.println("db연결성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
