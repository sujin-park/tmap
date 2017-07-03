package com.secondproject.shop.service;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.secondproject.shop.dao.ShopDaoImpl;
import com.secondproject.shop.model.ShopDto;

public class ShopServiceImpl implements ShopService {

	private static ShopService shopService;
	
	static {
		shopService = new ShopServiceImpl();
	}
	
	private ShopServiceImpl(){}
	
	public static ShopService getShopService() {
		return shopService;
	}
	
	@Override
	public int addShop(ShopDto shopDto) {
		return ShopDaoImpl.getShopDao().addShop(shopDto);
	}

	@Override
	public String addShopAjax(ShopDto shopDto) {
		Map<String, String> json = new HashMap<String, String>();
		
		int isSuccess = addShop(shopDto);
		if (isSuccess == 1) {
			json.put("isSuccess", "success");
		} else {
			json.put("isSuccess", "fail");
		}
		
		return new Gson().toJson(json);
	}

	@Override
	public ShopDto getShop(int shopId) {
		return ShopDaoImpl.getShopDao().getShop(shopId);
	}

	@Override
	public int getShopScore(int shopId) {
		return ShopDaoImpl.getShopDao().getShopScore(shopId);
	}

}
