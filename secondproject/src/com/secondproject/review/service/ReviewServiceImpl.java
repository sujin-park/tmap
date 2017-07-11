package com.secondproject.review.service;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.secondproject.review.dao.ReviewDaoImpl;
import com.secondproject.review.model.ReviewDto;
import com.secondproject.review.model.ReviewListDto;

public class ReviewServiceImpl implements ReviewService {

	private static ReviewService reviewService;

	static {
		reviewService = new ReviewServiceImpl();
	}

	private ReviewServiceImpl() {
	}

	public static ReviewService getReviewService() {
		return reviewService;
	}

	@Override
	public int addReview(ReviewDto reviewDto) {
		return ReviewDaoImpl.getReviewDao().addReview(reviewDto);
	}

	@Override
	public int modifyReview(ReviewDto reviewDto) {
		return ReviewDaoImpl.getReviewDao().modifyReview(reviewDto);
	}

	@Override
	public int deleteReview(int reviewId) {
		return ReviewDaoImpl.getReviewDao().deleteReview(reviewId);
	}

	@Override
	public ReviewDto getReview(int reviewId) {
		return ReviewDaoImpl.getReviewDao().getReview(reviewId);
	}

	@Override
	public int getTotalCountByShopNotBlind(Map<String, Object> params) {
		return ReviewDaoImpl.getReviewDao().getTotalCountByShopNotBlind(params);
	}

	@Override
	public int getTotalCountByShopJustBlind(Map<String, Object> params) {
		return ReviewDaoImpl.getReviewDao().getTotalCountByShopJustBlind(params);
	}

	@Override
	public int getTotalCountByShopAll(Map<String, Object> params) {
		return ReviewDaoImpl.getReviewDao().getTotalCountByShopAll(params);
	}

	@Override
	public int getTotalCountByUserNotBlind(Map<String, Object> params) {
		return ReviewDaoImpl.getReviewDao().getTotalCountByUserNotBlind(params);
	}

	@Override
	public int getTotalCountByUserJustBlind(Map<String, Object> params) {
		return ReviewDaoImpl.getReviewDao().getTotalCountByShopJustBlind(params);
	}

	@Override
	public int getTotalCountByUserAll(Map<String, Object> params) {
		return ReviewDaoImpl.getReviewDao().getTotalCountByUserAll(params);
	}

	@Override
	public List<ReviewListDto> getReviewListByShopNotBlind(Map<String, Object> params) {
		return ReviewDaoImpl.getReviewDao().getReviewListByShopNotBlind(params);
	}

	@Override
	public List<ReviewListDto> getReviewListByShopJustBlind(Map<String, Object> params) {
		return ReviewDaoImpl.getReviewDao().getReviewListByShopJustBlind(params);
	}

	@Override
	public List<ReviewListDto> getReviewListByShopAll(Map<String, Object> params) {
		return ReviewDaoImpl.getReviewDao().getReviewListByShopAll(params);
	}

	@Override
	public List<ReviewListDto> getReviewListByUserNotBlind(Map<String, Object> params) {
		return ReviewDaoImpl.getReviewDao().getReviewListByUserNotBlind(params);
	}

	@Override
	public List<ReviewListDto> getReviewListByUserJustBlind(Map<String, Object> params) {
		return ReviewDaoImpl.getReviewDao().getReviewListByUserJustBlind(params);
	}

	@Override
	public List<ReviewListDto> getReviewListByUserAll(Map<String, Object> params) {
		return ReviewDaoImpl.getReviewDao().getReviewListByUserAll(params);
	}

	@Override
	public String getReviewGoodBadJSON(Map<String, Object> args) {
		return new Gson().toJson(ReviewDaoImpl.getReviewDao().getReviewGoodBadJSON(args));
	}

	@Override
	public String getReviewMyGoodBad(int loginUserId, int reviewId) {
		return ReviewDaoImpl.getReviewDao().getReviewMyGoodBad(loginUserId, reviewId);
	}

}
