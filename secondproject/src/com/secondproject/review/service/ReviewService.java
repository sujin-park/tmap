package com.secondproject.review.service;

import java.util.List;
import java.util.Map;

import com.secondproject.review.model.ReviewDto;
import com.secondproject.review.model.ReviewListDto;
import com.secondproject.util.Params;

public interface ReviewService {

	int addReview(ReviewDto reviewDto);

	ReviewDto getReview(int reviewId);

	int getTotalCountByShopNotBlind(Params params);

	int getTotalCountByShopJustBlind(Params params);

	int getTotalCountByShopAll(Params params);

	int getTotalCountByUserNotBlind(Params params);

	int getTotalCountByUserJustBlind(Params params);

	int getTotalCountByUserAll(Params params);

	List<ReviewListDto> getReviewListByShopNotBlind(Params params);

	List<ReviewListDto> getReviewListByShopJustBlind(Params params);

	List<ReviewListDto> getReviewListByShopAll(Params params);

	List<ReviewListDto> getReviewListByUserNotBlind(Params params);

	List<ReviewListDto> getReviewListByUserJustBlind(Params params);

	List<ReviewListDto> getReviewListByUserAll(Params params);

}
