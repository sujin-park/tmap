package com.secondproject.map.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.secondproject.map.model.ShopDto;
import com.secondproject.util.map.Bounds;

public interface MapDao {
	
	ArrayList<ShopDto> getShopList(Bounds bounds);

}
