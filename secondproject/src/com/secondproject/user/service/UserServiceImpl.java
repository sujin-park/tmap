package com.secondproject.user.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.secondproject.userdto.UserDto;
import com.secondproject.util.db.DBClose;
import com.secondproject.util.db.DBConnection;

public class UserServiceImpl implements UserService {

	private static UserService userService;

	static {
		userService = new UserServiceImpl();
	}

	public static UserService getUserService() {
		return userService;
	}

	@Override
	public UserDto getUser(int userId) {
		UserDto userDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT * FROM users WHERE user_id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				userDto = new UserDto();
				userDto.setUser_id(rs.getInt("user_id"));
				userDto.setEmail(rs.getString("email"));
				userDto.setType(rs.getInt("type"));
				userDto.setGender(rs.getInt("gender"));
				userDto.setAge(rs.getInt("age"));
				userDto.setStatus_msg(rs.getString("status_msg"));
				userDto.setReg_date(rs.getString("reg_date"));
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
