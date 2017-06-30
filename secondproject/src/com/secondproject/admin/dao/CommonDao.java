package com.secondproject.admin.dao;

import java.util.Map;

public interface CommonDao {
	int totalExhibitionCount(Map<String, Object> params);
	
	int totalReviewCount(Map<String, String> map);
	
}