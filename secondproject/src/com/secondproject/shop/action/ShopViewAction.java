package com.secondproject.shop.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.shop.model.ShopDto;
import com.secondproject.shop.service.ShopServiceImpl;
import com.secondproject.util.NumberCheck;

public class ShopViewAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int shopId = NumberCheck.nullToZero(request.getParameter("shopId"));
		ShopDto shopDto = ShopServiceImpl.getShopService().getShop(shopId);
		request.setAttribute("shopDto", shopDto);
		return "/page/shop/shop.jsp";
	}

}
