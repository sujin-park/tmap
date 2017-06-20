package com.secondproject.util.db;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnection {
	public static Connection getConnection() {
		 Connection conn = null;
		 try {
			Context ctx = new InitialContext();
			Context ictx = (Context) ctx.lookup("java:comp/env");
			DataSource ds = (DataSource) ictx.lookup("jdbc/map"); 

			conn=ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
