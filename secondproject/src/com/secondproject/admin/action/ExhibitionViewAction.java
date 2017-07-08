package com.secondproject.admin.action;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.admin.model.ExhibitionDetailDto;
import com.secondproject.admin.model.ExhibitionDto;
import com.secondproject.admin.service.ExhibitionServiceImpl;
import com.secondproject.shop.model.ShopDto;
import com.secondproject.util.NumberCheck;

public class ExhibitionViewAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int size = 0;
		int seq = NumberCheck.nullToZero(request.getParameter("seq"));
		String board = request.getParameter("board");
		String path = "/adminIndex.jsp";
		System.out.println("ViewAction  " + seq);
		ExhibitionDto exhibitionDto = ExhibitionServiceImpl.getExhibitionService().viewExhibition(seq);
		List<ShopDto> shoplist = ExhibitionServiceImpl.getExhibitionService().shopUpdated(seq);
		if (shoplist != null) {
			size = shoplist.size();
		}

		if (exhibitionDto != null) {
			request.setAttribute("exhibitionInfo", exhibitionDto);
			if (size != 0) {
				request.setAttribute("shopList", shoplist);
			}
			path = "/page/adminpage/expage/view.jsp";
		}
		return path;
	}

}