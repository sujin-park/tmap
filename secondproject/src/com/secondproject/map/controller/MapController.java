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
		String act = request.getParameter("act");
		if (act == null) {
			request.setAttribute("titleTagValue", "TMAP");
			request.setAttribute("contentPath", "/page/map/map.jsp");
			request.setAttribute("addHeadPath", "/page/map/include/head.jsp");
			request.setAttribute("addBottomPath", "/page/map/include/bottom.jsp");
			RequestDispatcher dist = request.getRequestDispatcher("/template/map/default.jsp");
			dist.forward(request, response);
		} else if ("ajaxGetShopList".equals(act)) {
			String jsonData = MapFactory.shopListAction().execute(request, response);
			response.setContentType("text/html; charset=EUC-KR");
			response.getWriter().print(jsonData);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}
}
