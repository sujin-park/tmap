package com.secondproject.admin.dao;

import java.util.ArrayList;
import java.util.Map;

import com.secondproject.admin.model.OwnerConfirmDto;

public interface OwnerDao {
	public ArrayList<OwnerConfirmDto> getArticles(Map<String, Object> params);
	public ArrayList<OwnerConfirmDto> modifyArticles(String[] user_id, int ownerOk);

}
