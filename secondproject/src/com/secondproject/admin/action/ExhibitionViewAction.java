package com.secondproject.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.admin.model.ExhibitionDetailDto;
import com.secondproject.admin.service.ExhibitionServiceImpl;

public class ExhibitionViewAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		String path = "/adminIndex.jsp";
		ExhibitionDetailDto exhibitionDetailDto = ExhibitionServiceImpl.getExhibitionService().viewExhibition(seq);
		if (exhibitionDetailDto != null) {
			request.setAttribute("exhibitionInfo", exhibitionDetailDto);
			path = "/page/adminpage/expage/view.jsp";
		}
		return path;
	}

}