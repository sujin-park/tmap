package com.secondproject.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.secondproject.shop.model.ShopDto;
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
			sql.append("(113, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
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

}
