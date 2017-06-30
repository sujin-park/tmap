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
import com.secondproject.util.NumberCheck;

public class ExhibitionModifyAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int seq = NumberCheck.nullToZero(request.getParameter("seq"));
		String path = "/adminIndex.jsp";
		ExhibitionDto exhibitionDto = new ExhibitionDto();
		exhibitionDto.setExhibitionId(seq);
		exhibitionDto.setExTitle(request.getParameter("subject"));
		exhibitionDto.setExDesc(request.getParameter("content"));
		exhibitionDto.setExVisiable(NumberCheck.nullToZero(request.getParameter("isvisiable")));
		exhibitionDto.setExImage(request.getParameter("eximage"));
		exhibitionDto.setExOrder(7);
		List<ShopDto> shoplist = ExhibitionServiceImpl.getExhibitionService().shopUpdated(seq);
		int cnt = ExhibitionServiceImpl.getExhibitionService().modifyExhibition(exhibitionDto);
		if (cnt != 0) {
			request.setAttribute("exhibitionInfo", exhibitionDto);
			request.setAttribute("shopList", shoplist);
			path = "/page/adminpage/expage/view.jsp";
		} else {
			path = "/page/adminpage/expage/writeFail.jsp";
		}
		return path;
	}

}
