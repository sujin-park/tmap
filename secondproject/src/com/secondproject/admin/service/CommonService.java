package com.secondproject.admin.service;

import java.util.Map;

import com.secondproject.util.PageNavigation;

public interface CommonService {

	int totalExhibitionCount(Map<String, Object> params);
	
	PageNavigation mypagePageNavigation(int pg, String key, String word, String board); // MYPAGE 페이징처리
	
}