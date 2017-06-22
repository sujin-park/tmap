package com.secondproject.factory;

import com.secondproject.map.action.ShopListAction;

public class MapFactory {

	private static ShopListAction shopListAction;

	static {
		shopListAction = new ShopListAction();
	}

	public static ShopListAction shopListAction() {
		return shopListAction;
	}

}
