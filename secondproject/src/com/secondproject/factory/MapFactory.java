package com.secondproject.factory;

import com.secondproject.action.Action;
import com.secondproject.map.action.FollowListAction;
import com.secondproject.map.action.ShopListAction;

public class MapFactory {

	private static Action shopListAction;
	private static Action followListAction;

	static {
		shopListAction = new ShopListAction();
		followListAction = new FollowListAction();
	}

	public static Action getShopListAction() {
		return shopListAction;
	}

	public static Action getFollowListAction() {
		return followListAction;
	}

	
	
}
