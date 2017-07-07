package com.secondproject.map.service;

import java.util.ArrayList;

import com.secondproject.map.model.FollowCategoryDto;
import com.secondproject.map.model.FollowCategoryUserDto;
import com.secondproject.map.model.ShopDto;
import com.secondproject.util.map.Bounds;

public interface MapService {

	ArrayList<ShopDto> getShopList(Bounds bounds);

	String getShopListJSON(Bounds bounds);

	ArrayList<FollowCategoryDto> getCategoryByUser(int userId);

}
