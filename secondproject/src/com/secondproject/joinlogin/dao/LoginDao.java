package com.secondproject.joinlogin.dao;

import java.util.Map;

import com.secondproject.userdto.UserDto;

public interface LoginDao {
	UserDto login(Map<String, String> map);
}
