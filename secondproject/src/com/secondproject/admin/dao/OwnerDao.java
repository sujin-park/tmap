package com.secondproject.admin.dao;

import java.util.ArrayList;

import com.secondproject.admin.model.OwnerConfirmDto;

public interface OwnerDao {
	public ArrayList<OwnerConfirmDto> getArticles(String keyword, String type, String userOrder, String column, int confirm_ok);
	public ArrayList<OwnerConfirmDto> modifyArticles(String[] user_id, int ownerOk);

}
