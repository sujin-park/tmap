package com.secondproject.admin.service;

import java.util.ArrayList;

import com.secondproject.userdto.UserDto;


public interface UserViewService {
	ArrayList<UserDto> getArticles (String keyword, String type, String userOrder, String column);

}
