package com.secondproject.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.secondproject.util.*;
import com.secondproject.factory.AdminFactory;
import com.secondproject.factory.MypageFactory;

@WebServlet("/exhibition")
public class ExhibitionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("act");
		String path = "/index.jsp";
		String contentPath = "";
		String url = "";

		int seq = NumberCheck.nullToZero(request.getParameter("seq"));
		if ("mvwrite".equals(act)) {
			path = "/template/admin/admin.jsp";
			contentPath = "/page/adminpage/expage/write.jsp";
		} else if ("write".equals(act)) {
			contentPath = AdminFactory.getExhibitionWriteAction().execute(request, response);
		} else if ("view".equals(act)) {
			contentPath = AdminFactory.getExhibitionViewAction().execute(request, response);
		} else if ("mvshoplist".equals(act)) {
			contentPath = AdminFactory.getExhibitionShopAction().execute(request, response);
		} else if ("delete".equals(act)) {
			contentPath = AdminFactory.getExhibitionDeleteAction().execute(request, response);
			url = "/admin?act=mvexhibition&board=exhibition";
		} else if ("plusshop".equals(act)) {
			contentPath = AdminFactory.getExhibitionShopUpAction().execute(request, response);
		} else if ("modify".equals(act)) {
			contentPath = AdminFactory.getExhibitionModifyAction().execute(request, response);
		} else if ("deleteShop".equals(act)) {
			contentPath = AdminFactory.getExhibitionDeleteShopAction().execute(request, response);
		}
		path = "/template/admin/admin.jsp";

		if ("delete".equals(act)) { // redirect 
			PageMove.redirect(url, request, response);
		} else { // ajax 
			if (contentPath.equals("/page/adminpage/expage/shopview.jsp")) {
				path = "/page/adminpage/expage/shopview.jsp";
			} // 기본
			request.setAttribute("titleTagValue", "타이틀");
			request.setAttribute("contentPath", contentPath);
			request.setAttribute("addHeadPath", "/template/admin/include/head.jsp");
			request.setAttribute("addBottomPath", "/page/adminpage/include/bottom_exhibition.jsp");
			PageMove.forward(path, request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}