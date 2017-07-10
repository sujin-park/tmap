package com.secondproject.user.dao;

import com.secondproject.userdto.UserDto;

public class UserDaoImpl implements UserDao {

	private static UserDao userDao;

	static {
		userDao = new UserDaoImpl();
	}

	public static UserDao getUserDao() {
		return userDao;
	}

	@Override
	public UserDto getUser(int userId) {
		return UserDaoImpl.getUserDao().getUser(userId);
	}

}
