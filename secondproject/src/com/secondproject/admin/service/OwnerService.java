package com.secondproject.admin.service;

import java.util.ArrayList;

import com.secondproject.admin.model.OwnerConfirmDto;



public interface OwnerService {
	ArrayList<OwnerConfirmDto> getArticles (String keyword, String type, String userOrder, String column, int confirm_ok);
	ArrayList<OwnerConfirmDto> modifyArticles(String[] user_id, int ownerOk);

}
