package com.secondproject.review.service;

import java.util.List;
import java.util.Map;

import com.secondproject.review.model.ReviewDto;
import com.secondproject.util.PagenationParameter;

public interface ReviewService {
	int addReview(ReviewDto reviewDto);
	List<ReviewDto> getReviewList(PagenationParameter pagenationParameter);
}
