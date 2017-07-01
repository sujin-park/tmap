package com.secondproject.admin.dao;

import java.util.ArrayList;
import java.util.Map;

import com.secondproject.userdto.UserDto;


public interface UserViewDao {
	ArrayList<UserDto> getArticles(Map<String, Object> params);

}
