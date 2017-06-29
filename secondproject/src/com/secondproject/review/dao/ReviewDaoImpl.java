package com.secondproject.review.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.secondproject.map.model.ShopDto;
import com.secondproject.review.model.ReviewDto;
import com.secondproject.util.PagenationParameter;
import com.secondproject.util.db.DBClose;
import com.secondproject.util.db.DBConnection;

public class ReviewDaoImpl implements ReviewDao {

	private static ReviewDao reviewDao;

	static {
		reviewDao = new ReviewDaoImpl();
	}

	private ReviewDaoImpl() {
	}

	public static ReviewDao getReviewDao() {
		return reviewDao;
	}

	@Override
	public int addReview(ReviewDto reviewDto) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO review \n");
			sql.append("(review_id, shop_id, user_id, title, content, score, img, is_blind, reg_date, update_date) \n");
			sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, sysdate, sysdate)");
			pstmt = conn.prepareStatement(sql.toString());
			int i = 0;
			pstmt.setInt(++i, reviewDto.getReviewId());
			pstmt.setInt(++i, reviewDto.getShopId());
			pstmt.setInt(++i, reviewDto.getUserId());
			pstmt.setString(++i, reviewDto.getTitle());
			pstmt.setString(++i, reviewDto.getContent());
			pstmt.setDouble(++i, reviewDto.getScore());
			pstmt.setString(++i, reviewDto.getImg());
			pstmt.setInt(++i, 0);
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}

		return count;
	}

	@Override
	public List<ReviewDto> getReviewList(PagenationParameter pagenationParameter) {
		ArrayList<ReviewDto> list = new ArrayList<ReviewDto>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT * \n");
			sql.append("FROM review \n");
			sql.append("WHERE shop_id = ? and is_blind = 0");
			// TODO SELECT 孽府 其捞隆贸府
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, 1);
			// TODO UserID 技记俊辑 罐酒客辑 持绰芭 贸府秦具窃
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReviewDto reviewDto = new ReviewDto();
				reviewDto.setReviewId(rs.getInt("review_id"));
				reviewDto.setShopId(rs.getInt("shop_id"));
				reviewDto.setUserId(rs.getInt("user_id"));
				reviewDto.setTitle(rs.getString("title"));
				reviewDto.setContent(rs.getString("content"));
				reviewDto.setScore(rs.getInt("score"));
				reviewDto.setImg(rs.getString("img"));
				reviewDto.setIsBlind(rs.getInt("is_blind"));
				reviewDto.setRegDate(rs.getString("reg_date"));
				reviewDto.setUpdateDate(rs.getString("update_date"));
				list.add(reviewDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return list;
	}

	@Override
	public ReviewDto getReview(int reviewId) {
		ReviewDto reviewDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT * \n");
			sql.append("FROM review \n");
			sql.append("WHERE review_id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, reviewId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				reviewDto = new ReviewDto();
				reviewDto.setReviewId(reviewId);
				reviewDto.setShopId(rs.getInt("shop_id"));
				reviewDto.setUserId(rs.getInt("user_id"));
				reviewDto.setTitle(rs.getString("title"));
				reviewDto.setContent(rs.getString("content"));
				reviewDto.setScore(rs.getInt("score"));
				reviewDto.setImg(rs.getString("img"));
				reviewDto.setIsBlind(rs.getInt("is_blind"));
				reviewDto.setRegDate(rs.getString("reg_date"));
				reviewDto.setUpdateDate(rs.getString("update_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return reviewDto;
	}

}
