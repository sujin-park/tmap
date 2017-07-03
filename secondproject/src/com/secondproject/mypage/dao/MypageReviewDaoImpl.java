package com.secondproject.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.secondproject.constant.BoardConstant;
import com.secondproject.mypage.model.MyReviewDto;
import com.secondproject.mypage.model.ReviewCommentDto;
import com.secondproject.mypage.model.ReviewGoodBad;
import com.secondproject.util.db.DBClose;
import com.secondproject.util.db.DBConnection;

public class MypageReviewDaoImpl implements MypageReviewDao {

	private static MypageReviewDao mypageReviewDao;

	static {
		mypageReviewDao = new MypageReviewDaoImpl();
	}

	private MypageReviewDaoImpl() {
	}

	public static MypageReviewDao getMypageReviewDao() {
		return mypageReviewDao;
	}

	@Override
	public List<MyReviewDto> reviewListView(Map<String, Object> params) {
		List<MyReviewDto> list = new ArrayList<MyReviewDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int pageEnd = (Integer) params.get("pg") * BoardConstant.MYREVIEW_PAGE_SIZE;
		int pageStart = pageEnd - BoardConstant.MYREVIEW_PAGE_SIZE;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select b.* \n");
			sql.append("	from (select rownum rn,a.* \n");
			sql.append("		from (select r.review_id,nvl(s.title,'¾øÀ½') shop_name,nvl(s.address,'') address,u.email,r.score myscore,r.title subject, \n");
			sql.append("					r.content,decode(to_char(sysdate,'yyyy.mm.dd'), to_char(r.update_date, 'yyyy.mm.dd'), \n");
			sql.append("			to_char(r.update_date, 'hh24:mi:ss'), to_char(r.update_date, 'yy.mm.dd')) update_date \n");
			sql.append("						,nvl(a.comment_cnt,0) comment_cnt,nvl(gg.good,0) good,nvl(bb.bad,0) bad,nvl(lat,0) lat,nvl(lng,0) lng \n");
			sql.append("							from review r \n");
			sql.append("		left outer join shop s on s.shop_id=r.shop_id \n");
			sql.append("			join users u on u.user_id=r.user_id \n");
			sql.append("		left outer join (select review_id,count(review_comment_id) comment_cnt \n");
			sql.append("								from review_comment \n");
			sql.append("					group by review_id \n");
			sql.append("						order by review_id) a on r.review_id=a.review_id \n");
			sql.append("		left outer join (select review_id,count(good) good \n");
			sql.append("							from review_good_bad \n");
			sql.append("							where good=1 \n");
			sql.append("							group by review_id) gg on gg.review_id=r.review_id \n");
			sql.append("		left outer join (select review_id,count(bad) bad \n");
			sql.append("						from review_good_bad \n");
			sql.append("						where bad=1 \n");
			sql.append("					group by review_id) bb on bb.review_id=r.review_id \n");
			sql.append("	where u.user_id=? \n");
			sql.append("	order by update_date desc \n");
			sql.append("	) a \n");
			sql.append("	where rownum<=? \n");
			sql.append("		)b \n");
			sql.append("where b.rn>? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, (Integer) params.get("userId"));
			pstmt.setInt(2, pageEnd);
			pstmt.setInt(3, pageStart);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MyReviewDto myreviewdto = new MyReviewDto();
				myreviewdto.setReviewId(rs.getString("review_id"));
				myreviewdto.setShopName(rs.getString("shop_name"));
				myreviewdto.setAddress(rs.getString("address"));
				myreviewdto.setEmail(rs.getString("email"));
				myreviewdto.setMyScore(rs.getString("myscore"));
				myreviewdto.setSubject(rs.getString("subject"));
				myreviewdto.setContent(rs.getString("content"));
				myreviewdto.setUpdate_date(rs.getString("update_date"));
				myreviewdto.setCommentCnt(rs.getString("comment_cnt"));
				myreviewdto.setGood(rs.getString("good"));
				myreviewdto.setBad(rs.getString("bad"));
				myreviewdto.setLat(rs.getString("lat"));
				myreviewdto.setLng(rs.getString("lng"));
				list.add(myreviewdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return list;
	}

	@Override
	public MyReviewDto reviewView(int reviewId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MyReviewDto myreviewdto = new MyReviewDto();
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select a.review_id,u.email,a.good,a.bad,a.title subject,a.score, \n");
			sql.append("	   decode(to_char(sysdate,'yyyy.mm.dd'), to_char(a.update_date, 'yyyy.mm.dd'), \n");
			sql.append("       to_char(a.update_date, 'hh24:mi:ss'), to_char(a.update_date, 'yyyy.mm.dd')) update_date, \n");
			sql.append("       a.content,a.img reviewImg, \n");
			sql.append("		s.title shop_name,s.address,s.lat,s.lng,s.reserve_url,s.tel,s.business_time,s.detail \n");
			sql.append("from (select * from review r,(select nvl(sum(good),0) good from review_good_bad  \n");
			sql.append("		where review_id=?),(select nvl(sum(bad),0) bad from review_good_bad where review_id=?)) a \n");
			sql.append("join shop s on s.shop_id=a.shop_id \n");
			sql.append("join users u on u.user_id=a.user_id  \n");
			sql.append("where a.review_id=? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, reviewId);
			pstmt.setInt(2, reviewId);
			pstmt.setInt(3, reviewId);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				myreviewdto.setEmail(rs.getString("email"));
				myreviewdto.setGood(rs.getString("good"));
				myreviewdto.setBad(rs.getString("bad"));
				myreviewdto.setSubject(rs.getString("subject"));
				myreviewdto.setMyScore(rs.getString("score"));
				myreviewdto.setUpdate_date(rs.getString("update_date"));
				myreviewdto.setContent(rs.getString("content"));
				myreviewdto.setReviewimg(rs.getString("reviewimg"));
				myreviewdto.setShopName(rs.getString("shop_name"));
				myreviewdto.setAddress(rs.getString("address"));
				myreviewdto.setLat(rs.getString("lat"));
				myreviewdto.setLng(rs.getString("lng"));
				myreviewdto.setReserveUrl(rs.getString("reserve_url"));
				myreviewdto.setTel(rs.getString("tel"));
				myreviewdto.setBusinessTime(rs.getString("business_time"));
				myreviewdto.setDetail(rs.getString("detail"));
				myreviewdto.setReviewId(rs.getString("review_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return myreviewdto;
	}

	@Override
	public int totalReviewCount(Map<String, Object> params) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();

			sql.append(" select count(*) \n");
			sql.append("	from review \n");
			sql.append(" 	where user_id=? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, (Integer) params.get("userId"));
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public List<ReviewCommentDto> commentList(int reviewId) {
		List<ReviewCommentDto> list = new ArrayList<ReviewCommentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select * \n");
			sql.append("from review_comment \n");
			sql.append("where review_id=?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, reviewId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ReviewCommentDto cdto = new ReviewCommentDto();
				cdto.setReviewCommentId(rs.getInt("review_comment_id"));
				cdto.setReviewId(rs.getInt("review_id"));
				cdto.setUserid(rs.getInt("user_id"));
				cdto.setReviewContent(rs.getString("review_content"));
				list.add(cdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return list;
	}

	@Override
	public ReviewGoodBad goodbad(int reviewId, int userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReviewGoodBad goodbad = new ReviewGoodBad();
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select * \n");
			sql.append("from review_good_bad  \n");
			sql.append("where review_id=? and user_id=?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, reviewId);
			pstmt.setInt(2, userId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				goodbad.setReview_id(rs.getInt("review_id"));
				goodbad.setUser_id(rs.getInt("user_id"));
				goodbad.setGood(rs.getInt("good"));
				goodbad.setBad(rs.getInt("bad"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

		return goodbad;
	}

	@Override
	public void goodbadselect(int good, int bad, int userId, int reviewId) {
//		if(bad==1) {
//			//update 00
//			
//		} else {
//				//01
//		}
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			conn = DBConnection.getConnection();
			ReviewGoodBad regb = goodbad(reviewId, userId);
			if(regb.getReview_id()==0) {
            
            StringBuffer insert = new StringBuffer();
            insert.append("insert into review_good_bad \n");
            insert.append("values (?,?,?,?)");
            pstmt = conn.prepareStatement(insert.toString());
            pstmt.setInt(1, reviewId);
            pstmt.setInt(2, userId);
            pstmt.setInt(3, good);
            pstmt.setInt(4, bad);
            pstmt.executeUpdate();
			} else {
            StringBuffer update = new StringBuffer();
            update.append("update review_good_bad \n");
            update.append("set good=?,bad=?");
            pstmt = conn.prepareStatement(update.toString());
            pstmt.setInt(1, good);
            pstmt.setInt(2, bad);
            pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}

	}

}
