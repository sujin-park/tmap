package com.secondproject.admin.service;

import java.util.Map;

import com.secondproject.util.PageNavigation;

public interface CommonService {


	int totalExhibitionCount(Map<String, Object> params); // 관리자-기획전관리 갯수
	
	int totalReviewCount(Map<String, Object> params); // 관리자-리뷰관리 갯수
	
	int totalUserCount(Map<String, Object> params); // 관리자-회원관리 갯수
	
	int totalShopCount(Map<String, Object> params); // 관리자-매장관리  갯수 
	
	int totalOwnerCount(Map<String, Object> params); // 관리자-사장관리 갯수
	
	int totalShopListCount(Map<String, Object> params); // 관리자-기획전관리-매장리스트 갯수
}