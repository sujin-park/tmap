package com.secondproject.admin.service;

import java.util.ArrayList;
import java.util.Map;

import com.secondproject.admin.dao.UserViewDaoImpl;
import com.secondproject.userdto.UserDto;

public class UserViewServiceImpl implements UserViewService {

	private static UserViewService userViewService;
	
	static {
		userViewService = new UserViewServiceImpl();
	}
	
	private UserViewServiceImpl(){}
	
	public static UserViewService getUserViewService() {
		return userViewService;
	}
	
	
	@Override
	public ArrayList<UserDto> getArticles(Map<String, Object> params) {
		return UserViewDaoImpl.getUserViewDao().getArticles(params);
	}

}
