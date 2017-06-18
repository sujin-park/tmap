package com.secondproject.map.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.factory.MapFactory;

@WebServlet("/map")
public class MapController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isAjax = false;
		String act = request.getParameter("act");
		if (act == null) {
			
		} else if ("ajaxGetShopList".equals(act)) {
			isAjax = true;
			String jsonData = MapFactory.shopListAction().execute(request, response);
			response.setContentType("text/html; charset=EUC-KR");
			response.getWriter().print(jsonData);
		}
		
		if (isAjax == false) {
			request.setAttribute("titleTagValue", "≈∏¿Ã∆≤");
			request.setAttribute("contentPath", "/page/map/map.jsp");
			request.setAttribute("addHeadPath", "/page/map/include/head.jsp");
			request.setAttribute("addBottomPath", "/page/map/include/bottom.jsp");
			RequestDispatcher dist = request.getRequestDispatcher("/template/default/default.jsp");
			dist.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}
}
