package com.secondproject.mypage.service;

import java.util.List;
import java.util.Map;

import com.secondproject.mypage.model.FollowCategoryDto;
import com.secondproject.mypage.model.FollowUserDto;

public interface MypageService {
	 List<FollowCategoryDto> followCategoryListView(Map<String,String> map);
	 List<FollowUserDto> followListView(Map<String,String> map);
	 int upOrder(int followCategoryId);
	 int downOrder(int followCategoryId);
	 int followCategoryMake(FollowCategoryDto followCategoryDto);
	 int followdelete(int followUserId);
	 int followCategoryDelete(int followCategoryId);
	 int followModify(FollowUserDto fudto);
	 int followCategoryModify(int cateId,int seq);
	 
}
