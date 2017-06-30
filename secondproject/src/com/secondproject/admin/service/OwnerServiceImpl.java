package com.secondproject.admin.service;

import java.util.ArrayList;

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
	public ArrayList<OwnerConfirmDto> getArticles(String keyword, String type, String userOrder, String column, int confirm_ok) {
		// TODO Auto-generated method stub
		return OwnerDaoImpl.getOwnerDao().getArticles(keyword, type, userOrder, column, confirm_ok);
	}

	@Override
	public ArrayList<OwnerConfirmDto> modifyArticles(String[] user_id, int ownerOk) {
		// TODO Auto-generated method stub
		return OwnerDaoImpl.getOwnerDao().modifyArticles(user_id, ownerOk);
	}

}
