package com.secondproject.review.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.secondproject.constant.BoardConstant;
import com.secondproject.review.model.ReviewDto;
import com.secondproject.review.model.ReviewListDto;
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
	public int modifyReview(ReviewDto reviewDto) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE review \n");
			sql.append("SET title = ?, content = ? , score = ?, update_date = sysdate \n");
			if (reviewDto.getImg() != null && reviewDto.getImg().isEmpty() == false) {
				sql.append(", img = ? \n");
			}
			sql.append("WHERE review_id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			int i = 0;
			pstmt.setString(++i, reviewDto.getTitle());
			pstmt.setString(++i, reviewDto.getContent());
			pstmt.setInt(++i, reviewDto.getScore());
			if (reviewDto.getImg() != null && reviewDto.getImg().isEmpty() == false) {
				pstmt.setString(++i, reviewDto.getImg());
			}
			pstmt.setInt(++i, reviewDto.getReviewId());
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}

		return count;
	}

	@Override
	public int deleteReview(int reviewId) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("DELETE review \n");
			sql.append("WHERE review_id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, reviewId);
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
			sql.append("SELECT r.*, NVL(good, 0) good, NVL(bad, 0) bad \n");
			sql.append("FROM review r \n");
			sql.append("LEFT JOIN (SELECT review_id, SUM(good) good, SUM(bad) bad FROM review_good_bad GROUP BY review_id) gb ON gb.review_id = r.review_id \n");
			sql.append("WHERE r.review_id = ?");
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
				reviewDto.setGood(rs.getInt("good"));
				reviewDto.setBad(rs.getInt("bad"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return reviewDto;
	}

	@Override
	public int getTotalCountByShopNotBlind(Map<String, Object> params) {
		return getTotalCount("shop", "notBlind", params);
	}

	@Override
	public int getTotalCountByShopJustBlind(Map<String, Object> params) {
		return getTotalCount("shop", "justBlind", params);
	}

	@Override
	public int getTotalCountByShopAll(Map<String, Object> params) {
		return getTotalCount("shop", null, params);
	}

	@Override
	public int getTotalCountByUserNotBlind(Map<String, Object> params) {
		return getTotalCount("user", "notBlind", params);
	}

	@Override
	public int getTotalCountByUserJustBlind(Map<String, Object> params) {
		return getTotalCount("user", "justBlind", params);
	}

	@Override
	public int getTotalCountByUserAll(Map<String, Object> params) {
		return getTotalCount("user", null, params);
	}

	@Override
	public int getTotalCount(String filterShopOrUser, String filterBlind, Map<String, Object> params) {
		int totalCount = 0;
		String key = (String) params.get("key");
		String word = (String) params.get("word");

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT count(review_id) as total_count \n");
			sql.append("FROM review \n");
			sql.append("WHERE " + (filterShopOrUser.equals("shop") ? "shop_id" : "user_id") + " = ? \n");

			if (filterBlind == null || filterBlind.isEmpty() == false) {
				String blindSql = "";
				if (filterBlind.equals("justBlind")) {
					blindSql = "AND is_blind = 1 \n";
				} else if (filterBlind.equals("notBlind")) {
					blindSql = "AND is_blind = 0 \n";
				}
				sql.append(blindSql);
			}

			if (key.isEmpty() == false && word.isEmpty() == false) {
				sql.append("AND " + key + " like '%' || ? || '%' \n");
			}

			pstmt = conn.prepareStatement(sql.toString());

			int parameterIndex = 0;
			if (filterShopOrUser.equals("shop")) {
				pstmt.setInt(++parameterIndex, (int) params.get("shopId")); // shopId
			} else {
				pstmt.setInt(++parameterIndex, (int) params.get("userId")); // userId
			}

			if (key.isEmpty() == false && word.isEmpty() == false) {
				pstmt.setString(++parameterIndex, word); // 검색어
			}

			rs = pstmt.executeQuery();

			if (rs.next()) {
				totalCount = rs.getInt("total_count");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return totalCount;
	}

	@Override
	public List<ReviewListDto> getReviewListByShopNotBlind(Map<String, Object> params) {
		return getReviewList("shop", "notBlind", params);
	}

	@Override
	public List<ReviewListDto> getReviewListByShopJustBlind(Map<String, Object> params) {
		return getReviewList("shop", "justBlind", params);
	}

	@Override
	public List<ReviewListDto> getReviewListByShopAll(Map<String, Object> params) {
		return getReviewList("shop", null, params);
	}

	@Override
	public List<ReviewListDto> getReviewListByUserNotBlind(Map<String, Object> params) {
		return getReviewList("user", "notBlind", params);
	}

	@Override
	public List<ReviewListDto> getReviewListByUserJustBlind(Map<String, Object> params) {
		return getReviewList("user", "justBlind", params);
	}

	@Override
	public List<ReviewListDto> getReviewListByUserAll(Map<String, Object> params) {
		return getReviewList("user", null, params);
	}

	@Override
	public List<ReviewListDto> getReviewList(String filterShopOrUser, String filterBlind, Map<String, Object> params) {
		ArrayList<ReviewListDto> list = new ArrayList<ReviewListDto>();

		String key = (String) params.get("key");
		String word = (String) params.get("word");
		String orderKey = (String) params.get("orderKey");
		String orderValue = (String) params.get("orderValue");
		int pageEnd = (int) params.get("pg") * BoardConstant.SHOP_REVIEW_LIST_COUNT_PER_PAGE;
		int pageStart = pageEnd - BoardConstant.SHOP_REVIEW_LIST_COUNT_PER_PAGE + 1;

		// TODO 유효성 검사 해야되는데...너 무 귀 찮 다.
		if (orderKey.isEmpty()) {
			orderKey = "reg_date";
		}

		if (orderValue.isEmpty()
				|| (orderKey.toUpperCase().equals("DESC") == false && orderKey.toUpperCase().equals("ASC") == false)) {
			orderValue = "DESC";
		}

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

			if (filterShopOrUser.equals("user")) {
				sql.append("                    ,shop.title, shop.lat, shop.lng, shop.address \n");
			}

			sql.append("                FROM \n");
			sql.append("                    ( \n");
			sql.append("                        SELECT  \n");
			sql.append("                            review_id, user_id, title, score, img, reg_date, \n");
			sql.append(
					"                            (SELECT email FROM users where user_id = review.user_id) user_email \n");

			if (filterShopOrUser.equals("user")) {
				sql.append("                            ,shop.title as shop_title, lat, lng, address \n");
			}

			sql.append("                        FROM review \n");
			sql.append("                        WHERE \n");
			sql.append("                            " + (filterShopOrUser.equals("shop") ? "shop_id" : "user_id")
					+ " = ? \n");

			if (filterBlind == null || filterBlind.isEmpty() == false) {
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

			if (filterShopOrUser.equals("user")) {
				sql.append("                    JOIN shop ON review.shop_id = shop.shop_id \n");
			}

			sql.append("                ORDER BY " + orderKey + " " + orderValue + " \n");
			sql.append("            ) A \n");
			sql.append("        WHERE rownum <= ? \n");
			sql.append("    ) B \n");
			sql.append("WHERE B.num >= ? \n");
			// System.out.println(sql.toString());
			pstmt = conn.prepareStatement(sql.toString());

			int parameterIndex = 0;
			if (filterShopOrUser.equals("shop")) {
				pstmt.setInt(++parameterIndex, (int) params.get("shopId")); // shopid
			} else {
				pstmt.setInt(++parameterIndex, (int) params.get("userId")); // userid
			}

			if (key.isEmpty() == false && word.isEmpty() == false) {
				System.out.println("검색어 == " + word);
				pstmt.setString(++parameterIndex, word); // 검색어
			}

			pstmt.setInt(++parameterIndex, pageEnd); // pageEnd
			pstmt.setInt(++parameterIndex, pageStart); // pageStart
			// System.out.println("pageEnd === " + pageEnd);
			// System.out.println("pageStart === " + pageStart);
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

	@Override
	public Map<String, Object> getReviewGoodBadJSON(Map<String, Object> args) {
		Map<String, Object> goodBadMap = new HashMap<String, Object>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String status = "";
		
		int loginUserId = (int) args.get("loginUserId");
		int reviewId = (int) args.get("reviewId");
		String goodBad = (String) args.get("goodBad");
		
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT * FROM review_good_bad WHERE review_id = ? AND user_id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, reviewId);
			pstmt.setInt(2, loginUserId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int good = rs.getInt("good");
				int bad = rs.getInt("bad");
				sql = new StringBuffer();
				sql.append("UPDATE review_good_bad SET ");
				if ((good == 1 && goodBad.equals("good")) || (bad == 1 && goodBad.equals("bad"))) {
					sql.append("good = 0, bad = 0 \n");
					status = "00";
				} else {
					if (goodBad.equals("good")) {
						sql.append("good = 1, bad = 0 \n");
						status = "10";
					} else {
						sql.append("good = 0, bad = 1 \n");
						status = "01";
					}
				}
				sql.append("WHERE review_id = ? AND user_id = ?");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setInt(1, reviewId);
				pstmt.setInt(2, loginUserId);
				pstmt.executeUpdate();
			} else {
				sql = new StringBuffer();
				sql.append("INSERT INTO review_good_bad (review_id, user_id, good, bad) VALUES (?, ?, ?, ?)");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setInt(1, reviewId);
				pstmt.setInt(2, loginUserId);
				if (goodBad.equals("good")) {
					pstmt.setInt(3, 1);
					pstmt.setInt(4, 0);
					status = "10";
				} else {
					pstmt.setInt(3, 0);
					pstmt.setInt(4, 1);
					status = "01";
				}
				pstmt.executeUpdate();
			}
			
			sql = new StringBuffer();
			sql.append("SELECT SUM(good) good, SUM(bad) bad FROM review_good_bad WHERE review_id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, reviewId);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				goodBadMap.put("good", rs.getInt("good"));
				goodBadMap.put("bad", rs.getInt("bad"));
				goodBadMap.put("message", "처리되었습니다");
				goodBadMap.put("status", status);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		
		return goodBadMap;
	}

	@Override
	public String getReviewMyGoodBad(int loginUserId, int reviewId) {
		String returnString = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT good, bad FROM review_good_bad WHERE review_id = ? AND user_id = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, reviewId);
			pstmt.setInt(2, loginUserId);
			rs = pstmt.executeQuery();
			int good = 0;
			int bad = 0;
			if (rs.next()) {
				good = rs.getInt("good");
				bad = rs.getInt("bad");
			}
			
			if (good == 1) {
				returnString = "good";
			} else if (bad == 1) {
				returnString = "bad";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}

		return returnString;
	}

}
