package com.secondproject.admin.service;

import java.util.ArrayList;
import java.util.Map;

import com.secondproject.admin.dao.ShopInfoDaoImpl;
import com.secondproject.admin.model.ShopInfoDto;

public class ShopInfoServiceImpl implements ShopInfoService {

	private static ShopInfoService shopInfoService;

	static {
		shopInfoService = new ShopInfoServiceImpl();
	}

	private ShopInfoServiceImpl() {
	}

	public static ShopInfoService getShopInfoService() {
		return shopInfoService;
	}

	@Override
	public ArrayList<ShopInfoDto> getArticles(Map<String,Object> params) {
		return ShopInfoDaoImpl.getShopInfoDao().getArticles(params);
	}

	@Override
	public int deleteUsers(String[] users) {
		return ShopInfoDaoImpl.getShopInfoDao().deleteUsers(users);

	}

	@Override
	public ShopInfoDto viewShopInfomation(int shopseq) {
		return ShopInfoDaoImpl.getShopInfoDao().viewShopInfomation(shopseq);
	}

}
