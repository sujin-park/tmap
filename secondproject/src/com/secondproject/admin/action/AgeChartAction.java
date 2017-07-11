package com.secondproject.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.secondproject.action.Action;
import com.secondproject.admin.service.ChartServiceImpl;

public class AgeChartAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String snum = request.getParameter("snum");
		String json = "";
		if (snum.equals("50") || snum.equals("0")) {
			json = ChartServiceImpl.getChartService().getAgeChartJSON(snum);
		} else {
			json = ChartServiceImpl.getChartService().getAgeMonthJSON(snum);
		}
		return json;
	}

}