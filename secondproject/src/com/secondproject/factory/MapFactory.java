package com.secondproject.factory;

import com.secondproject.action.Action;
import com.secondproject.map.action.ShopListAction;

public class MapFactory {

	private static Action shopListAction;

	static {
		shopListAction = new ShopListAction();
	}

	public static Action shopListAction() {
		return shopListAction;
	}

}
