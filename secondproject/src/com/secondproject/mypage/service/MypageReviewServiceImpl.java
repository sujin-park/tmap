package com.secondproject.mypage.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.secondproject.mypage.dao.MypageReviewDaoImpl;
import com.secondproject.mypage.model.MyReviewDto;
import com.secondproject.util.db.DBClose;
import com.secondproject.util.db.DBConnection;

public class MypageReviewServiceImpl implements MypageReviewService{

	private static MypageReviewService mypageReviewService;
	
	static {
		mypageReviewService = new MypageReviewServiceImpl();
	}
	private MypageReviewServiceImpl () {}
	
	
	
	public static MypageReviewService getMypageReviewService() {
		return mypageReviewService;
	}



	@Override
	public List<MyReviewDto> reviewListView(int userId) {
		
		return MypageReviewDaoImpl.getMypageReviewDao().reviewListView(userId);
	}



	

}
