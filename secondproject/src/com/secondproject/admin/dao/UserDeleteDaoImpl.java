package com.secondproject.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.secondproject.util.db.DBClose;
import com.secondproject.util.db.DBConnection;

public class UserDeleteDaoImpl implements UserDeleteDao {

	private static UserDeleteDao userDeleteDao;
	
	static {
		userDeleteDao = new UserDeleteDaoImpl();
	}
	
	private UserDeleteDaoImpl(){}
	
	public static UserDeleteDao getUserDeleteDao() {
		return userDeleteDao;
	}

	
	@Override
	public int deleteUsers(String[] users) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		int size = 0;
		try {
			conn = DBConnection.getConnection();
			//conn.setAutoCommit(false);
			if (users != null) {
				size = users.length;
			} else {
				size = 0;
			}
		int idx = 0;	
		StringBuffer sql = new StringBuffer();
		for (int i = 0; i < size; i++){	
			System.out.println("for문 들어왔나?");
			sql.append("delete users where user_id = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(++idx, Integer.parseInt(users[i]));
			pstmt.executeUpdate();
			pstmt.close();
			cnt = 1;
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			cnt = 0;
		} finally {
			DBClose.close(conn, pstmt);
		}

	return cnt;
		
	}
}
