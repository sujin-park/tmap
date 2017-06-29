package com.secondproject.review.dao;

import java.util.List;

import com.secondproject.review.model.ReviewDto;
import com.secondproject.util.PagenationParameter;

public interface ReviewDao {
	int addReview(ReviewDto reviewDto);
	List<ReviewDto> getReviewList(PagenationParameter pagenationParameter);
	ReviewDto getReview(int reviewId);
}
