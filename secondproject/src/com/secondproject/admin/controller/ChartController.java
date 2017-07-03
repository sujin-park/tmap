package com.secondproject.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.factory.AdminFactory;

@WebServlet("/chart")
public class ChartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String jsonData = "";
		
		if ("ageChart".equals(act)) {
			jsonData = AdminFactory.getAgeChartAction().execute(request, response);
			response.setContentType("text/html; charstet=EUC-KR");
			response.getWriter().print(jsonData);
		} else if ("categoryChart".equals(act)) {
			jsonData = AdminFactory.getCategoryChartAction().execute(request, response);
			response.setContentType("text/html; charset=EUC-KR");
			response.getWriter().print(jsonData);
		} else if ("areaChart".equals(act)) {
			jsonData = AdminFactory.getAreaChartAction().execute(request, response);
			response.setContentType("text/html; charset=EUC-KR");
			response.getWriter().print(jsonData);
			
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}
