package com.secondproject.map.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;
import com.secondproject.map.dao.MapDaoImpl;
import com.secondproject.map.model.ShopDto;
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
	public ArrayList<ShopDto> getShopList(Bounds bounds) {
		return MapDaoImpl.getMapDao().getShopList(bounds);
	}

	@Override
	public String getShopListJSON(Bounds bounds) {
		return new Gson().toJson(getShopList(bounds));
	}

}
