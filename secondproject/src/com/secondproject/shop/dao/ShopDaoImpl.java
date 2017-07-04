package com.secondproject.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.secondproject.shop.model.ShopDto;
import com.secondproject.util.db.DBClose;
import com.secondproject.util.db.DBConnection;

public class ShopDaoImpl implements ShopDao {

	private static ShopDao shopDao;
	
	static {
		shopDao = new ShopDaoImpl();
	}
	
	private ShopDaoImpl(){}
	
	public static ShopDao getShopDao() {
		return shopDao;
	}
	
	@Override
	public int addShop(ShopDto shopDto) {
		int isSuccess = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO SHOP (shop_id, category_id, title, lat, lng, owner_id, reserve_url, address, tel, business_time, detail) VALUES \n");
			sql.append("(seq_shop_id.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			pstmt = conn.prepareStatement(sql.toString());
			int i = 0;
			pstmt.setInt(++i, shopDto.getCategoryId());
			pstmt.setString(++i, shopDto.getTitle());
			pstmt.setDouble(++i, shopDto.getLat());
			pstmt.setDouble(++i, shopDto.getLng());
			pstmt.setInt(++i, shopDto.getOwnerId());
			pstmt.setString(++i, shopDto.getReserveUrl());
			pstmt.setString(++i, shopDto.getAddress());
			pstmt.setString(++i, shopDto.getTel());
			pstmt.setString(++i, shopDto.getBusinessTime());
			pstmt.setString(++i, shopDto.getDetail());
			isSuccess = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}

	@Override
	public ShopDto getShop(int shopId) {
		ShopDto shopDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT * \n");
			sql.append("FROM shop s \n");
			sql.append("JOIN shop_category sc on s.category_id = sc.category_id \n");
			sql.append("WHERE shop_id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, shopId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				shopDto = new ShopDto();
				shopDto.setCategoryTitle(rs.getString("category_title"));
				shopDto.setShopId(rs.getInt("shop_id"));
				shopDto.setCategoryId(rs.getInt("category_id"));
				shopDto.setTitle(rs.getString("title"));
				shopDto.setLat(rs.getDouble("lat"));
				shopDto.setLng(rs.getDouble("lng"));
				shopDto.setOwnerId(rs.getInt("owner_id"));
				shopDto.setReserveUrl(rs.getString("reserve_url"));
				shopDto.setAddress(rs.getString("address"));
				shopDto.setTel(rs.getString("tel"));
				shopDto.setBusinessTime(rs.getString("business_time"));
				shopDto.setDetail(rs.getString("detail"));
				shopDto.setImg(rs.getString("img"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return shopDto;
	}

	@Override
	public int getShopScore(int shopId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int score = 0;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select");
			sql.append("	s.*,");
			sql.append("	NVL((SELECT avg(score) FROM review WHERE shop_id = s.shop_id), 0) as score");
			sql.append("	FROM SHOP s");

			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			rs.next();
			score = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return score;
	}
}
