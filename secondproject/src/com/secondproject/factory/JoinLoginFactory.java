package com.secondproject.factory;

import com.secondproject.action.Action;
import com.secondproject.joinlogin.action.JoinAction;
import com.secondproject.joinlogin.action.LoginAction;

public class JoinLoginFactory {
	private static Action loginAction;
	private static Action joinAction;
	
	static {
		loginAction = new LoginAction();
		joinAction = new JoinAction();
	}

	public static Action getLoginAction() {
		return loginAction;
	}

	public static Action getJoinAction() {
		return joinAction;
	}
	
	

}
