package com.secondproject.admin.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.admin.service.CommonServiceImpl;
import com.secondproject.admin.service.ExhibitionServiceImpl;
import com.secondproject.constant.BoardConstant;
import com.secondproject.shop.model.ShopDto;
import com.secondproject.util.*;

public class ExhibitionShopAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/adminIndex.jsp";
		
		int pg = NumberCheck.nullToOne(request.getParameter("pg"));
		String key = Encoding.nullToBlank(request.getParameter("key"));
		String word = Encoding.isoToEuc(request.getParameter("word"));
		String order = Encoding.nullToBlank(request.getParameter("order"));
		String column = Encoding.nullToBlank(request.getParameter("column"));
		String board = "shop";
		int seq = NumberCheck.nullToZero(request.getParameter("seq"));
		List<ShopDto> list = ExhibitionServiceImpl.getExhibitionService().shopExhibition(key, word, order, column);
		int size = list.size();
		
		PageNavigation pageNavigation = CommonServiceImpl.getCommonService().makePageNavigation(pg, key, word, board);
		// root는 여기서 가져옴
		pageNavigation.setRoot(request.getContextPath());
		pageNavigation.setPageSize(BoardConstant.PAGE_SIZE);
		pageNavigation.setListSize(BoardConstant.LIST_SIZE);
		pageNavigation.setNavigator();
		request.setAttribute("navigator", pageNavigation);
		if (size != 0) {
			request.setAttribute("exhibitionId", seq + "");
			request.setAttribute("exShopList", list);
			path = "/page/adminpage/expage/shopList.jsp";
		} 
		return path;
	}

}
