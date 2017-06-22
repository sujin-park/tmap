package com.secondproject.joinlogin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.secondproject.userdto.UserDto;
import com.secondproject.util.db.DBClose;
import com.secondproject.util.db.DBConnection;

public class JoinDaoImpl implements JoinDao {

	private static JoinDao joinDao;
	
	static{
		joinDao = new JoinDaoImpl();
	}
	
	private JoinDaoImpl() {}

	public static JoinDao getJoinDao() {
		return joinDao;
	}

	@Override
	public int join(UserDto userDto) {
		int cnt = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into garauser \n");
			sql.append("(user_id, email, password, type, gender, age, status_msg, reg_date, reg_ip) \n");
			sql.append("values (1, ?, ?, 1, ?, ?, '¾î¼­¿É¼î', sysdate, 'localhost')");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userDto.getEmail());
			pstmt.setString(2, userDto.getPassword());
			pstmt.setInt(3, userDto.getGender());
			pstmt.setInt(4, userDto.getAge());
//			pstmt.setString(5, userDto.getReg_ip());
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}

}
