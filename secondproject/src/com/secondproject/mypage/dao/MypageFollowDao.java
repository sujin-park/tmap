package com.secondproject.mypage.dao;

import java.util.List;
import java.util.Map;

import com.secondproject.mypage.model.FollowCategoryDto;
import com.secondproject.mypage.model.FollowUserDto;

public interface MypageFollowDao {
	//favorite_category
	 int followCategoryMake(FollowCategoryDto followCategoryDto);
	 int followCategoryModify(FollowCategoryDto followCategoryDto);
	 int followCategoryDelete(int followCategoryId);
	 int followCategoryOrder(int followCategoryId,int category_order);
	 FollowCategoryDto getFollowCategory(int followCategoryId);
	 FollowCategoryDto getCategoryId(int userId,int category_order);
	 int upOrder(int followCategoryId);
	 int downOrder(int followCategoryId);
	 List<FollowCategoryDto> followCategoryListView(int userId);
	 //favorite_user
	 FollowUserDto getFollow(int favoriteUserId);
	 List<FollowUserDto> followListView(int userId);
	 int followMove(Map<String,String> map);
	 int followDelete(int favoriteUserId);
	 int followModify(Map<String,String> map);
	 int followdelete(int followUserId);

	 
}

