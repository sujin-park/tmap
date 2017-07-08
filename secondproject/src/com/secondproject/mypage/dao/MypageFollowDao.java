package com.secondproject.mypage.dao;

import java.util.List;
import java.util.Map;

import com.secondproject.mypage.model.FollowCategoryDto;
import com.secondproject.mypage.model.FollowUserDto;
import com.secondproject.userdto.UserDto;

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
	 List<FollowCategoryDto> followCategoryListView(Map<String, Object> map);
	 //favorite_user
	 FollowUserDto getFollow(int favoriteUserId);
	 UserDto getUser(int userId);
	 List<FollowUserDto> followListView(Map<String, Object> map);
	 int followMove(Map<String,String> map);
	 int followDelete(int favoriteUserId);
	 int followModify(FollowUserDto fudto);
	 int followdelete(int followUserId);
	 int totalArticleCount(Map<String,String> map);
	 int followCategoryModify(int cateId,int seq);
	 int totalFollowUserCount(Map<String, Object> params);
	 List<FollowUserDto> followselect(Map<String, Object> params);
	 int followAdd(int followUserId,int userId);
	 int totalFollowSelect(Map<String, Object> params);
	 int selectfollowuser(int followUserId,int userId);
}

