package com.secondproject.admin.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.admin.model.ExhibitionDetailDto;
import com.secondproject.admin.service.ExhibitionServiceImpl;
import com.secondproject.util.NumberCheck;

public class ExhibitionShopUpAction implements Action {

	// 매장추가하는 액션
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/adminIndex.jsp"; 
		int seq = NumberCheck.nullToZero(request.getParameter("seq"));
		String[] shops = request.getParameterValues("checkbox");
		int size = shops.length;
		ExhibitionDetailDto exhibitionDetailDto = new ExhibitionDetailDto();
		int cnt = ExhibitionServiceImpl.getExhibitionService().plusExhibition(shops, seq);
		if (cnt !=0) {
			path = "/page/adminpage/expage/writeOk.jsp";
		} else {
			path = "/page/adminpage/expage/writeFail.jsp";
		}
		return path;
	}

}
