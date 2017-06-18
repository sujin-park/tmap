package com.secondproject.mypage.dao;

import java.util.List;
import java.util.Map;

import com.secondproject.mypage.model.FavoriteCategoryDto;
import com.secondproject.mypage.model.FavoriteUserDto;

public interface MypageFollowDao {
	//favorite_category
	 int followCategoryMake(FavoriteCategoryDto favoriteCategoryDto);
	 int followCategoryModify(FavoriteCategoryDto favoriteCategoryDto);
	 int followCategoryDelete(int favoriteCategoryId);
	 int followCategoryOrder(int favoriteCategoryId,int category_order);
	 FavoriteCategoryDto getFollowCategory(int favoriteCategoryId);
	 List<FavoriteCategoryDto> followCategoryListView(int userId);
	 //favorite_user
	 FavoriteUserDto getFollow(int favoriteUserId);
	 List<FavoriteUserDto> followListView(int userId);
	 int followMove(Map<String,String> map);
	 int followDelete(int favoriteUserId);
	 int followModify(Map<String,String> map);

	 
}
