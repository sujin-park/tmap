package com.secondproject.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.admin.service.ExhibitionServiceImpl;
import com.secondproject.factory.AdminFactory;

public class ExhibitionDeleteAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/adminIndex.jsp"; 
		int seq = Integer.parseInt(request.getParameter("seq"));
		int cnt = ExhibitionServiceImpl.getExhibitionService().deleteExhibition(seq);
		if (cnt!=0) {
			path = "/page/adminpage/expage/writeOk.jsp";
		} else 
			path = "/page/adminpage/expage/writeFail.jsp";
		return path;
	}

}
