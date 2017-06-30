package com.secondproject.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.secondproject.util.db.DBClose;
import com.secondproject.util.db.DBConnection;

public class ShopInfoDeleteDaoImpl implements ShopInfoDeleteDao {
	private static ShopInfoDeleteDao shopInfoDeleteDao;
	
	static {
		shopInfoDeleteDao = new ShopInfoDeleteDaoImpl();
	}

	private ShopInfoDeleteDaoImpl(){}
	
	public static ShopInfoDeleteDao getShopInfoDeleteDao() {
		return shopInfoDeleteDao;
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
		
		for (int i = 0; i < size; i++){	
			String sql = "";
			System.out.println("for문 들어왔나?");
			sql = "delete shop where title = ? \n";
			pstmt = conn.prepareStatement(sql);
			System.out.println(users[i]);
			pstmt.setString(1, users[i]);
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
