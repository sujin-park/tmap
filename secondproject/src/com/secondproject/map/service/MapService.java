package com.secondproject.map.service;

import java.util.ArrayList;

import com.secondproject.map.model.ShopDto;

public interface MapService {
	ArrayList<ShopDto> getShopList();
	String getShopListInJsonString();
}
