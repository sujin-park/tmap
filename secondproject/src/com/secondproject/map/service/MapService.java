package com.secondproject.map.service;

import java.util.ArrayList;

import com.secondproject.map.model.ShopDto;
import com.secondproject.util.map.Bounds;

public interface MapService {
	ArrayList<ShopDto> getShopList(Bounds bounds);
	String getShopListJSON(Bounds bounds);
}
