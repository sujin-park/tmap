package com.secondproject.admin.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.admin.model.ExhibitionDetailDto;
import com.secondproject.admin.model.ExhibitionDto;
import com.secondproject.admin.service.ExhibitionServiceImpl;

public class ExhibitionListAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/adminIndex.jsp";
		List<ExhibitionDto> list = ExhibitionServiceImpl.getExhibitionService().listExhibition();
		int size = list.size();
		if (size != 0) {
			request.setAttribute("exhibitionList", list);
			path = "/adminpage/expage/exhibition";
		} 
		return path;
	}

}