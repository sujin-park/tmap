package com.secondproject.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.factory.MypageFactory;

@WebServlet("/mypage")
public class MyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path="/page/mypage/mypage.jsp";
		String act = request.getParameter("act");
		if("followCategoryListView".equals(act)) {
			path = MypageFactory.getMypageFollowCategoryListView().execute(request, response);
		} else if("".equals(act)) {
			
		} else if("".equals(act)) {
			
		} else if("".equals(act)) {
			
		} else if("".equals(act)) {
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
