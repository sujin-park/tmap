package com.secondproject.factory;

import com.secondproject.action.Action;
import com.secondproject.main.action.MainListAction;

public class MainFactory {
	private static Action mainListAction;

	static {
		mainListAction = new MainListAction();
	}
	
	public static Action getMainListAction() {
		return mainListAction;
	}
}
