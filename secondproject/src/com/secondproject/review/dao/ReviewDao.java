package com.secondproject.review.dao;

import java.util.List;

import com.secondproject.review.model.ReviewDto;
import com.secondproject.review.model.ReviewListDto;
import com.secondproject.util.Params;

public interface ReviewDao {

	int addReview(ReviewDto reviewDto);

	ReviewDto getReview(int reviewId);

	List<ReviewListDto> getReviewListByShopNotBlind(Params params);

	List<ReviewListDto> getReviewListByShopJustBlind(Params params);

	List<ReviewListDto> getReviewListByShopAll(Params params);

	List<ReviewListDto> getReviewListByUserNotBlind(Params params);

	List<ReviewListDto> getReviewListByUserJustBlind(Params params);

	List<ReviewListDto> getReviewListByUserAll(Params params);

	List<ReviewListDto> getReviewListCommon(String filterShopOrUser, String filterBlind, Params params);

}
