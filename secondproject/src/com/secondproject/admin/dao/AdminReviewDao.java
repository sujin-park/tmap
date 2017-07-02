package com.secondproject.admin.dao;

import java.util.List;
import java.util.Map;

import com.secondproject.review.model.AdminReviewDto;


public interface AdminReviewDao {
	List<AdminReviewDto> listReview(Map<String, Object> params);
	AdminReviewDto viewReview(int seq);
	int blindExhibition(String[] reviews);
}