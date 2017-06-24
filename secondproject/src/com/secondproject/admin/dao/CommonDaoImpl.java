package com.secondproject.admin.dao;

import java.sql.*;
import java.util.Map;

import com.secondproject.util.db.DBClose;
import com.secondproject.util.db.DBConnection;


public class CommonDaoImpl implements CommonDao {

	private static CommonDao commonDao;

	public static CommonDao getCommonDao() {
		return commonDao;
	}

	private CommonDaoImpl() {
	};

	static {
		commonDao = new CommonDaoImpl();
	}

	@Override
	public int totalArticleCount(Map<String, String> map) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select count(exhibition_id) \n");
			sql.append("			from exhibition \n");
			String key = map.get("key");
			String word = map.get("word");
	         if (!key.isEmpty() && !word.isEmpty()) {
	        	 if (key.equals("title")) {
	        		 sql.append("	   and ex_title like '%' ||?|| '%'\n");
	        	 }
	         }
			pstmt = conn.prepareStatement(sql.toString());
			if (!key.isEmpty() && !word.isEmpty()) {
			pstmt.setString(1, word);
			 }
			rs = pstmt.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return count;
	}
}