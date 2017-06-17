package com.secondproject.util.db;

import java.sql.*;

public class DBClose {
	public static void close(Connection conn, Statement stmt) {
		try {
			if(stmt!=null)
				stmt.close();
			if(conn!=null)
				conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			if(pstmt!=null)
				pstmt.close();
			if(conn!=null)
				conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(Connection conn, Statement stmt,ResultSet rs) {
		try {
			if(stmt!=null)
				stmt.close();
			if(conn!=null)
				conn.close();
			if(rs!=null)
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(Connection conn, PreparedStatement pstmt,ResultSet rs) {
		try {
			if(pstmt!=null)
				pstmt.close();
			if(conn!=null)
				conn.close();
			if(rs!=null)
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}