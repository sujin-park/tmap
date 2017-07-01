package com.secondproject.admin.service;

import java.util.Map;

import com.secondproject.util.PageNavigation;

public interface CommonService {


	int totalExhibitionCount(Map<String, Object> params); // 관리자-기획전관리 글 갯수
	
	int totalReviewCount(Map<String, Object> params); // 관리자-리뷰관리 글 갯수
	
	int totalUserCount(Map<String, Object> params); // 관리자-회원관리 글 갯수
	
	int totalShopCount(Map<String, Object> params); // 관리자-매장관리 글 갯수 
	PageNavigation mypagePageNavigation(int pg, String key, String word, String control); // MYPAGE 페이징처리
	
}