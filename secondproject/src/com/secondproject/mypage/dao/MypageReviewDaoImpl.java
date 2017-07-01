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
import com.secondproject.util.db.DBClose;
import com.secondproject.util.db.DBConnection;

public class MypageReviewDaoImpl implements MypageReviewDao {

	private static MypageReviewDao mypageReviewDao;
	
	static {
		mypageReviewDao = new MypageReviewDaoImpl();
	}
	private MypageReviewDaoImpl () {}
	
	
	public static MypageReviewDao getMypageReviewDao() {
		return mypageReviewDao;
	}


	@Override
	public List<MyReviewDto> reviewListView(Map<String, Object> params) {
		List<MyReviewDto> list = new ArrayList<MyReviewDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int pageEnd = (Integer)params.get("pg") * BoardConstant.MYPAGE_LIST_SIZE;
		int pageStart = pageEnd - BoardConstant.MYPAGE_LIST_SIZE;
		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select b.* \n");
			sql.append("from (select rownum rn,a.* \n");
			sql.append("	from (select r.review_id,s.title shop_name,s.address,u.email,r.score myscore,r.title subject, \n");
			sql.append("				r.content,decode(to_char(sysdate,'yyyy.mm.dd'), to_char(r.update_date, 'yyyy.mm.dd'), \n");
			sql.append("				to_char(r.update_date, 'hh24:mi:ss'), to_char(r.update_date, 'yy.mm.dd')) update_date \n");
			sql.append("		from review r \n");
			sql.append("		join shop s on s.shop_id=r.shop_id \n");
			sql.append("		join users u on u.user_id=r.user_id \n");
			sql.append("		where u.user_id=? \n");
			sql.append("		order by update_date desc ) a \n");
			sql.append("	where rownum<=? \n");
			sql.append("		)b \n");
			sql.append("where b.rn>? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, (Integer)params.get("userId"));
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
			sql.append("select u.email,a.good,a.bad,a.title subject,a.score, \n");
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
	      Connection conn=null;
	      PreparedStatement pstmt = null;
	      ResultSet rs =null;
	      
	      try {
	         conn=DBConnection.getConnection();
	         StringBuffer sql = new StringBuffer();

	         sql.append(" select count(*) \n");
	         sql.append("	from review \n");
	         sql.append(" 	where user_id=? \n");
	         pstmt=conn.prepareStatement(sql.toString());
	         pstmt.setInt(1, (Integer)params.get("userId"));
	         rs=pstmt.executeQuery();
	         rs.next();
	         cnt=rs.getInt(1);
	            
	      } catch (SQLException e) {
	         
	         e.printStackTrace();
	      } finally {
	         DBClose.close(conn, pstmt, rs);
	      }
	      return cnt;
	}

}
