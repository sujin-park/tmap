package com.secondproject.joinlogin.service;

import com.secondproject.userdto.UserDto;

public interface JoinService {
	UserDto attest(String email, String password, String age, String gender);
	int idCheck(String id);
}
