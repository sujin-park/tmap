package com.secondproject.joinlogin.dao;

import java.util.Map;

import com.secondproject.userdto.UserDto;

public interface JoinDao {
	UserDto attest(Map<String, String> map);
	int idCheck(String id);
}
