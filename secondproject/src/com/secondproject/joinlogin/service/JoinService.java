package com.secondproject.joinlogin.service;

import com.secondproject.userdto.UserDto;

public interface JoinService {
	int attest(String email, String password, String age, String gender);
	int idCheck(String id);
	UserDto lastcheck(String email, String checkkey);
}
