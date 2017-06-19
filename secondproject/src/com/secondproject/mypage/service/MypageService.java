package com.secondproject.mypage.service;

import java.util.List;

import com.secondproject.mypage.model.FollowCategoryDto;

public interface MypageService {
	 List<FollowCategoryDto> followCategoryListView(int userId);
	 int upOrder(int favoriteCategoryId);
	 int downOrder(int favoriteCategoryId);
}
