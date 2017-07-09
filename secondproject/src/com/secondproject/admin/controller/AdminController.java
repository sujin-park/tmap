package com.secondproject.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.secondproject.factory.AdminFactory;
import com.secondproject.util.*;

@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/index.jsp";
		String contentPath = "";
		String act = request.getParameter("act");
		String board = request.getParameter("board");
		String addBottomPath = "/page/adminpage/include/bottom_exhibition.jsp";
		if ("mvexhibition".equals(act)) {
			path = "/template/admin/admin.jsp";
			contentPath = AdminFactory.getExhibitionListAction().execute(request, response);
		} else if ("mvmember".equals(act)) {
			path = "/template/admin/admin.jsp";
			contentPath = "/page/adminpage/member/member.jsp";
		} else if ("mvreview".equals(act)) {
			path = "/template/admin/admin.jsp";
			contentPath = AdminFactory.getReviewListAction().execute(request, response);
		} else if ("userview".equals(act)) {
			path = "/template/admin/admin.jsp";
			contentPath = AdminFactory.getUserViewAction().execute(request, response);
		} else if ("userdelete".equals(act)) {
			path = "/admin?act=userview";
			contentPath = AdminFactory.getUserDeleteAction().execute(request, response);
		} else if ("ownerview".equals(act)) {
			path = "/template/admin/admin.jsp";
			contentPath = AdminFactory.getOwnerViewAction().execute(request, response);
		} else if ("ownermodify".equals(act)) {
			path = "/template/admin/admin.jsp";
			contentPath = AdminFactory.getOwnerModifyAction().execute(request, response);
		} else if ("realownerview".equals(act)) {
			path = "/template/admin/admin.jsp";
			contentPath = AdminFactory.getOwnerViewAction().execute(request, response);
		} else if ("shopinfo".equals(act)) {
			path = "/template/admin/admin.jsp";
			addBottomPath = "/page/adminpage/include/adminmap.jsp";
			contentPath = AdminFactory.getShopInfoAction().execute(request, response);
		} else if ("shopdelete".equals(act)) {
			path = "/admin?act=shopinfo";
			contentPath = AdminFactory.getUserDeleteAction().execute(request, response);
		} else if ("mvstats".equals(act)) {
			path = "/template/admin/admin.jsp";
			contentPath = "/page/adminpage/statistics/ageStats.jsp";
		}
		request.setAttribute("titleTagValue", "≈∏¿Ã∆≤");
		request.setAttribute("contentPath", contentPath);
		request.setAttribute("addHeadPath", "/template/admin/include/head.jsp");
		request.setAttribute("addBottomPath", addBottomPath);
		PageMove.forward(path, request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}
