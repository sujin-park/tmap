package com.secondproject.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.admin.action.ExhibitionWriteAction;
import com.secondproject.factory.AdminFactory;


@WebServlet("/exhibition")
public class ExhibitionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String path = "/index.jsp";
		if ("mvwrite".equals(act)) {
			path ="/template/admin/admin.jsp";
			request.setAttribute("titleTagValue", "타이틀");
			request.setAttribute("contentPath", "/adminpage/expage/write.jsp");
			request.setAttribute("addHeadPath", "/template/admin/include/head.jsp");
//			request.setAttribute("addBottomPath", "/page/map/include/bottom.jsp");
			
			RequestDispatcher disp = request.getRequestDispatcher(path);
			disp.forward(request, response);
		} else if ("write".equals(act)) {
			System.out.println("제목 ㄱ " + request.getParameter("subject"));
			String contentPath = AdminFactory.getExhibitionWriteAction().execute(request, response);
			path ="/template/admin/admin.jsp";
			request.setAttribute("titleTagValue", "타이틀");
			request.setAttribute("contentPath", contentPath);
			request.setAttribute("addHeadPath", "/template/admin/include/head.jsp");
			
			RequestDispatcher disp = request.getRequestDispatcher(path);
			disp.forward(request, response);
		}
			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		System.out.println("제목 ㄱ 222" + request.getParameter("subject"));
		doGet(request, response);
	}

}