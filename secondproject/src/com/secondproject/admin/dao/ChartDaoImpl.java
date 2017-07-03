package com.secondproject.admin.dao;

import java.sql.*;
import java.util.*;

import com.secondproject.map.model.ShopDto;
import com.secondproject.util.Encoding;
import com.secondproject.util.db.DBClose;
import com.secondproject.util.db.DBConnection;

public class ChartDaoImpl implements ChartDao {

	private static ChartDao chartDao;

	public static ChartDao getChartDao() {
		return chartDao;
	}

	static {
		chartDao = new ChartDaoImpl();
	}

	private ChartDaoImpl() {
	}

	@Override
	public List<Map<String, String>> ageChart() {
		List<Map<String, String>> ageList = new ArrayList<Map<String, String>>();
		Map<String, String> age = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select substr(age,0,1) || 0 as age,");
			sql.append("	count(age) as ageCount from users");
			sql.append("    group by substr(age,0,1)");
			sql.append("    order by 1 asc");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				age = new HashMap<String, String>();
				age.put("age", rs.getString("age")); // 10대, 20대
				age.put("ageCount", rs.getString("ageCount")); // 카운트

				ageList.add(age);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return ageList;
	}

	@Override
	public List<Map<String, String>> categoryChart(String number) {
		List<Map<String, String>> categoryList = new ArrayList<Map<String, String>>();
		Map<String, String> category = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = Integer.parseInt(number);
		try {

			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select count(r.review_id) as categoryCount, sc.category_title \n");
			sql.append("   from review r, shop s, shop_category sc, users u \n");
			sql.append("   where r.shop_id = s.shop_id \n");
			sql.append("   		 and s.category_id = sc.category_id \n");
			sql.append("   		 and u.user_id = r.user_id \n");
			if (num != 0) {
				if (num == 1) {
					sql.append("   		 and u.gender = 1"); // 남자
				} else {
					sql.append("   		 and u.gender = 2"); // 여자
				}
			}
			sql.append("   		 group by sc.category_title \n");

			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				category = new HashMap<String, String>();
				category.put("category", rs.getString("category_title")); // 카테고리
																			// 이름
				category.put("categoryCount", rs.getString("categoryCount")); // 카운트

				categoryList.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return categoryList;
	}

	@Override
	public List<Map<String, String>> areaChart() {
		List<Map<String, String>> areaList = new ArrayList<Map<String, String>>();
		Map<String, String> area = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append(" select count(shop_id) as count,  \n");
			sql.append(" 	    substr(address, 0, instr(address,' ')) as addressgroup \n");
			sql.append(" 		from shop \n");
			sql.append(" 		group by substr(address, 0, instr(address,' ')) \n");

			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				area = new HashMap<String, String>();
				area.put("area", rs.getString("addressgroup")); // 카테고리 이름
				area.put("areaCount", rs.getString("count")); // 카운트

				areaList.add(area);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return areaList;
	}

}
