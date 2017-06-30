package com.secondproject.admin.service;

import java.util.ArrayList;

import com.secondproject.admin.dao.ShopInfoDaoImpl;
import com.secondproject.admin.model.ShopInfoDto;

public class ShopInfoServiceImpl implements ShopInfoService {

	private static ShopInfoService shopInfoService;

	static {
		shopInfoService = new ShopInfoServiceImpl();
	}
	
	private ShopInfoServiceImpl(){}
		
	public static ShopInfoService getShopInfoService() {
		return shopInfoService;
	}

	
	
	
	@Override
	public ArrayList<ShopInfoDto> getArticles(String keyword, String type, String userOrder, String column) {
		return ShopInfoDaoImpl.getShopInfoDao().getArticles(keyword,type,userOrder,column);
	}

}
