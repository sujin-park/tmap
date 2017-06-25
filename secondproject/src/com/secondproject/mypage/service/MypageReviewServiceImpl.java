package com.secondproject.mypage.service;

import java.util.List;

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
	public List<MyReviewDto> reviewListView(int userId) {
		
		return MypageReviewDaoImpl.getMypageReviewDao().reviewListView(userId);
	}

}
