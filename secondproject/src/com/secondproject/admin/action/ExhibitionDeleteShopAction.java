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

public class ExhibitionDeleteShopAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int exseq = Integer.parseInt(request.getParameter("exseq"));
		int shopseq = Integer.parseInt(request.getParameter("shopseq"));
		int cnt = ExhibitionServiceImpl.getExhibitionService().deleteShopList(exseq, shopseq);
		ExhibitionDto exhibitionDto = ExhibitionServiceImpl.getExhibitionService().viewExhibition(exseq);
		List<ShopDto> shoplist = ExhibitionServiceImpl.getExhibitionService().shopUpdated(exseq);
		String path = "";
		if (cnt != 0) {
			request.setAttribute("exhibitionInfo", exhibitionDto);
			request.setAttribute("shopList", shoplist);
			path = "/page/adminpage/expage/shopview.jsp";
		}
		return path;
	}

}
