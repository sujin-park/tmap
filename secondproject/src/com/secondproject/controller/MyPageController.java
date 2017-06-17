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
		String path="/page/mypage/mypage.jsp";
		String act = request.getParameter("act");
		if("modify".equals(act)) {
			path="/page/mypage/modify.jsp";
		} else if("write".equals(act)) {
			path="/page/mypage/write.jsp";
		} else if("view".equals(act)) {
			path="/page/mypage/view.jsp";
		} else if("follow".equals(act)) {
			path="/page/mypage/follow.jsp";
		} else if("management".equals(act)) {
			path="/page/mypage/management.jsp";
		} 
		request.setAttribute("titleTagValue", "마이페이지");
		request.setAttribute("contentPath", path);
		request.setAttribute("addHeadPath", "/page/mypage/include/head.jsp");
		request.setAttribute("addBottomPath", "/page/map/include/bottom.jsp");
		RequestDispatcher dist = request.getRequestDispatcher("/template/default/default.jsp");
		dist.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
