package com.secondproject.factory;

import com.secondproject.action.Action;
import com.secondproject.map.action.ShopListAction;
import com.secondproject.shop.action.ShopAddAction;
import com.secondproject.shop.action.ShopViewAction;

public class ShopFactory {
	
	private static Action shopListAction;
	private static Action shopAddAction;
	private static Action shopViewAction;
	
	static {
		shopListAction = new ShopListAction();
		shopAddAction = new ShopAddAction();
		shopViewAction = new ShopViewAction();
	}

	public static final Action getShopAddAction() {
		return shopAddAction;
	}

	public static final Action getShopListAction() {
		return shopListAction;
	}

	public static final Action getShopViewAction() {
		return shopViewAction;
	}

	

}
