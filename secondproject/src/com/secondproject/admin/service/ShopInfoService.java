package com.secondproject.admin.service;

import java.util.ArrayList;
import java.util.Map;

import com.secondproject.admin.model.ShopInfoDto;


public interface ShopInfoService {
	ArrayList<ShopInfoDto> getArticles (Map<String,Object> params);
	int deleteUsers(String[] users);
}
