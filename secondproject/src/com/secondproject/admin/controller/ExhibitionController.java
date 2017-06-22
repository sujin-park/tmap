package com.secondproject.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.util.*;
import com.secondproject.admin.action.ExhibitionWriteAction;
import com.secondproject.controller.PageMove;
import com.secondproject.factory.AdminFactory;


@WebServlet("/exhibition")
public class ExhibitionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String path = "/index.jsp";
		String contentPath = "";
		
		if ("mvwrite".equals(act)) {
			path ="/template/admin/admin.jsp";
			request.setAttribute("titleTagValue", "타이틀");
			request.setAttribute("contentPath", "/page/adminpage/expage/write.jsp");
			request.setAttribute("addHeadPath", "/template/admin/include/head.jsp");
			request.setAttribute("addBottomPath", "/page/adminpage/include/bottom_exhibition.jsp");
			
			PageMove.forward(path, request, response);
		} else if ("write".equals(act)) {
			contentPath = AdminFactory.getExhibitionWriteAction().execute(request, response);
			path ="/template/admin/admin.jsp";
			request.setAttribute("titleTagValue", "타이틀");
			request.setAttribute("contentPath", contentPath);
			request.setAttribute("addHeadPath", "/template/admin/include/head.jsp");
			request.setAttribute("addBottomPath", "/page/adminpage/include/bottom_exhibition.jsp");
			
			PageMove.forward(path, request, response);
		}else if ("view".equals(act)) {
			contentPath = AdminFactory.getExhibitionViewAction().execute(request, response);
			path = "/template/admin/admin.jsp";
			request.setAttribute("titleTagValue", "타이틀");
			request.setAttribute("contentPath", contentPath);
			request.setAttribute("addHeadPath", "/template/admin/include/head.jsp");
			request.setAttribute("addBottomPath", "/page/adminpage/include/bottom_exhibition.jsp");
			
			PageMove.forward(path, request, response);
		} else if ("mvshoplist".equals(act)) {
			contentPath = AdminFactory.getExhibitionShopAction().execute(request, response);
			path ="/template/admin/admin.jsp";
			request.setAttribute("titleTagValue", "타이틀");
			request.setAttribute("contentPath", contentPath);
			request.setAttribute("addHeadPath", "/template/admin/include/head.jsp");
			request.setAttribute("addBottomPath", "/page/adminpage/include/bottom_exhibition.jsp");
			
			PageMove.forward(path, request, response);
		} else if ("delete".equals(act)) {
			contentPath = AdminFactory.getExhibitionDeleteAction().execute(request, response);
			path ="/template/admin/admin.jsp";
			request.setAttribute("titleTagValue", "타이틀");
			request.setAttribute("contentPath", contentPath);
			request.setAttribute("addHeadPath", "/template/admin/include/head.jsp");
			request.setAttribute("addBottomPath", "/page/adminpage/include/bottom_exhibition.jsp");
			
			PageMove.forward(path, request, response);
		}
			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}