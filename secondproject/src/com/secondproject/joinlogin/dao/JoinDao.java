package com.secondproject.joinlogin.dao;

import com.secondproject.userdto.UserDto;

public interface JoinDao {
	int join(UserDto userDto);
	int idCheck(String id);
}
