package com.secondproject.joinlogin.service;

import java.util.HashMap;
import java.util.Map;

import com.secondproject.joinlogin.dao.LoginDao;
import com.secondproject.joinlogin.dao.LoginDaoImpl;
import com.secondproject.userdto.UserDto;

public class LoginServiceImpl implements LoginService {
	
	private static LoginService loginService;
	
	static {
		loginService = new LoginServiceImpl();
	}
	
	private LoginServiceImpl() {}

	public static LoginService getLoginService() {
		return loginService;
	}

	@Override
	public UserDto login(String email, String password) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("useremail", email);
		map.put("userpw", password);
		return LoginDaoImpl.getLoginDao().login(map);
	}

}
