package com.secondproject.admin.dao;

import java.util.Map;

public interface CommonDao {
	int totalArticleCount(Map<String, String> map);
	
	int totalReviewCount(Map<String, String> map);
	
}