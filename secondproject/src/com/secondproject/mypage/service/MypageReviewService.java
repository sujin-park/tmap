package com.secondproject.mypage.service;

import java.util.List;
import java.util.Map;

import com.secondproject.mypage.model.FollowCategoryDto;
import com.secondproject.mypage.model.FollowUserDto;
import com.secondproject.mypage.model.MyReviewDto;
import com.secondproject.mypage.model.ReviewCommentDto;
import com.secondproject.mypage.model.ReviewGoodBad;

public interface MypageReviewService {
	 List<MyReviewDto> reviewListView(Map<String, Object> params);
	 MyReviewDto reviewView(int reviewId);
	 int totalReviewCount(Map<String, Object> params);
	 List<ReviewCommentDto> commentList(int reviewId);
	 ReviewGoodBad goodbad(int reviewId,int userId);
	 void goodbadselect(int good,int bad,int userId,int reviewId);
	 void commentinsert(int reviewId,int userId,String content);
	 
}

