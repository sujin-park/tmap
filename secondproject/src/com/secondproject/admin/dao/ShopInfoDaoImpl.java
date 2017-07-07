package com.secondproject.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.secondproject.admin.model.ExhibitionDto;
import com.secondproject.admin.model.ShopInfoDto;
import com.secondproject.constant.BoardConstant;
import com.secondproject.util.Encoding;
import com.secondproject.util.db.DBClose;
import com.secondproject.util.db.DBConnection;

public class ShopInfoDaoImpl implements ShopInfoDao {
	private static ShopInfoDao shopInfoDao;

	static {
		shopInfoDao = new ShopInfoDaoImpl();
	}

	private ShopInfoDaoImpl() {
	}

	public static ShopInfoDao getShopInfoDao() {
		return shopInfoDao;
	}

	@Override
	public ArrayList<ShopInfoDto> getArticles(Map<String, Object> params) {
		ArrayList<ShopInfoDto> list = new ArrayList<ShopInfoDto>();
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
			sql.append("select s.title, c.category_title, s.tel, s.address, e.shop_id \n");
			sql.append("from shop s, shop_category c, exhibition_detail e \n");
			sql.append("where c.category_id = s.category_id and s.shop_id = e.shop_id \n");

			if (!word.isEmpty() && !key.isEmpty()) {
				sql.append("and " + key + " like '%' || ? || '%' \n");
			}
			if (!orderValue.isEmpty() && !orderKey.isEmpty()) {
				sql.append("order by " + orderKey + " " + orderValue);
			} else {
				sql.append("order by s.category_id desc");
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
				ShopInfoDto shopInfoDto = new ShopInfoDto();
				shopInfoDto.setShopTitle(rs.getString("title"));
				shopInfoDto.setCategoryName(rs.getString("category_title"));
				shopInfoDto.setShopTel(rs.getString("tel"));
				shopInfoDto.setShopAddress(rs.getString("address"));
				shopInfoDto.setShopId(rs.getInt("shop_id"));

				list.add(shopInfoDto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return list;

	}

	public int deleteUsers(String[] users) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		int size = 0;
		try {
			conn = DBConnection.getConnection();
			if (users != null) {
				size = users.length;
			} else {
				size = 0;
			}
			int idx = 0;

			for (int i = 0; i < size; i++) {
				String sql = "";
				sql = "delete shop where title = ? \n";
				pstmt = conn.prepareStatement(sql);
				System.out.println(users[i]);
				pstmt.setString(1, users[i]);
				pstmt.executeUpdate();
				pstmt.close();
				cnt = 1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			cnt = 0;
		} finally {
			DBClose.close(conn, pstmt);
		}

		return cnt;

	}

	@Override
	public ShopInfoDto viewShopInfomation(int shopseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ShopInfoDto shopInfoDto = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select s.title, c.category_title, s.tel, s.address, e.shop_id, \n");
			sql.append("	   s.business_time, s.detail, s.img, s.lat, s.lng \n");
			sql.append("	   from shop s, shop_category c, exhibition_detail e \n");
			sql.append("	   where c.category_id = s.category_id and s.shop_id = e.shop_id \n");
			sql.append("	   and s.shop_id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, shopseq);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				shopInfoDto = new ShopInfoDto();
				shopInfoDto.setShopId(rs.getInt("shop_id"));
				shopInfoDto.setShopTitle(rs.getString("title"));
				shopInfoDto.setCategoryName(rs.getString("category_title"));
				shopInfoDto.setShopTel(rs.getString("tel"));
				shopInfoDto.setShopAddress(rs.getString("address"));
				shopInfoDto.setBusinessTime(rs.getString("business_time"));
				shopInfoDto.setDetail(rs.getString("detail"));
				shopInfoDto.setImg(rs.getString("img"));
				shopInfoDto.setLat(rs.getDouble("lat"));
				shopInfoDto.setLng(rs.getDouble("lng"));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return shopInfoDto;
	}

	@Override
	public int modifyShopInfo(ShopInfoDto shopInfoDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		int size = 0;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update shop set category_id = (select category_id from shop_category where category_title = ?), \n");
			sql.append("title = ?, tel =?, address = ?\n");
			sql.append("where shop_id = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			// category name, shopname, number, address
			pstmt.setString(++idx, Encoding.isoToEuc(shopInfoDto.getCategoryName()));
			pstmt.setString(++idx, Encoding.isoToEuc(shopInfoDto.getShopTitle()));
			pstmt.setString(++idx, Encoding.isoToEuc(shopInfoDto.getTel()));
			pstmt.setString(++idx, Encoding.isoToEuc(shopInfoDto.getAddress()));
			pstmt.setInt(++idx, shopInfoDto.getShopId());
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			cnt = 0;
		} finally {
			DBClose.close(conn, pstmt);
		}

		return cnt;

	}

}
