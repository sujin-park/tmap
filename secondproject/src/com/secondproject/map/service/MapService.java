package com.secondproject.map.service;

import java.util.ArrayList;
import java.util.List;

import com.secondproject.map.model.FollowCategoryDto;
import com.secondproject.map.model.ShopDto;
import com.secondproject.shop.model.ShopCategoryDto;
import com.secondproject.util.map.Bounds;

public interface MapService {

	ArrayList<ShopDto> getShopList(Bounds bounds, int categoryId, List<Integer> followUsers);

	ArrayList<ShopDto> getShopListByFollowUsers(Bounds bounds, int categoryId, List<Integer> followUsers);

	String getShopListJSON(Bounds bounds, int categoryId, List<Integer> followUsers);

	String getShopListByFollowUsersJSON(Bounds bounds, int categoryId, List<Integer> followUsers);

	//ArrayList<FollowCategoryDto> getFollowListByUser(int userId);

	ArrayList<FollowCategoryDto> getFollowList(Bounds bounds, int userId, int categoryId);
	
	String getFollowListJSON(Bounds bounds, int userId, int categoryId);
	
	ArrayList<Integer> getAllFolloewUserId(int userId);

	
	
	ArrayList<ShopCategoryDto> getShopCategory();

}
