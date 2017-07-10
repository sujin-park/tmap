package com.secondproject.user.dao;

import com.secondproject.userdto.UserDto;

public interface UserDao {
	UserDto getUser(int userId);
}
