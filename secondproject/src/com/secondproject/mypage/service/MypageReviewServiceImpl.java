package com.secondproject.mypage.service;

import java.util.List;
import java.util.Map;

import com.secondproject.mypage.dao.MypageReviewDaoImpl;
import com.secondproject.mypage.model.MyReviewDto;

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
	public List<MyReviewDto> reviewListView(Map<String, Object> params) {
		
		return MypageReviewDaoImpl.getMypageReviewDao().reviewListView(params);
	}



	@Override
	public MyReviewDto reviewView(int reviewId) {
		
		return MypageReviewDaoImpl.getMypageReviewDao().reviewView(reviewId);
	}



	@Override
	public int totalReviewCount(Map<String, Object> params) {
	
		return MypageReviewDaoImpl.getMypageReviewDao().totalReviewCount(params);
	}



	

}
