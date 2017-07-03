package com.secondproject.shop.service;

import com.secondproject.shop.model.ShopDto;

public interface ShopService {
	
	int addShop(ShopDto shopDto);
	
	String addShopAjax(ShopDto shopDto);
	
	ShopDto getShop(int shopId);
	
	int getShopScore(int shopId);
}
