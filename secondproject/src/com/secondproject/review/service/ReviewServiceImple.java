package com.secondproject.review.service;

import com.secondproject.review.dao.ReviewDaoImpl;
import com.secondproject.review.model.ReviewDto;

public class ReviewServiceImple implements ReviewService {

	private static ReviewService reviewService;

	static {
		reviewService = new ReviewServiceImple();
	}

	private ReviewServiceImple() {}

	public static final ReviewService getReviewService() {
		return reviewService;
	}

	@Override
	public int addReview(ReviewDto reviewDto) {
		return ReviewDaoImpl.getReviewDao().addReview(reviewDto);
	}

}
