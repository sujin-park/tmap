package com.secondproject.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.secondproject.admin.model.ShopInfoDto;
import com.secondproject.util.db.DBClose;
import com.secondproject.util.db.DBConnection;

public class ShopInfoDaoImpl implements ShopInfoDao {
	private static ShopInfoDao shopInfoDao;
	
	static {
		shopInfoDao = new ShopInfoDaoImpl();
	}
	
	private ShopInfoDaoImpl(){}
	
	public static ShopInfoDao getShopInfoDao() {
		return shopInfoDao;
	}
	
	@Override
	public ArrayList<ShopInfoDto> getArticles(String keyword, String type, String userOrder, String column) {
		// TODO Auto-generated method stub
		ArrayList<ShopInfoDto> list = new ArrayList<ShopInfoDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select s.title,c.category_title,s.tel,s.address,e.shop_id \n");
			sql.append("from shop s, shop_category c, exhibition_detail e \n");
			sql.append("where c.category_id = s.category_id and s.shop_id = e.shop_id \n");

			if (keyword != null && type != null) {
				sql.append("and "+ type +" like '%' || ? || '%' \n");
			}
			
			if (userOrder != null && column != null) {
				sql.append("order by " + column + " " + userOrder);
			} else {
				sql.append("order by s.category_id desc");
			}

			pstmt = conn.prepareStatement(sql.toString());
			if (keyword != null && type != null){
				pstmt.setString(1, keyword);
			}
			rs = pstmt.executeQuery();
			
			while (rs.next()) { // 있으면 true 없으면 false return
				ShopInfoDto shopInfoDto = new ShopInfoDto();
				shopInfoDto.setShopTitle(rs.getString("title"));
				shopInfoDto.setCategoryName(rs.getString("category_title"));
				shopInfoDto.setShopTel(rs.getString("tel"));
				shopInfoDto.setShopAddress(rs.getString("address"));
				shopInfoDto.setExhibitionId(rs.getInt("shop_id"));
				
				list.add(shopInfoDto);
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
