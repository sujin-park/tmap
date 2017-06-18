package com.secondproject.map.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.secondproject.map.model.ShopDto;

public interface MapDao {
	
	ArrayList<ShopDto> getShopList();

	ArrayList<HashMap<String, Object>> getShopHashMapList();
	
}
