package com.secondproject.factory;

import com.secondproject.action.Action;
import com.secondproject.joinlogin.action.IdCheckAction;
import com.secondproject.joinlogin.action.JoinAction;
import com.secondproject.joinlogin.action.LoginAction;

public class JoinLoginFactory {
	private static Action loginAction;
	private static Action joinAction;
	private static Action idCheckAction;
	
	static {
		loginAction = new LoginAction();
		joinAction = new JoinAction();
		idCheckAction = new IdCheckAction();
	}

	public static Action getIdCheckAction() {
		return idCheckAction;
	}

	public static Action getLoginAction() {
		return loginAction;
	}

	public static Action getJoinAction() {
		return joinAction;
	}
	
	

}
