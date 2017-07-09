package com.secondproject.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.factory.AdminFactory;
import com.secondproject.util.PageMove;

@WebServlet("/chart")
public class ChartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String jsonData = "";
		String path = "/template/admin/admin.jsp";
		String contentPath = "";
		if ("ageChart".equals(act)) {
			jsonData = AdminFactory.getAgeChartAction().execute(request, response);
			contentPath ="/page/adminpage/statistics/ageStats.jsp";
			response.setContentType("text/html; charset=EUC-KR");
			response.getWriter().print(jsonData);
			request.setAttribute("age", jsonData);
			
		} else if ("categoryChart".equals(act)) {
			jsonData = AdminFactory.getCategoryChartAction().execute(request, response);
			contentPath ="/page/adminpage/statistics/categoryStats.jsp";
			response.setContentType("text/html; charset=EUC-KR");
			response.getWriter().print(jsonData);
			request.setAttribute("category", jsonData);
			
		} else if ("areaChart".equals(act)) {
			jsonData = AdminFactory.getAreaChartAction().execute(request, response);
			response.setContentType("text/html; charset=EUC-KR");
			response.getWriter().print(jsonData);
			request.setAttribute("area", jsonData);
		}
			request.setAttribute("titleTagValue", "≈∏¿Ã∆≤");
			request.setAttribute("contentPath", contentPath);
			request.setAttribute("addHeadPath", "/template/admin/include/head.jsp");
			PageMove.forward(path, request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}
