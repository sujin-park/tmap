package com.secondproject.joinlogin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			sql.append("insert into users \n");
			sql.append("(user_id, email, password, type, gender, age, status_msg, reg_date, reg_ip, update_date) \n");
			sql.append("values (SEQ_USERS_ID.nextval, ?, ?, 1, ?, ?, '어서옵쇼', sysdate, 'localhost', sysdate)");
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

	@Override
	public int idCheck(String sid) {
		int count = 0; //count가 0이면 해당 id를 사용할수 있습니다.
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select count(email) \n";
			sql += "from users \n";
			sql += "where email = ?"; 
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery(); 
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			count= 1; //위에 0이라 설정해노면 이렇게 해야함
		}finally{
			DBClose.close(conn, pstmt, rs);
		}
		return count;
	}

}
