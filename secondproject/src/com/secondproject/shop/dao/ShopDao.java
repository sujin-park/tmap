package com.secondproject.shop.dao;

import com.secondproject.shop.model.ShopDto;

public interface ShopDao {
	int addShop(ShopDto shopDto);
	
	ShopDto getShop(int shopId);
}
