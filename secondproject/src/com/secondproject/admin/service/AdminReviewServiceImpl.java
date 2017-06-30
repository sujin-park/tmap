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
	public List<AdminReviewDto> listReview(String key, String word, String order, String column, int pg) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("key", key);
		map.put("word", word);
		map.put("order", order);
		map.put("column", column);
		int end = pg * BoardConstant.LIST_SIZE;
		int start = end - BoardConstant.LIST_SIZE; 
		map.put("start", start +""); // 페이지 첫번호와 마지막번호를 계산하기 위해서 start와 end 만듦
		map.put("end", end +"");
		
		return AdminReviewDaoImpl.getAdminReviewDao().listReview(map);
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
