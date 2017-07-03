package com.secondproject.admin.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.admin.model.ExhibitionDto;
import com.secondproject.admin.model.ShopInfoDto;
import com.secondproject.admin.service.ExhibitionServiceImpl;
import com.secondproject.admin.service.ShopInfoServiceImpl;
import com.secondproject.shop.model.ShopDto;
import com.secondproject.util.NumberCheck;

public class ShopInfoViewAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int shopseq = Integer.parseInt(request.getParameter("shopseq"));
		ShopInfoDto shopInfoDto = ShopInfoServiceImpl.getShopInfoService().viewShopInfomation(shopseq);
		request.setAttribute("shopInfo", shopInfoDto);
		return "/page/adminpage/shop/shopInfoOne.jsp";
	}

}