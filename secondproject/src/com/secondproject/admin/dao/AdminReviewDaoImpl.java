package com.secondproject.admin.dao;

import java.sql.*;
import java.util.*;

import com.secondproject.review.model.AdminReviewDto;
import com.secondproject.util.db.DBClose;
import com.secondproject.util.db.DBConnection;

public class AdminReviewDaoImpl implements AdminReviewDao {

	private static AdminReviewDao adminReviewDao;
	
	public static AdminReviewDao getAdminReviewDao() {
		return adminReviewDao;
	}

	static {
		adminReviewDao = new AdminReviewDaoImpl();
	}
	
	private AdminReviewDaoImpl(){}
	
	@Override
	public List<AdminReviewDto> listReview(Map<String, String> map) {
		List<AdminReviewDto> list = new ArrayList<AdminReviewDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			String key = map.get("key");
			String word = map.get("word");
			String order = map.get("order");
			String column = map.get("column");
			String columnBasic = "r.reg_date";

			sql.append("select b.* \n");
			sql.append("from ( \n");
			sql.append("   select rownum rn, a.* \n");
			sql.append("   from ( \n");
			sql.append("select r.review_id, s.title shoptitle, u.email, r.title, r.content, r.score, r.reg_date, r.update_date, ri.img \n");
			sql.append(" from review r, shop s, review_img ri, users u \n");
			sql.append("  where r.user_id = u.user_id and \n");
			sql.append(" 	   r.shop_id = s.shop_id and \n");
			sql.append("	   r.review_id = ri.review_id \n");
//			if (!key.isEmpty() && !word.isEmpty()) {
//				if (key.equals("title")) {
//					sql.append("	  where r.title like '%' ||?|| '%'\n");
//				}
//			}
//			if (!column.isEmpty()) {
//				if (column.equals("orderby")) {
//					columnBasic = "r.reg_date";
//				} else if (column.equals("nameby")) {
//					columnBasic = "ex_title";
//				} else {
//					columnBasic = "ex_visiable";
//				}
//				sql.append("order by " + columnBasic + " " + order);
//			} else {
//				sql.append("order by ex_order");
//			}
			sql.append("         ) a \n");
			sql.append("      where rownum <=? \n");
			sql.append("      ) b \n");
			sql.append("   where b.rn>?");
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			if (!key.isEmpty() && !word.isEmpty()) {
				pstmt.setString(++idx, map.get("word"));
			}
			pstmt.setString(++idx, map.get("end"));
			pstmt.setString(++idx,map.get("start"));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AdminReviewDto adminReviewDto = new AdminReviewDto();
				adminReviewDto.setReviewId(rs.getInt("review_id"));
				adminReviewDto.setShopTitle(rs.getString("shoptitle"));
				adminReviewDto.setEmail(rs.getString("email"));
				adminReviewDto.setTitle(rs.getString("title"));
				adminReviewDto.setContent(rs.getString("content"));
				adminReviewDto.setScore(rs.getInt("score"));
				adminReviewDto.setRegDate(rs.getString("reg_date"));
				adminReviewDto.setUpdateDate(rs.getString("update_date"));
				adminReviewDto.setImg(rs.getString("img"));
				
				list.add(adminReviewDto);
				}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return list;
	}

	@Override
	public AdminReviewDto viewReview(int seq) {
		return null;
	}

	@Override
	public int blindExhibition(String[] reviews) {
		return 0;
	}

}
