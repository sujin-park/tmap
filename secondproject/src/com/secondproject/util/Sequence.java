package com.secondproject.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.secondproject.util.db.DBClose;
import com.secondproject.util.db.DBConnection;

public class Sequence {
	
	public static int getSequenceNextVal(String sequenceName) {
		int sequence = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT ");
			sql.append(sequenceName + ".nextval as sequence FROM DUAL");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				sequence = rs.getInt("sequence");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		return sequence;
	}
	
	public static int getSequenceCurrentVal(String sequenceName) {
		int sequence = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT ");
			sql.append(sequenceName + ".currval as sequence FROM DUAL");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				sequence = rs.getInt("sequence");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		return sequence;
	}
}
