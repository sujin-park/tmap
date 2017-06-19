package com.secondproject.mypage.dao;

import java.util.List;
import java.util.Map;

import com.secondproject.mypage.model.FollowCategoryDto;
import com.secondproject.mypage.model.FavoriteUserDto;

public interface MypageFollowDao {
	//favorite_category
	 int followCategoryMake(FollowCategoryDto favoriteCategoryDto);
	 int followCategoryModify(FollowCategoryDto favoriteCategoryDto);
	 int followCategoryDelete(int favoriteCategoryId);
	 int followCategoryOrder(int favoriteCategoryId,int category_order);
	 FollowCategoryDto getFollowCategory(int favoriteCategoryId);
	 FollowCategoryDto getCategoryId(int userId,int category_order);
	 int upOrder(int favoriteCategoryId);
	 int downOrder(int favoriteCategoryId);
	 List<FollowCategoryDto> followCategoryListView(int userId);
	 //favorite_user
	 FavoriteUserDto getFollow(int favoriteUserId);
	 List<FavoriteUserDto> followListView(int userId);
	 int followMove(Map<String,String> map);
	 int followDelete(int favoriteUserId);
	 int followModify(Map<String,String> map);

	 
}
