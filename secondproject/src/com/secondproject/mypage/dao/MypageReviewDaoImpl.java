package com.secondproject.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public List<MyReviewDto> reviewListView(int userId) {
		List<MyReviewDto> list = new ArrayList<MyReviewDto>();
		MyReviewDto myreviewdto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select s.title shop_name,s.address,s.score shscore,u.email,r.score myscore,r.title subject,r.content,to_char(r.update_date,'yyyy.mm.dd') update_date \n");
			sql.append("from review r \n");
			sql.append("		join shop s on s.shop_id=r.shop_id \n");
			sql.append("		join users u on u.user_id=r.user_id \n");
			sql.append("		where u.user_id=?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				myreviewdto=new MyReviewDto();
				myreviewdto.setShopName(rs.getString("shop_name"));
				myreviewdto.setAddress(rs.getString("address"));
				myreviewdto.setShopScore(rs.getString("shscore"));
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

}
