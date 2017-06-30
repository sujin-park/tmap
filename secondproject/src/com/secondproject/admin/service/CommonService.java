package com.secondproject.admin.service;

import java.util.Map;

import com.secondproject.util.PageNavigation;

public interface CommonService {


	int totalExhibitionCount(Map<String, Object> params); // pagenavigation에서 페이징 처리 해주는거 함
	PageNavigation mypagePageNavigation(int pg, String key, String word, String control); // MYPAGE 페이징처리
	
}