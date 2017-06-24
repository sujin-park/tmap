package com.secondproject.admin.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.admin.model.ExhibitionDetailDto;
import com.secondproject.admin.model.ExhibitionDto;
import com.secondproject.admin.service.CommonServiceImpl;
import com.secondproject.admin.service.ExhibitionServiceImpl;
import com.secondproject.util.*;

public class ExhibitionListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/adminIndex.jsp";
		int pg = NumberCheck.nullToOne(request.getParameter("pg")); 
		String key = Encoding.nullToBlank(request.getParameter("key"));
		String word = Encoding.isoToEuc(request.getParameter("word"));
		String order = Encoding.nullToBlank(request.getParameter("order"));
		String column = Encoding.nullToBlank(request.getParameter("column"));
		System.out.println(order);
		System.out.println(column);

		if (order.isEmpty() || order.equals("desc")) {
			order = "asc";
		} else if ("asc".equals(order)) {
			order = "desc";
		}

		List<ExhibitionDto> list = ExhibitionServiceImpl.getExhibitionService().listExhibition(key, word, order,
				column, pg);
		request.setAttribute("order", order);
		request.setAttribute("exhibitionList", list);
		
		PageNavigation pageNavigation = CommonServiceImpl.getCommonService().makePageNavigation(pg, key, word);
		// root는 여기서 가져옴
		pageNavigation.setRoot(request.getContextPath());
		pageNavigation.setNavigator();
		request.setAttribute("navigator", pageNavigation);
		path = "/page/adminpage/expage/exhibition.jsp";
		return path;
	}

}