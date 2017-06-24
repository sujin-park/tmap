package com.secondproject.factory;

import com.secondproject.map.action.ShopListAction;
import com.secondproject.shop.action.ShopAddAction;

public class ShopFactory {
	
	private static ShopListAction shopListAction;
	private static ShopAddAction shopAddAction;
	static {
		shopListAction = new ShopListAction();
		shopAddAction = new ShopAddAction();
	}

	public static ShopListAction shopListAction() {
		return shopListAction;
	}

	public static final ShopAddAction getShopAddAction() {
		return shopAddAction;
	}

	

}
