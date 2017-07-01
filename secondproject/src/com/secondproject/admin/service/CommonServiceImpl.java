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
	
	
	public PageNavigation mypagePageNavigation(int pg, String key, String word, String control) {
		PageNavigation pageNavigation = new PageNavigation();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("key", key);
		map.put("word", word);
		map.put("control", control);
		map.put("userId",2+"");
		int totalArticleCount = MypageFollowDaoImpl.getMypageFollowDao().totalArticleCount(map);
		
		int totalPageCount = (totalArticleCount - 1) / BoardConstant.MYPAGE_LIST_SIZE + 1;
		pageNavigation.setTotalArticleCount(totalArticleCount);
		pageNavigation.setTotalPageCount(totalPageCount);
		pageNavigation.setNowFirst(pg <= BoardConstant.MYPAGE_PAGE_SIZE);
		pageNavigation.setNowEnd((totalPageCount-1)/BoardConstant.MYPAGE_PAGE_SIZE == (pg-1)/BoardConstant.MYPAGE_PAGE_SIZE);
		pageNavigation.setPageNo(pg);
		return pageNavigation;
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