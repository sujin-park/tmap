package com.secondproject.joinlogin.service;

import com.secondproject.userdto.UserDto;

public interface LoginService {
	UserDto login(String email, String password);
}
