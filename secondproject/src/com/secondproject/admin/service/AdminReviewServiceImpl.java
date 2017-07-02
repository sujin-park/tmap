package com.secondproject.admin.service;

import java.util.*;

import com.secondproject.admin.dao.AdminReviewDaoImpl;
import com.secondproject.admin.dao.ExhibitionDaoImpl;
import com.secondproject.constant.BoardConstant;
import com.secondproject.review.model.AdminReviewDto;

public class AdminReviewServiceImpl implements AdminReviewService {
	
	private static AdminReviewService adminReviewService;
	


	static {
		adminReviewService = new AdminReviewServiceImpl();
	}
	
	private AdminReviewServiceImpl(){}
	
	public static AdminReviewService getAdminReviewService() {
		return adminReviewService;
	}
	
	@Override
	public List<AdminReviewDto> listReview(Map<String, Object> params) {
		return AdminReviewDaoImpl.getAdminReviewDao().listReview(params);
	}

	@Override
	public AdminReviewDto viewReview(int seq) {
		return AdminReviewDaoImpl.getAdminReviewDao().viewReview(seq);
	}

	@Override
	public int blindExhibition(String[] reviews) {
		return AdminReviewDaoImpl.getAdminReviewDao().blindExhibition(reviews);
	}


}
