package com.secondproject.admin.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.util.Encoding;
import com.secondproject.action.Action;
import com.secondproject.admin.model.ExhibitionDetailDto;
import com.secondproject.admin.model.ExhibitionDto;
import com.secondproject.admin.service.ExhibitionServiceImpl;

public class ExhibitionListAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/adminIndex.jsp";
		String key = Encoding.nullToBlank(request.getParameter("key"));
		String word = Encoding.isoToEuc(request.getParameter("word"));
		String order = Encoding.nullToBlank(request.getParameter("order"));
		String column = Encoding.nullToBlank(request.getParameter("column"));
		System.out.println(order);
		System.out.println(column);
		
		if (order.isEmpty() || order.equals("desc")) {
			order = "asc";
		} else if ("asc".equals(order)){
			order = "desc";
		}
		
		List<ExhibitionDto> list = ExhibitionServiceImpl.getExhibitionService().listExhibition(key, word, order, column);
		int size = list.size();
		if (size != 0) {
			request.setAttribute("order", order);
			request.setAttribute("exhibitionList", list);
			path = "/page/adminpage/expage/exhibition.jsp";
		} 
		return path;
	}

}