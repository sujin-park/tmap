package com.secondproject.admin.service;

import java.util.ArrayList;

import com.secondproject.admin.model.ShopInfoDto;


public interface ShopInfoService {
	ArrayList<ShopInfoDto> getArticles (String keyword, String type, String userOrder, String column);

}
