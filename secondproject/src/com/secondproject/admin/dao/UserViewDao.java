package com.secondproject.admin.dao;

import java.util.ArrayList;

import com.secondproject.userdto.UserDto;


public interface UserViewDao {
	ArrayList<UserDto> getArticles(String keyword, String type, String userOrder, String column);

}
