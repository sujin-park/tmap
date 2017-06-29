package com.secondproject.review.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.secondproject.map.model.ShopDto;
import com.secondproject.review.model.ReviewDto;
import com.secondproject.review.model.ReviewListDto;
import com.secondproject.util.Params;
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
	
	@Override
	public List<ReviewListDto> getReviewListByShopNotBlind(Params params) {
		return getReviewListCommon("shop", "notBlind", params);
	}

	@Override
	public List<ReviewListDto> getReviewListByShopJustBlind(Params params) {
		return getReviewListCommon("shop", "justBlind", params);
	}

	@Override
	public List<ReviewListDto> getReviewListByShopAll(Params params) {
		return getReviewListCommon("shop", "", params);
	}

	@Override
	public List<ReviewListDto> getReviewListByUserNotBlind(Params params) {
		return getReviewListCommon("user", "notBlind", params);
	}

	@Override
	public List<ReviewListDto> getReviewListByUserJustBlind(Params params) {
		return getReviewListCommon("user", "justBlind", params);
	}

	@Override
	public List<ReviewListDto> getReviewListByUserAll(Params params) {
		return getReviewListCommon("user", "", params);
	}

	@Override
	public List<ReviewListDto> getReviewListCommon(String filterShopOrUser, String filterBlind, Params params) {
		ArrayList<ReviewListDto> list = new ArrayList<ReviewListDto>();

		String key = params.getKey();
		String word = params.getWord();
		String orderKey = params.getOrderKey();
		String orderValue = params.getOrderValue();
		int pageStart = 1;
		int pageEnd = 10;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT * \n");
			sql.append("FROM \n");
			sql.append("    ( \n");
			sql.append("        SELECT rownum num, A.* \n");
			sql.append("        FROM \n");
			sql.append("            ( \n");
			sql.append("                SELECT \n");
			sql.append(
					"                    review.review_id, review.user_id, user_email, review.title, review.score, review.img, review.reg_date,  \n");
			sql.append("                    NVL(gbc.good_count, 0) good_count, \n");
			sql.append("                    NVL(gbc.bad_count, 0) bad_count \n");
			sql.append("                FROM \n");
			sql.append("                    ( \n");
			sql.append("                        SELECT  \n");
			sql.append("                            review_id, user_id, title, score, img, reg_date, \n");
			sql.append(
					"                            (SELECT email FROM users where user_id = review.user_id) user_email \n");
			sql.append("                        FROM review \n");
			sql.append("                        WHERE \n");

			// 매장 기준 or 특정회원 기준
			if (filterShopOrUser.equals("shop")) {
				sql.append("                            shop_id = ? \n");
			} else {
				sql.append("                            user_id = ? \n");
			}

			// 관리자는 필요없는 부분
			if (filterBlind.isEmpty() == false) {
				String blindSql = "";
				if (filterBlind.equals("justBlind")) {
					blindSql = "                            and is_blind = 1 \n";
				} else if (filterBlind.equals("notBlind")) {
					blindSql = "                            and is_blind = 0 \n";
				}
				sql.append(blindSql);
			}

			// TODO 리뷰리스트 검색 조건설정
			if (key.isEmpty() == false && word.isEmpty() == false) {
				sql.append("                        AND " + key + " like '%' || ? || '%' \n");
			}

			sql.append("                        ");
			sql.append("                    ) review \n");
			sql.append("                    LEFT OUTER JOIN  \n");
			sql.append("                    ( \n");
			sql.append("                        SELECT review_id, SUM(good) good_count, SUM(bad) bad_count  \n");
			sql.append("                        FROM review_good_bad GROUP BY review_id \n");
			sql.append("                    ) gbc \n");
			sql.append("                    ON gbc.review_id = review.review_id \n");
			sql.append("                ORDER BY " + orderKey + " " + orderValue + " \n");
			sql.append("            ) A \n");
			sql.append("        WHERE rownum <= ? \n");
			sql.append("    ) B \n");
			sql.append("WHERE B.num >= ? \n");
			pstmt = conn.prepareStatement(sql.toString());

			int parameterIndex = 0;
			if (filterShopOrUser.equals("shop")) {
				pstmt.setInt(++parameterIndex, 1); // shopid
			} else {
				pstmt.setInt(++parameterIndex, 1); // userid
			}

			if (key.isEmpty() == false && word.isEmpty() == false) {
				pstmt.setString(++parameterIndex, word); // 검색어
			}

			pstmt.setInt(++parameterIndex, pageEnd); // pageEnd
			pstmt.setInt(++parameterIndex, pageStart); // pageStart
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ReviewListDto reviewListDto = new ReviewListDto();
				reviewListDto.setNum(rs.getInt("num"));
				reviewListDto.setReviewId(rs.getInt("review_id"));
				reviewListDto.setUserId(rs.getInt("user_id"));
				reviewListDto.setUserEmail(rs.getString("user_email"));
				reviewListDto.setTitle(rs.getString("title"));
				reviewListDto.setScore(rs.getInt("score"));
				reviewListDto.setImg(rs.getString("img"));
				reviewListDto.setRegDate(rs.getString("reg_date"));
				reviewListDto.setGoodCount(rs.getInt("good_count"));
				reviewListDto.setBadCount(rs.getInt("bad_count"));
				list.add(reviewListDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return list;
	}

	

}
