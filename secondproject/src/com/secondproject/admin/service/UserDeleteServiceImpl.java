package com.secondproject.admin.service;

import com.secondproject.admin.dao.UserDeleteDaoImpl;

public class UserDeleteServiceImpl implements UserDeleteService {

private static UserDeleteService userDeleteService;
	
	static {
		userDeleteService = new UserDeleteServiceImpl();
	}
	
	private UserDeleteServiceImpl(){}
	
	public static UserDeleteService getUserDeleteService() {
		return userDeleteService;
	}
	
	
	
	@Override
	public int deleteUsers(String[] users) {
		// TODO Auto-generated method stub
		return UserDeleteDaoImpl.getUserDeleteDao().deleteUsers(users);
	}
	
	
}
