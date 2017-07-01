package com.secondproject.admin.service;

import java.util.ArrayList;
import java.util.Map;

import com.secondproject.userdto.UserDto;


public interface UserViewService {
	ArrayList<UserDto> getArticles (Map<String, Object> params);

}
