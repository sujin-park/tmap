package com.secondproject.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.secondproject.constant.BoardConstant;
import com.secondproject.userdto.UserDto;
import com.secondproject.util.Encoding;
import com.secondproject.util.db.DBClose;
import com.secondproject.util.db.DBConnection;

public class UserViewDaoImpl implements UserViewDao {

	private static UserViewDao userViewDao;

	static {
		userViewDao = new UserViewDaoImpl();
	}

	private UserViewDaoImpl() {
	}

	public static UserViewDao getUserViewDao() {
		return userViewDao;
	}

	@Override
	public ArrayList<UserDto> getArticles(Map<String, Object> params) {
		ArrayList<UserDto> list = new ArrayList<UserDto>();

		String key = (String) params.get("key");
		String word = Encoding.isoToEuc((String) params.get("word"));
		String orderKey = (String) params.get("orderKey");
		String orderValue = (String) params.get("orderValue");
		int pageEnd = (int) params.get("pg") * BoardConstant.LIST_SIZE;
		int pageStart = pageEnd - BoardConstant.LIST_SIZE;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select b.* \n");
			sql.append("from ( \n");
			sql.append("   select rownum rn, a.* \n");
			sql.append("   from ( \n");
			sql.append("select * from users \n");
			sql.append("where type != 0 \n");
			if (!word.isEmpty() && !key.isEmpty()) {
				if (key.equals("type")) {
					sql.append("and type = ? \n");
				} else {
				sql.append("and " + key + " like '%' || ? || '%' \n");
				}
			}
			if (!orderValue.isEmpty() && !orderKey.isEmpty()) {
				sql.append("order by " + orderKey + " " + orderValue);
			} else {
				sql.append("order by reg_date desc");
			}
			sql.append("         ) a \n");
			sql.append("      where rownum <=? \n");
			sql.append("      ) b \n");
			sql.append("   where b.rn>?");
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			if (!word.isEmpty() && !key.isEmpty()) {
				pstmt.setString(++idx, word);
			}
			pstmt.setInt(++idx, pageEnd);
			pstmt.setInt(++idx, pageStart);
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
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return list;

	}
}
