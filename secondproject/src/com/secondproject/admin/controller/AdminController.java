package com.secondproject.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.factory.AdminFactory;

@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
//		String act = "exhibition";
		String path = "/index.jsp";
		if ("mvexhibition".equals(act)) {
			path ="/template/admin/admin.jsp";
			String contentPath = AdminFactory.getExhibitionListAction().execute(request, response);
			request.setAttribute("titleTagValue", "타이틀");
			request.setAttribute("contentPath", "/adminpage/expage/exhibition.jsp");
			request.setAttribute("addHeadPath", "/template/admin/include/head.jsp");																																		 
			RequestDispatcher disp = request.getRequestDispatcher(path);
			disp.forward(request, response);
		} else if ("mvmember".equals(act)) {
			path ="/template/admin/admin.jsp";
			request.setAttribute("titleTagValue", "타이틀");
			request.setAttribute("contentPath", "/adminpage/member/member.jsp");
			request.setAttribute("addHeadPath", "/template/admin/include/head.jsp");																																		 
			RequestDispatcher disp = request.getRequestDispatcher(path);
			disp.forward(request, response);
			
		}
			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}
