package com.secondproject.admin.service;

import com.secondproject.admin.dao.ShopInfoDeleteDaoImpl;

public class ShopInfoDeleteServiceImpl implements ShopInfoDeleteService {
	private static ShopInfoDeleteService shopInfoDeleteService;
	
	static {
		shopInfoDeleteService = new ShopInfoDeleteServiceImpl();
	}
	
	private ShopInfoDeleteServiceImpl(){}

	public static ShopInfoDeleteService getShopInfoDeleteService() {
		return shopInfoDeleteService;
	}

	@Override
	public int deleteUsers(String[] users) {
		return ShopInfoDeleteDaoImpl.getShopInfoDeleteDao().deleteUsers(users);

	}



}
