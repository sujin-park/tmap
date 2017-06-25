package com.secondproject.factory;

import com.secondproject.map.action.ShopListAction;
import com.secondproject.shop.action.ShopAddAction;
import com.secondproject.shop.action.ShopViewAction;

public class ShopFactory {
	
	private static ShopListAction shopListAction;
	private static ShopAddAction shopAddAction;
	private static ShopViewAction shopViewAction;
	
	static {
		shopListAction = new ShopListAction();
		shopAddAction = new ShopAddAction();
		shopViewAction = new ShopViewAction();
	}

	public static final ShopAddAction getShopAddAction() {
		return shopAddAction;
	}

	public static final ShopListAction getShopListAction() {
		return shopListAction;
	}

	public static final ShopViewAction getShopViewAction() {
		return shopViewAction;
	}

	

}
