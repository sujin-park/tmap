package com.secondproject.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyPageController
 */
@WebServlet("/mypage")
public class MyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("titleTagValue", "마이페이지");
		request.setAttribute("contentPath", "/page/mypage/mypage.jsp");
		request.setAttribute("addHeadPath", "/page/map/include/head.jsp");
		request.setAttribute("addBottomPath", "/page/map/include/bottom.jsp");
		RequestDispatcher dist = request.getRequestDispatcher("/template/default/default.jsp");
		dist.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
