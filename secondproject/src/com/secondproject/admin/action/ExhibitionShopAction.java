package com.secondproject.admin.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.admin.model.ExhibitionDto;
import com.secondproject.admin.service.ExhibitionServiceImpl;
import com.secondproject.shop.model.ShopDto;

public class ExhibitionShopAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/adminIndex.jsp";
		List<ShopDto> list = ExhibitionServiceImpl.getExhibitionService().shopExhibition();
		int size = list.size();
		if (size != 0) {
			request.setAttribute("exShopList", list);
			path = "/page/adminpage/expage/shopList.jsp";
		} 
		return path;
	}

}
