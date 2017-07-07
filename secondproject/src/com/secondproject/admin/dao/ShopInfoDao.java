package com.secondproject.admin.dao;

import java.util.ArrayList;
import java.util.Map;

import com.secondproject.admin.model.ShopInfoDto;

public interface ShopInfoDao {
	ArrayList<ShopInfoDto> getArticles(Map<String,Object> params);
	int deleteUsers(String[] users);
	ShopInfoDto viewShopInfomation(int shopseq);
	int modifyShopInfo(ShopInfoDto shopInfoDto);
}
