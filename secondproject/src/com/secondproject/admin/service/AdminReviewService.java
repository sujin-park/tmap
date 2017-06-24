package com.secondproject.admin.service;

import java.util.List;

import com.secondproject.review.model.AdminReviewDto;

public interface AdminReviewService {
	List<AdminReviewDto> listReview(String key, String word, String order, String column, int pg);
	AdminReviewDto viewReview(int seq);
	int blindExhibition(String[] reviews);
}