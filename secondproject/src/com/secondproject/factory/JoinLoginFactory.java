package com.secondproject.factory;

import com.secondproject.action.Action;
import com.secondproject.joinlogin.action.AttestAction;
import com.secondproject.joinlogin.action.IdCheckAction;
import com.secondproject.joinlogin.action.LastCheckAction;
import com.secondproject.joinlogin.action.LoginAction;

public class JoinLoginFactory {
	private static Action loginAction;
	private static Action attestAction;
	private static Action idCheckAction;
	private static Action lastCheckAction;
	
	static {
		loginAction = new LoginAction();
		attestAction = new AttestAction();
		idCheckAction = new IdCheckAction();
		lastCheckAction = new LastCheckAction();
	}

	public static Action getLastCheckAction() {
		return lastCheckAction;
	}

	public static Action getIdCheckAction() {
		return idCheckAction;
	}

	public static Action getLoginAction() {
		return loginAction;
	}

	public static Action getAttestAction() {
		return attestAction;
	}
	
	

}
