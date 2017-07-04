package com.secondproject.mypage.service;

import java.util.List;
import java.util.Map;

import com.secondproject.mypage.dao.MypageReviewDaoImpl;
import com.secondproject.mypage.model.MyReviewDto;
import com.secondproject.mypage.model.ReviewCommentDto;
import com.secondproject.mypage.model.ReviewGoodBad;

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



	@Override
	public List<ReviewCommentDto> commentList(int reviewId) {
		return MypageReviewDaoImpl.getMypageReviewDao().commentList(reviewId);
	}



	@Override
	public ReviewGoodBad goodbad(int reviewId, int userId) {
		return MypageReviewDaoImpl.getMypageReviewDao().goodbad(reviewId, userId);
	}



	@Override
	public void goodbadselect(int good, int bad, int userId, int reviewId) {
		MypageReviewDaoImpl.getMypageReviewDao().goodbadselect(good, bad, userId, reviewId);
		
	}



	@Override
	public void commentinsert(int reviewId, int userId, String content) {
		MypageReviewDaoImpl.getMypageReviewDao().commentinsert(reviewId, userId, content);
		
	}



	

}
