package com.secondproject.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.factory.AdminFactory;
import com.secondproject.util.PageMove;

@WebServlet("/adminshop")
public class AdminShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/index.jsp";
		String contentPath = "";
		String act = request.getParameter("act");
		String addBottomPath = "/page/adminpage/include/adminmap.jsp";
		
		if ("showShopInfo".equals(act)) {
			contentPath = AdminFactory.getShopInfoViewAction().execute(request, response);
		} else if ("modify".equals(act)) {
			contentPath = AdminFactory.getShopInfoModifyAction().execute(request, response);
		}
		if (contentPath.equals("/page/adminpage/shop/shopInfoOne.jsp")) {
			path = contentPath;
		} else if (contentPath.equals("/page/adminpage/shop/shopInfoModify.jsp")) {
			path = contentPath;
		} else {
			path = "/template/admin/admin.jsp";
		}
			request.setAttribute("titleTagValue", "≈∏¿Ã∆≤");
			request.setAttribute("contentPath", contentPath);
			request.setAttribute("addHeadPath", "/template/admin/include/head.jsp");
			request.setAttribute("addBottomPath", addBottomPath);
			PageMove.forward(path, request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
