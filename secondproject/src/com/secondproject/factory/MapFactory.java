package com.secondproject.factory;

import com.secondproject.action.Action;
import com.secondproject.map.action.CategoryListAction;
import com.secondproject.map.action.ShopListAction;

public class MapFactory {

	private static Action shopListAction;
	private static Action categoryListAction;

	static {
		shopListAction = new ShopListAction();
		categoryListAction = new CategoryListAction();
	}

	public static Action getShopListAction() {
		return shopListAction;
	}

	public static Action getCategoryListAction() {
		return categoryListAction;
	}

	
	
}
