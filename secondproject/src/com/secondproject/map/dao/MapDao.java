package com.secondproject.map.dao;

import java.util.ArrayList;
import java.util.List;

import com.secondproject.map.model.FollowCategoryDto;
import com.secondproject.map.model.FollowCategoryUserDto;
import com.secondproject.map.model.ShopDto;
import com.secondproject.shop.model.ShopCategoryDto;
import com.secondproject.util.map.Bounds;

public interface MapDao {

	ArrayList<ShopDto> getShopList(Bounds bounds, int categoryId, List<Integer> followUsers);

	ArrayList<ShopDto> getShopListByFollowUsers(Bounds bounds, int categoryId, List<Integer> followUsers);
	
	
	//ArrayList<FollowCategoryDto> getFollowListByUser(int userId);

	ArrayList<FollowCategoryUserDto> getFollowUsers(Bounds bounds, int followCategoryId, int categoryId);
	
	
	
	ArrayList<Integer> getAllFolloewUserId(int userId);
	
	ArrayList<FollowCategoryDto> getFollowList(Bounds bounds, int userId, int categoryId);
	
	ArrayList<ShopCategoryDto> getShopCategory();
	
}
