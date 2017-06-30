package com.secondproject.admin.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.admin.model.ShopInfoDto;
import com.secondproject.admin.service.ShopInfoServiceImpl;
import com.secondproject.admin.service.UserViewServiceImpl;
import com.secondproject.util.Encoding;

public class ShopInfoAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String keyword = Encoding.isoToEuc(request.getParameter("keyword"));
		String type = request.getParameter("key_type");
		String shopInfoOrder = Encoding.nullToBlank(request.getParameter("shopInfoOrder"));
		String column = request.getParameter("column");
		
		//System.out.println("column == " + column);
		//System.out.println("userOrder == " + userOrder);

		if (shopInfoOrder.isEmpty()) {
			shopInfoOrder = "asc";
		}
		
		ArrayList<ShopInfoDto> list= ShopInfoServiceImpl.getShopInfoService().getArticles(keyword, type, shopInfoOrder, column);
		
	
		if (shopInfoOrder.equals("asc")) {
			shopInfoOrder = "desc";
		} else {
			shopInfoOrder = "asc";
		}
		request.setAttribute("shopInfoOrder", shopInfoOrder);
		request.setAttribute("list", list);
		return "/page/adminpage/shop/shopinfo.jsp";
	}

}
