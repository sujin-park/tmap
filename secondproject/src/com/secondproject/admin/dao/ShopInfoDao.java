package com.secondproject.admin.dao;

import java.util.ArrayList;

import com.secondproject.admin.model.ShopInfoDto;

public interface ShopInfoDao {
	ArrayList<ShopInfoDto> getArticles(String keyword, String type, String userOrder, String column);

}
