package com.secondproject.factory;

import com.secondproject.action.Action;
import com.secondproject.joinlogin.action.JoinAction;

public class JoinLoginFactory {
	private static Action loginAction;
	private static Action joinAction;
	
	static {
		//loginAction = new loginAction();
		joinAction = new JoinAction();
	}

	public static Action getLoginAction() {
		return loginAction;
	}

	public static Action getJoinAction() {
		return joinAction;
	}
	
	

}
