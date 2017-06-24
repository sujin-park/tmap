package com.secondproject.admin.review.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.admin.service.ExhibitionServiceImpl;
import com.secondproject.factory.AdminFactory;

public class ReviewBlindAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/adminIndex.jsp";
		String[] exhibitions = request.getParameterValues("checkbox");
//		int seq = Integer.parseInt(request.getParameter("seq"));
		int cnt = ExhibitionServiceImpl.getExhibitionService().deleteExhibition(exhibitions);
		if (cnt!=0) {
			path = "/page/adminpage/expage/exhibition.jsp";
		} else 
			path = "/page/adminpage/expage/writeFail.jsp";
		
		return path;
	}

}
