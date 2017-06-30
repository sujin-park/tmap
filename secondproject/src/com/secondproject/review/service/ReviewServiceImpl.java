package com.secondproject.review.service;

import java.util.List;

import com.secondproject.review.dao.ReviewDaoImpl;
import com.secondproject.review.model.ReviewDto;
import com.secondproject.review.model.ReviewListDto;
import com.secondproject.util.Params;

public class ReviewServiceImpl implements ReviewService {

	private static ReviewService reviewService;

	static {
		reviewService = new ReviewServiceImpl();
	}

	private ReviewServiceImpl() {}

	public static final ReviewService getReviewService() {
		return reviewService;
	}

	@Override
	public int addReview(ReviewDto reviewDto) {
		return ReviewDaoImpl.getReviewDao().addReview(reviewDto);
	}

	@Override
	public ReviewDto getReview(int reviewId) {
		return ReviewDaoImpl.getReviewDao().getReview(reviewId);
	}
	
	@Override
	public int getTotalCountByShopNotBlind(Params params) {
		return ReviewDaoImpl.getReviewDao().getTotalCountByShopNotBlind(params);
	}

	@Override
	public int getTotalCountByShopJustBlind(Params params) {
		return ReviewDaoImpl.getReviewDao().getTotalCountByShopJustBlind(params);
	}

	@Override
	public int getTotalCountByShopAll(Params params) {
		return ReviewDaoImpl.getReviewDao().getTotalCountByShopAll(params);
	}

	@Override
	public int getTotalCountByUserNotBlind(Params params) {
		return ReviewDaoImpl.getReviewDao().getTotalCountByUserNotBlind(params);
	}

	@Override
	public int getTotalCountByUserJustBlind(Params params) {
		return ReviewDaoImpl.getReviewDao().getTotalCountByShopJustBlind(params);
	}

	@Override
	public int getTotalCountByUserAll(Params params) {
		return ReviewDaoImpl.getReviewDao().getTotalCountByUserAll(params);
	}
	
	@Override
	public List<ReviewListDto> getReviewListByShopNotBlind(Params params) {
		return ReviewDaoImpl.getReviewDao().getReviewListByShopNotBlind(params);
	}

	@Override
	public List<ReviewListDto> getReviewListByShopJustBlind(Params params) {
		return ReviewDaoImpl.getReviewDao().getReviewListByShopJustBlind(params);
	}

	@Override
	public List<ReviewListDto> getReviewListByShopAll(Params params) {
		return ReviewDaoImpl.getReviewDao().getReviewListByShopAll(params);
	}

	@Override
	public List<ReviewListDto> getReviewListByUserNotBlind(Params params) {
		return ReviewDaoImpl.getReviewDao().getReviewListByUserNotBlind(params);
	}

	@Override
	public List<ReviewListDto> getReviewListByUserJustBlind(Params params) {
		return ReviewDaoImpl.getReviewDao().getReviewListByUserJustBlind(params);
	}

	@Override
	public List<ReviewListDto> getReviewListByUserAll(Params params) {
		return ReviewDaoImpl.getReviewDao().getReviewListByUserAll(params);
	}

}
