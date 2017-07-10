package com.secondproject.map.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.secondproject.map.model.FollowCategoryDto;
import com.secondproject.map.model.FollowCategoryUserDto;
import com.secondproject.map.model.ShopDto;
import com.secondproject.shop.model.ShopCategoryDto;
import com.secondproject.util.db.DBClose;
import com.secondproject.util.db.DBConnection;
import com.secondproject.util.map.Bounds;

public class MapDaoImpl implements MapDao {

	private static MapDao mapDao;

	static {
		mapDao = new MapDaoImpl();
	}

	private MapDaoImpl() {
	}

	public static MapDao getMapDao() {
		return mapDao;
	}

	@Override
	public ArrayList<ShopDto> getShopList(Bounds bounds, int categoryId, List<Integer> followUsers) {
		ArrayList<ShopDto> list = new ArrayList<ShopDto>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT \n");
			sql.append("    * \n");
			sql.append("FROM \n");
			sql.append("( \n");
			sql.append("    SELECT \n");
			sql.append("        s.shop_id, category_id, \n");
			sql.append(
					"        (SELECT category_title from shop_category WHERE category_id = s.category_id) category_title, \n");
			sql.append(
					"        title, lat, lng, img, address, NVL(review_count, 0) review_count, NVL(score, 0) score, \n");
			sql.append(
					"        (55 + (NVL(score, 0) * NVL(review_count, 0))) / (10 + NVL(review_count, 0)) as algorythm, \n");
			sql.append("        NVL(follow_review_count, 0) follow_review_count \n");
			sql.append("    FROM \n");
			sql.append("        ( \n");
			sql.append("            SELECT \n");
			sql.append("                shop_id, category_id, title, lat, lng, img, address \n");
			sql.append("            FROM shop \n");
			sql.append("            WHERE ");

			if (categoryId != 0) {
				sql.append("            category_id = ? AND \n");
			}

			sql.append("            lat > ? AND lat < ? AND lng > ? AND lng < ? \n");
			sql.append("        ) s \n");
			sql.append("        LEFT JOIN \n");
			sql.append("        ( \n");
			sql.append("            SELECT shop_id, COUNT(shop_id) review_count, ROUND(NVL(AVG(score), 0), 2) score \n");
			sql.append("            FROM review \n");
			sql.append("            GROUP BY shop_id \n");
			sql.append("        ) r ON s.shop_id = r.shop_id \n");
			sql.append("        LEFT JOIN \n");
			sql.append("        ( \n");
			sql.append("            SELECT \n");
			sql.append("                shop_id, COUNT(review_id) follow_review_count \n");
			sql.append("            FROM review \n");
			if (followUsers.size() > 0) {
				sql.append("            WHERE user_id in (");
				StringBuffer followUsersString = new StringBuffer();
				for (int i = 0; i < followUsers.size(); i++) {
					followUsersString.append(",?");
				}
				String appendSql = followUsersString.toString();
				appendSql = appendSql.substring(1);
				sql.append(appendSql);
				sql.append(") \n");
			} else {
				sql.append("            WHERE user_id in (?) \n");
			}
			
			sql.append("            GROUP BY shop_id \n");
			sql.append("        ) rs ON s.shop_id = rs.shop_id \n");
			sql.append("    ORDER BY algorythm DESC \n");
			sql.append(") \n");
			sql.append("WHERE rownum <= ? \n");
			
			//System.out.println(sql.toString());
			pstmt = conn.prepareStatement(sql.toString());

			int pstmtIndex = 1;
			if (categoryId != 0) {
				pstmt.setInt(pstmtIndex++, categoryId);
			}
			pstmt.setDouble(pstmtIndex++, bounds._min._lat);
			pstmt.setDouble(pstmtIndex++, bounds._max._lat);
			pstmt.setDouble(pstmtIndex++, bounds._min._lng);
			pstmt.setDouble(pstmtIndex++, bounds._max._lng);
			
			if (followUsers.size() > 0) {
				for (int i = 0; i < followUsers.size(); i++) {
					pstmt.setInt(pstmtIndex++, followUsers.get(i));
				}
			} else {
				pstmt.setString(pstmtIndex++, "0");
			}
			
			pstmt.setInt(pstmtIndex++, 30);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ShopDto shopDto = new ShopDto();
				shopDto.setShopId(rs.getInt("shop_id"));
				shopDto.setCategoryId(rs.getInt("category_id"));
				shopDto.setCategoryName(rs.getString("category_title"));
				shopDto.setTitle(rs.getString("title"));
				shopDto.setLat(rs.getDouble("lat"));
				shopDto.setLng(rs.getDouble("lng"));
				shopDto.setAddress(rs.getString("address"));
				shopDto.setScore(rs.getDouble("score"));
				shopDto.setReviewCount(rs.getInt("review_count"));
				shopDto.setFollowReviewCount(rs.getInt("follow_review_count"));
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
	public ArrayList<ShopDto> getShopListByFollowUsers(Bounds bounds, int categoryId, List<Integer> followUsers) {
		ArrayList<ShopDto> list = new ArrayList<ShopDto>();
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT \n");
			sql.append("    * \n");
			sql.append("FROM \n");
			sql.append("( \n");
			sql.append("    SELECT \n");
			sql.append("        s.shop_id, category_id, \n");
			sql.append("        (SELECT category_title from shop_category WHERE category_id = s.category_id) category_title, \n");
			sql.append("        title, lat, lng, img, address, NVL(review_count, 0) review_count, NVL(score, 0) score, \n");
			sql.append("        (55 + (NVL(score, 0) * NVL(review_count, 0))) / (10 + NVL(review_count, 0)) as algorythm, \n");
			sql.append("        NVL(follow_review_count, 0) follow_review_count \n");
			sql.append("    FROM \n");
			sql.append("        ( \n");
			sql.append("            SELECT \n");
			sql.append("                shop_id, category_id, title, lat, lng, img, address \n");
			sql.append("            FROM shop \n");
			sql.append("            WHERE ");

			if (categoryId != 0) {
				sql.append("            category_id = ? AND \n");
			}

			sql.append("            lat > ? AND lat < ? AND lng > ? AND lng < ? \n");
			sql.append("        ) s \n");
			sql.append("        JOIN \n");
			sql.append("        ( \n");
			sql.append("            SELECT \n");
			sql.append("                shop_id, COUNT(review_id) follow_review_count \n");
			sql.append("            FROM review \n");
			
			if (followUsers.size() > 0) {
				sql.append("            WHERE user_id in (");
				StringBuffer followUsersString = new StringBuffer();
				for (int i = 0; i < followUsers.size(); i++) {
					followUsersString.append(",?");
				}
				String appendSql = followUsersString.toString();
				appendSql = appendSql.substring(1);
				sql.append(appendSql);
				sql.append(") \n");
			} else {
				sql.append("            WHERE user_id in (?) \n");
			}
			
			sql.append("            GROUP BY shop_id \n");
			sql.append("        ) rs ON s.shop_id = rs.shop_id \n");
			sql.append("        LEFT JOIN \n");
			sql.append("        ( \n");
			sql.append("            SELECT shop_id, COUNT(shop_id) review_count, ROUND(NVL(AVG(score), 0), 2) score \n");
			sql.append("            FROM review \n");
			sql.append("            GROUP BY shop_id \n");
			sql.append("        ) r ON s.shop_id = r.shop_id \n");
			sql.append("    ORDER BY algorythm DESC \n");
			sql.append(") \n");
			sql.append("WHERE rownum <= ? \n");
			pstmt = conn.prepareStatement(sql.toString());
	
			int pstmtIndex = 1;
			if (categoryId != 0) {
				pstmt.setInt(pstmtIndex++, categoryId);
			}
			pstmt.setDouble(pstmtIndex++, bounds._min._lat);
			pstmt.setDouble(pstmtIndex++, bounds._max._lat);
			pstmt.setDouble(pstmtIndex++, bounds._min._lng);
			pstmt.setDouble(pstmtIndex++, bounds._max._lng);
			
			if (followUsers.size() > 0) {
				for (int i = 0; i < followUsers.size(); i++) {
					pstmt.setInt(pstmtIndex++, followUsers.get(i));
				}
			} else {
				pstmt.setString(pstmtIndex++, "0");
			}
			
			pstmt.setInt(pstmtIndex++, 30);
	
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ShopDto shopDto = new ShopDto();
				shopDto.setShopId(rs.getInt("shop_id"));
				shopDto.setCategoryId(rs.getInt("category_id"));
				shopDto.setCategoryName(rs.getString("category_title"));
				shopDto.setTitle(rs.getString("title"));
				shopDto.setLat(rs.getDouble("lat"));
				shopDto.setLng(rs.getDouble("lng"));
				shopDto.setAddress(rs.getString("address"));
				shopDto.setScore(rs.getDouble("score"));
				shopDto.setReviewCount(rs.getInt("review_count"));
				shopDto.setFollowReviewCount(rs.getInt("follow_review_count"));
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
	public ArrayList<FollowCategoryUserDto> getFollowUsers(Bounds bounds, int followCategoryId, int categoryId) {
		ArrayList<FollowCategoryUserDto> list = new ArrayList<FollowCategoryUserDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT fu.*, u.email, \n");
			sql.append("    ( \n");
			sql.append("        SELECT COUNT(review_id) \n");
			sql.append("        FROM review \n");
			sql.append("        WHERE user_id = fu.reg_user_id AND shop_id in ( \n");
			sql.append("            SELECT shop_id \n");
			sql.append("            FROM shop \n");
			sql.append("            WHERE ");
			if (categoryId != 0) {
				sql.append("                category_id = ? AND ");
			}
			sql.append("lat > ? AND lat < ? AND lng > ? AND lng < ? \n");
			sql.append("        ) \n");
			sql.append("    ) review_count \n");
			sql.append("FROM follow_user fu \n");
			sql.append("JOIN users u ON u.user_id = fu.reg_user_id \n");
			sql.append("WHERE follow_category_id = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			
			int pstmtIndex = 1;
			if (categoryId != 0) {
				pstmt.setDouble(pstmtIndex++, categoryId);
			}
			pstmt.setDouble(pstmtIndex++, bounds._min._lat);
			pstmt.setDouble(pstmtIndex++, bounds._max._lat);
			pstmt.setDouble(pstmtIndex++, bounds._min._lng);
			pstmt.setDouble(pstmtIndex++, bounds._max._lng);
			pstmt.setInt(pstmtIndex++, followCategoryId);
			// System.out.println(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				FollowCategoryUserDto followCategoryUserDto = new FollowCategoryUserDto();
				followCategoryUserDto.setFollowUserId(rs.getInt("follow_user_id"));
				followCategoryUserDto.setUserId(rs.getInt("user_id"));
				followCategoryUserDto.setUserEmail(rs.getString("email"));
				followCategoryUserDto.setFollowCategoryId(rs.getInt("follow_category_id"));
				followCategoryUserDto.setRegUserId(rs.getInt("reg_user_id"));
				followCategoryUserDto.setAlias(rs.getString("alias"));
				followCategoryUserDto.setMemo(rs.getString("memo"));
				followCategoryUserDto.setRegDate(rs.getString("reg_date"));
				followCategoryUserDto.setMapReviewCount(rs.getInt("review_count"));
				list.add(followCategoryUserDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return list;
	}

/*	@Override
	public ArrayList<FollowCategoryDto> getFollowListByUser(int userId) {
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
				followCategoryDto.setCategoryUserList(getFollowUsers(null, rs.getInt("follow_category_id"), null));
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
	}*/

	@Override
	public ArrayList<Integer> getAllFolloewUserId(int userId) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT reg_user_id \n");
			sql.append("FROM follow_user \n");
			sql.append("WHERE user_id = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, userId);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(rs.getInt("reg_user_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public ArrayList<ShopCategoryDto> getShopCategory() {
		ArrayList<ShopCategoryDto> list = new ArrayList<ShopCategoryDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT category_id, category_title \n");
			sql.append("FROM shop_category \n");
			sql.append("ORDER BY category_order ASC ");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ShopCategoryDto shopCategoryDto = new ShopCategoryDto();
				shopCategoryDto.setCategoryId(rs.getInt("category_id"));
				shopCategoryDto.setCategoryTitle(rs.getString("category_title"));
				list.add(shopCategoryDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public ArrayList<FollowCategoryDto> getFollowList(Bounds bounds, int userId, int categoryId) {
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
				followCategoryDto.setCategoryUserList(getFollowUsers(bounds, rs.getInt("follow_category_id"), categoryId));
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

}
