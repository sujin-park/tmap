package com.secondproject.admin.service;

import java.util.ArrayList;
import java.util.Map;

import com.secondproject.admin.dao.OwnerDaoImpl;
import com.secondproject.admin.model.OwnerConfirmDto;

public class OwnerServiceImpl implements OwnerService {

	private static OwnerService ownerService;

	static {
		ownerService = new OwnerServiceImpl();
	}
	
	private OwnerServiceImpl() {}
	
	public static OwnerService getOwnerService() {
		return ownerService;
	}

	
	@Override
	public ArrayList<OwnerConfirmDto> getArticles(Map<String, Object> params) {
		return OwnerDaoImpl.getOwnerDao().getArticles(params);
	}

	@Override
	public ArrayList<OwnerConfirmDto> modifyArticles(String[] user_id, int ownerOk) {
		return OwnerDaoImpl.getOwnerDao().modifyArticles(user_id, ownerOk);
	}

}
