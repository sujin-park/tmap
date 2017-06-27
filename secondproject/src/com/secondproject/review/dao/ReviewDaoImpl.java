package com.secondproject.review.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.secondproject.map.model.ShopDto;
import com.secondproject.review.model.ReviewDto;
import com.secondproject.util.db.DBClose;
import com.secondproject.util.db.DBConnection;

public class ReviewDaoImpl implements ReviewDao {

	private static ReviewDao reviewDao;
	
	static {
		reviewDao = new ReviewDaoImpl();
	}
	
	private ReviewDaoImpl(){}
	
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
			sql.append("(review_id, shop_id, user_id, title, content, score, reg_date, update_date) \n");
			sql.append("VALUES (SEQ_REVIEW_ID.nextval, ?, ?, ?, ?, ?, sysdate, sysdate)");
			pstmt = conn.prepareStatement(sql.toString());
			int i = 0;
			pstmt.setInt(++i, reviewDto.getShopId());
			pstmt.setInt(++i, reviewDto.getUserId());
			pstmt.setString(++i, reviewDto.getTitle());
			pstmt.setString(++i, reviewDto.getContent());
			pstmt.setDouble(++i, reviewDto.getScore());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}

		return count;
	}

}
