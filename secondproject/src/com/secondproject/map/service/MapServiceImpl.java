package com.secondproject.map.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.secondproject.map.dao.MapDaoImpl;
import com.secondproject.map.model.ShopDto;

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
	public ArrayList<ShopDto> getShopList() {
		return MapDaoImpl.getMapDao().getShopList();
	}

	@Override
	public String getShopListInJsonString() {
		ArrayList<HashMap<String, Object>> list = MapDaoImpl.getMapDao().getShopHashMapList();
		JSONArray returnList = new JSONArray();
		
		for (HashMap shop : list) {
			returnList.add(new JSONObject(shop));
		}
		
		return returnList.toJSONString();
	}

}
