package com.secondproject.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.secondproject.userdto.UserDto;
import com.secondproject.util.db.DBClose;
import com.secondproject.util.db.DBConnection;


public class UserViewDaoImpl implements UserViewDao {

	private static UserViewDao userViewDao;
	
	static {
		userViewDao = new UserViewDaoImpl();
	}
	
	private UserViewDaoImpl(){}
	
	public static UserViewDao getUserViewDao() {
		return userViewDao;
	}
	
	
	@Override
	public ArrayList<UserDto> getArticles(String keyword, String type, String userOrder, String column) {
		// TODO Auto-generated method stub
		ArrayList<UserDto> list = new ArrayList<UserDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select * from users \n");
			sql.append("where type != '0' \n");

			if (keyword != null && type != null) {
				sql.append("and "+ type +" like '%' || ? || '%' \n");
			}
			
			if (userOrder != null && column != null) {
				sql.append("order by " + column + " " + userOrder);
			} else {
				sql.append("order by reg_date desc");
			}
			pstmt = conn.prepareStatement(sql.toString());
			if (keyword != null && type != null){
				pstmt.setString(1, keyword);
			}
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) { // 있으면 true 없으면 false return
				UserDto userDto = new UserDto();
				userDto.setUser_id(rs.getInt("user_id"));
				userDto.setEmail(rs.getString("email"));
				userDto.setPassword(rs.getString("password"));
				userDto.setType(rs.getInt("type"));
				userDto.setGender(rs.getInt("gender"));
				userDto.setAge(rs.getInt("age"));
				userDto.setStatus_msg(rs.getString("status_msg"));
				userDto.setReg_date(rs.getString("reg_date"));
				userDto.setReg_ip(rs.getString("reg_ip"));
				userDto.setUpdate_date(rs.getString("update_date"));
				list.add(userDto);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

	return list;
		
	}
}
