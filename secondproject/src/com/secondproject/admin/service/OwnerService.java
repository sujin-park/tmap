package com.secondproject.admin.service;

import java.util.ArrayList;
import java.util.Map;

import com.secondproject.admin.model.OwnerConfirmDto;



public interface OwnerService {
	ArrayList<OwnerConfirmDto> getArticles (Map<String, Object> params);
	ArrayList<OwnerConfirmDto> modifyArticles(String[] user_id, int ownerOk);

}
