package com.secondproject.map.service;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.secondproject.map.dao.MapDaoImpl;
import com.secondproject.map.model.FollowCategoryDto;
import com.secondproject.map.model.ShopDto;
import com.secondproject.shop.model.ShopCategoryDto;
import com.secondproject.util.map.Bounds;

public class MapServiceImpl implements MapService {

	private static MapService mapService;

	static {
		mapService = new MapServiceImpl();
	}

	private MapServiceImpl() {}

	public static MapService getMapService() {
		return mapService;
	}

	@Override
	public ArrayList<ShopDto> getShopList(Bounds bounds, int categoryId, List<Integer> followUsers) {
		return MapDaoImpl.getMapDao().getShopList(bounds, categoryId, followUsers);
	}

	@Override
	public ArrayList<ShopDto> getShopListByFollowUsers(Bounds bounds, int categoryId, List<Integer> followUsers) {
		return MapDaoImpl.getMapDao().getShopListByFollowUsers(bounds, categoryId, followUsers);
	}

	@Override
	public String getShopListJSON(Bounds bounds, int categoryId, List<Integer> followUsers) {
		return new Gson().toJson(getShopList(bounds, categoryId, followUsers));
	}

	@Override
	public String getShopListByFollowUsersJSON(Bounds bounds, int categoryId, List<Integer> followUsers) {
		return new Gson().toJson(getShopListByFollowUsers(bounds, categoryId, followUsers));
	}

/*	
	@Override
	public ArrayList<FollowCategoryDto> getFollowListByUser(int userId) {
		return MapDaoImpl.getMapDao().getFollowListByUser(userId);
	}
*/
	
	@Override
	public ArrayList<Integer> getAllFolloewUserId(int userId) {
		return MapDaoImpl.getMapDao().getAllFolloewUserId(userId);
	}

	@Override
	public ArrayList<ShopCategoryDto> getShopCategory() {
		return MapDaoImpl.getMapDao().getShopCategory();
	}

	@Override
	public ArrayList<FollowCategoryDto> getFollowList(Bounds bounds, int userId, int categoryId) {
		return MapDaoImpl.getMapDao().getFollowList(bounds, userId, categoryId);
	}

	@Override
	public String getFollowListJSON(Bounds bounds, int userId, int categoryId) {
		return new Gson().toJson(getFollowList(bounds, userId, categoryId));
	}

}
