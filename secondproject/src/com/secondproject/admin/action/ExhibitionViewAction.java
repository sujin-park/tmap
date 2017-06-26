package com.secondproject.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.admin.model.ExhibitionDetailDto;
import com.secondproject.admin.service.ExhibitionServiceImpl;
import com.secondproject.util.NumberCheck;

public class ExhibitionViewAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int seq = NumberCheck.nullToZero(request.getParameter("seq"));
		String path = "/adminIndex.jsp";
		System.out.println("ViewAction  " + seq);
		ExhibitionDetailDto exhibitionDetailDto = ExhibitionServiceImpl.getExhibitionService().viewExhibition(seq);
//		System.out.println(">>>>>" + exhibitionDetailDto.getExhibitionId());
		if (exhibitionDetailDto != null) {
			request.setAttribute("exhibitionInfo", exhibitionDetailDto);
			path = "/page/adminpage/expage/view.jsp";
		}
		return path;
	}

}