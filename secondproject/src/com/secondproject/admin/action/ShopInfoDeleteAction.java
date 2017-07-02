package com.secondproject.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.admin.service.ShopInfoServiceImpl;

public class ShopInfoDeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/admin?act=shopinfo";
		String[] users = request.getParameterValues("checkRow");
		int cnt = ShopInfoServiceImpl.getShopInfoService().deleteUsers(users);
		return path;
	}

}
