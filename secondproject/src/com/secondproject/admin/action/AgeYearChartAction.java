package com.secondproject.admin.action;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.secondproject.action.Action;
import com.secondproject.admin.service.ChartServiceImpl;

public class AgeYearChartAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return ChartServiceImpl.getChartService().getAgeYearJSON();
	}
}
