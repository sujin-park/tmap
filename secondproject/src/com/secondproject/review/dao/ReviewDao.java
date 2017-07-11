package com.secondproject.review.dao;

import java.util.List;
import java.util.Map;

import com.secondproject.review.model.ReviewDto;
import com.secondproject.review.model.ReviewListDto;

public interface ReviewDao {

	int addReview(ReviewDto reviewDto);

	int modifyReview(ReviewDto reviewDto);

	int deleteReview(int reviewId);

	ReviewDto getReview(int reviewId);

	int getTotalCountByShopNotBlind(Map<String, Object> params);

	int getTotalCountByShopJustBlind(Map<String, Object> params);

	int getTotalCountByShopAll(Map<String, Object> params);

	int getTotalCountByUserNotBlind(Map<String, Object> params);

	int getTotalCountByUserJustBlind(Map<String, Object> params);

	int getTotalCountByUserAll(Map<String, Object> params);

	int getTotalCount(String filterShopOrUser, String filterBlind, Map<String, Object> params);

	List<ReviewListDto> getReviewListByShopNotBlind(Map<String, Object> params);

	List<ReviewListDto> getReviewListByShopJustBlind(Map<String, Object> params);

	List<ReviewListDto> getReviewListByShopAll(Map<String, Object> params);

	List<ReviewListDto> getReviewListByUserNotBlind(Map<String, Object> params);

	List<ReviewListDto> getReviewListByUserJustBlind(Map<String, Object> params);

	List<ReviewListDto> getReviewListByUserAll(Map<String, Object> params);

	List<ReviewListDto> getReviewList(String filterShopOrUser, String filterBlind, Map<String, Object> params);

	Map<String, Object> getReviewGoodBadJSON(Map<String, Object> args);

}
