package com.secondproject.admin.dao;

import java.sql.*;
import java.util.*;

import com.secondproject.admin.model.ExhibitionDetailDto;
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

	private AdminReviewDaoImpl() {
	}

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
			sql.append(
					"select r.review_id, s.title shoptitle, u.email, r.title, r.content, r.score, r.reg_date, r.update_date, ri.img, \n");
			sql.append(" r.is_blind \n");
			sql.append(" from review r, shop s, review_img ri, users u \n");
			sql.append("  where r.user_id = u.user_id and \n");
			sql.append(" 	   r.shop_id = s.shop_id and \n");
			sql.append("	   r.review_id = ri.review_id \n");
			if (!key.isEmpty() && !word.isEmpty()) {
				if (key.equals("emailname")) {
					sql.append(" and u.email like '%' ||?|| '%'\n");
				} else {
					sql.append(" and s.title like '%' ||?|| '%' \n");
				}
			}
			if (!column.isEmpty()) {
				if (column.equals("orderby")) {
					columnBasic = "r.reg_date";
				} else if (column.equals("trustby")) {
					columnBasic = "r.score";
				} else {
					columnBasic = "r.is_blind";
				}
				sql.append("order by " + columnBasic + " " + order);
			} else {
				sql.append("order by r.reg_date");
			}
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
			pstmt.setString(++idx, map.get("start"));
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
				adminReviewDto.setIsBlind(rs.getInt("is_blind"));
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
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AdminReviewDto adminReviewDto = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select r.review_id, s.title shoptitle, u.email, r.title, r.content, \n");
			sql.append("   	    r.score, r.reg_date, r.update_date, ri.img, r.is_blind \n");
			sql.append(" from review r, shop s, review_img ri, users u \n");
			sql.append("  where r.user_id = u.user_id and \n");
			sql.append(" 	    r.shop_id = s.shop_id and \n");
			sql.append("	    r.review_id = ri.review_id \n");
			sql.append("		and r.review_id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, seq);
			System.out.println("DB >>>>> " + seq);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				adminReviewDto = new AdminReviewDto();
				adminReviewDto.setReviewId(rs.getInt("review_id"));
				adminReviewDto.setShopTitle(rs.getString("shoptitle"));
				adminReviewDto.setEmail(rs.getString("email"));
				adminReviewDto.setTitle(rs.getString("title"));
				adminReviewDto.setContent(rs.getString("content"));
				adminReviewDto.setScore(rs.getInt("score"));
				adminReviewDto.setRegDate(rs.getString("reg_date"));
				adminReviewDto.setUpdateDate(rs.getString("update_date"));
				adminReviewDto.setImg(rs.getString("img"));
				adminReviewDto.setIsBlind(rs.getInt("is_blind"));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return adminReviewDto;
	}

	@Override
	public int blindExhibition(String[] reviews) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		int size = 0;
		try {
			conn = DBConnection.getConnection();
			if (reviews != null) {
				size = reviews.length;
			} else {
				size = 0;
			}

			for (int i = 0; i < size; i++) {
				String sql = "update review set is_blind = 1 \n";
				sql += "where review_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(reviews[i]));
				cnt = pstmt.executeUpdate();

			}
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			DBClose.close(conn, pstmt);
		}

		return cnt;
	}

}
