package com.secondproject.admin.dao;

import java.util.Map;

public interface CommonDao {
	int totalExhibitionCount(Map<String, Object> params);

	int totalReviewCount(Map<String, Object> params);

	int totalUserCount(Map<String, Object> params);

	int totalShopCount(Map<String, Object> params);

	int totalOwnerCount(Map<String, Object> params); // 관리자-사장관리 갯수

	int totalShopListCount(Map<String, Object> params); // 관리자-기획전관리-매장리스트 갯수
}