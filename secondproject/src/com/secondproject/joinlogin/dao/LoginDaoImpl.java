package com.secondproject.joinlogin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.secondproject.userdto.UserDto;
import com.secondproject.util.db.DBClose;
import com.secondproject.util.db.DBConnection;

public class LoginDaoImpl implements LoginDao {
	
	private static LoginDao loginDao;
	
	static {
		loginDao = new LoginDaoImpl();
	}
	
	private LoginDaoImpl() {}
	
	public static LoginDao getLoginDao() {
		return loginDao;
	}

	@Override
	public UserDto login(Map<String, String> map) {
		UserDto userDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;	
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select user_id, email, type, gender, age, status_msg, reg_ip, update_date \n");
			sql.append("from user \n");
			sql.append("where email = ? and password = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, map.get("useremail"));
			pstmt.setString(2, map.get("userpw"));
			rs = pstmt.executeQuery();
			if(rs.next()){
				userDto = new UserDto();
				userDto.setUser_id(rs.getInt("user_id"));
				userDto.setEmail(rs.getString("email"));
				userDto.setType(rs.getInt("type"));
				userDto.setGender(rs.getInt("gender"));
				userDto.setAge(rs.getInt("age"));
				userDto.setStatus_msg(rs.getString("status_msg"));
				userDto.setReg_ip(rs.getString("reg_ip"));
				userDto.setUpdate_date(rs.getString("update_date"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return userDto;
	}

}
