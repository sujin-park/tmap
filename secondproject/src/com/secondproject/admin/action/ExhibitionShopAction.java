package com.secondproject.admin.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.admin.service.ExhibitionServiceImpl;
import com.secondproject.shop.model.ShopDto;
import com.secondproject.util.Encoding;
import com.secondproject.util.NumberCheck;

public class ExhibitionShopAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/adminIndex.jsp";
		String key = Encoding.nullToBlank(request.getParameter("key"));
		String word = Encoding.isoToEuc(request.getParameter("word"));
		String order = Encoding.nullToBlank(request.getParameter("order"));
		String column = Encoding.nullToBlank(request.getParameter("column"));
		int seq = NumberCheck.nullToZero(request.getParameter("seq"));
		List<ShopDto> list = ExhibitionServiceImpl.getExhibitionService().shopExhibition(key, word, order, column);
		int size = list.size();
		if (size != 0) {
			request.setAttribute("exhibitionId", seq + "");
			request.setAttribute("exShopList", list);
			path = "/page/adminpage/expage/shopList.jsp";
		} 
		return path;
	}

}
