package com.secondproject.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.secondproject.action.Action;
import com.secondproject.admin.service.ChartServiceImpl;
import com.secondproject.util.map.Bounds;

public class CategoryChartAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String number = new Gson().fromJson(request.getParameter("number"), String.class);
		return ChartServiceImpl.getChartService().getCategoryJSON(number);
	}

}
