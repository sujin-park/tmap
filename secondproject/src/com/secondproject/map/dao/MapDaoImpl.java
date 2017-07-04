package com.secondproject.map.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.secondproject.map.model.FollowCategoryDto;
import com.secondproject.map.model.FollowCategoryUserDto;
import com.secondproject.map.model.ShopDto;
import com.secondproject.util.db.DBClose;
import com.secondproject.util.db.DBConnection;
import com.secondproject.util.map.Bounds;

public class MapDaoImpl implements MapDao {

	private static MapDao mapDao;

	static {
		mapDao = new MapDaoImpl();
	}

	private MapDaoImpl() {}

	public static MapDao getMapDao() {
		return mapDao;
	}

	@Override
	public ArrayList<ShopDto> getShopList(Bounds bounds) {
		ArrayList<ShopDto> list = new ArrayList<ShopDto>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT s.*, (SELECT AVG(score) FROM review WHERE shop_id = s.shop_id) as score, (SELECT category_title FROM shop_category WHERE category_id = s.category_id) as category_name \n");
			sql.append("FROM shop s \n");
			sql.append("WHERE lat > ? and lat < ? and lng > ? and lng < ? ");
			sql.append("ORDER BY score ASC");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setDouble(1, bounds._min._lat);
			pstmt.setDouble(2, bounds._max._lat);
			pstmt.setDouble(3, bounds._min._lng);
			pstmt.setDouble(4, bounds._max._lng);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ShopDto shopDto = new ShopDto();
				shopDto.setShopId(rs.getInt("shop_id"));
				shopDto.setCategoryId(rs.getInt("category_id"));
				shopDto.setCategoryName(rs.getString("category_name"));
				shopDto.setTitle(rs.getString("title"));
				shopDto.setLat(rs.getDouble("lat"));
				shopDto.setLng(rs.getDouble("lng"));
				shopDto.setOwnerId(rs.getInt("owner_id"));
				shopDto.setReserveUrl(rs.getString("reserve_url"));
				shopDto.setAddress(rs.getString("address"));
				shopDto.setTel(rs.getString("tel"));
				shopDto.setBusinessTime(rs.getString("business_time"));
				shopDto.setDetail(rs.getString("detail"));
				shopDto.setScore(Math.round(rs.getDouble("score")*100d) / 100d);
				list.add(shopDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return list;
	}

	@Override
	public ArrayList<FollowCategoryDto> getCategoryByUser(int userId) {
		ArrayList<FollowCategoryDto> list = new ArrayList<FollowCategoryDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT * \n");
			sql.append("FROM follow_category \n");
			sql.append("WHERE user_id = ? ");
			sql.append("ORDER BY category_order ASC");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				FollowCategoryDto followCategoryDto = new FollowCategoryDto();
				followCategoryDto.setFollowCategoryId(rs.getInt("follow_category_id"));
				followCategoryDto.setUserId(rs.getInt("user_id"));
				followCategoryDto.setCategoryName(rs.getString("category_name"));
				followCategoryDto.setCategoryOrder(rs.getInt("category_order"));
				list.add(followCategoryDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		return list;
	}

	@Override
	public FollowCategoryUserDto getCategoryUser(int categoryId) {
		FollowCategoryUserDto followCategoryUserDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT * \n");
			sql.append("FROM follow_user fu \n");
			sql.append("JOIN users ON user_id = fu.reg_user_id \n");
			sql.append("WHERE follow_category_id = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, categoryId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				followCategoryUserDto = new FollowCategoryUserDto();
				followCategoryUserDto.setFollowUserId(rs.getInt("follow_user_id"));
				followCategoryUserDto.setUserId(rs.getInt("user_id"));
				followCategoryUserDto.setUserEmail(rs.getString("email"));
				followCategoryUserDto.setFollowCategoryId(rs.getInt("follow_category_id"));
				followCategoryUserDto.setRegUserId(rs.getInt(rs.getInt("reg_user_id")));
				followCategoryUserDto.setAlias(rs.getString("alias"));
				followCategoryUserDto.setMemo(rs.getString("memo"));
				followCategoryUserDto.setRegDate(rs.getString("reg_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		return followCategoryUserDto;
	}


}
