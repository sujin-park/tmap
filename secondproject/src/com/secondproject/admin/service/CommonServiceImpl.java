package com.secondproject.admin.service;

import java.util.HashMap;
import java.util.Map;

import com.secondproject.admin.dao.CommonDaoImpl;
import com.secondproject.constant.BoardConstant;
import com.secondproject.mypage.dao.MypageFollowDaoImpl;
import com.secondproject.util.PageNavigation;

public class CommonServiceImpl implements CommonService {

	private static CommonService commonService; // interface 타입으로 잡기

	private CommonServiceImpl() {
	};

	static {

		commonService = new CommonServiceImpl();
	}

	public static CommonService getCommonService() {
		return commonService;
	}



	@Override
	public int totalExhibitionCount(Map<String, Object> params) {
		return CommonDaoImpl.getCommonDao().totalExhibitionCount(params);
	}
	
	
	


	@Override
	public int totalReviewCount(Map<String, Object> params) {
		return CommonDaoImpl.getCommonDao().totalReviewCount(params);
	}



	@Override
	public int totalUserCount(Map<String, Object> params) {
		return CommonDaoImpl.getCommonDao().totalUserCount(params);
	}



	@Override
	public int totalShopCount(Map<String, Object> params) {
		return CommonDaoImpl.getCommonDao().totalShopCount(params);
	}
}