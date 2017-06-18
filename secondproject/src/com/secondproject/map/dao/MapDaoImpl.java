package com.secondproject.map.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.secondproject.map.model.ShopDto;
import com.secondproject.util.db.DBClose;
import com.secondproject.util.db.DBConnection;

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
	public ArrayList<ShopDto> getShopList() {
		ArrayList<ShopDto> list = new ArrayList<ShopDto>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "SELECT * FROM shop";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ShopDto shopDto = new ShopDto();
				shopDto.setShopId(rs.getInt("shop_id"));
				shopDto.setCategoryId(rs.getInt("category_id"));
				shopDto.setTitle(rs.getString("title"));
				shopDto.setLat(rs.getInt("lat"));
				shopDto.setLng(rs.getInt("lng"));
				shopDto.setScore(rs.getLong("score"));
				shopDto.setOwnerId(rs.getInt("owner_id"));
				shopDto.setReserveUrl(rs.getString("reserve_url"));
				shopDto.setAddress(rs.getString("address"));
				shopDto.setTel(rs.getString("tel"));
				shopDto.setBusinessTime(rs.getString("business_time"));
				shopDto.setDetail(rs.getString("detail"));
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
	public ArrayList<HashMap<String, Object>> getShopHashMapList() {
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "SELECT * FROM shop";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getDouble("lat"));
				HashMap<String, Object> shop = new HashMap<String, Object>();
				shop.put("shopId", rs.getInt("shop_id"));
				shop.put("categoryId", rs.getInt("category_id"));
				shop.put("title", rs.getString("title"));
				shop.put("lat", rs.getDouble("lat"));
				shop.put("lng", rs.getDouble("lng"));
				shop.put("score", rs.getDouble("score"));
				shop.put("owner_id", rs.getInt("owner_id"));
				shop.put("reserve_url", rs.getString("reserve_url"));
				shop.put("address", rs.getString("address"));
				shop.put("tel", rs.getString("tel"));
				shop.put("business_time", rs.getString("business_time"));
				shop.put("detail", rs.getString("detail"));
				list.add(shop);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return list;
	}


}
