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
			sql.append("SELECT * \n");
			sql.append("FROM shop \n");
			sql.append("WHERE lat > ? and lat < ? and lng > ? and lng < ?");
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
				shopDto.setTitle(rs.getString("title"));
				shopDto.setLat(rs.getDouble("lat"));
				shopDto.setLng(rs.getDouble("lng"));
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


}
