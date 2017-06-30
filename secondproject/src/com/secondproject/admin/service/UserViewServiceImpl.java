package com.secondproject.admin.service;

import java.util.ArrayList;

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
	public ArrayList<UserDto> getArticles(String keyword, String type, String userOrder, String column) {
		return UserViewDaoImpl.getUserViewDao().getArticles(keyword,type,userOrder,column);
	}

}
