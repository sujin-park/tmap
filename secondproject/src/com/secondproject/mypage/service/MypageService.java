package com.secondproject.mypage.service;

import java.util.List;

import com.secondproject.mypage.model.FavoriteCategoryDto;

public interface MypageService {
	 List<FavoriteCategoryDto> followCategoryListView(int userId);
}
