package com.secondproject.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.factory.AdminFactory;
import com.secondproject.util.Encoding;
import com.secondproject.util.PageMove;


@WebServlet("/adminreview")
public class AdminReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String path = "/index.jsp";
		String contentPath = "";
		// key, word, order, column, pg 가지고 다녀야함
		
		if ("blind".equals(act)) {
			contentPath = AdminFactory.getReviewBlindAction().execute(request, response);
			String url = "/admin?act=mvreview";
			PageMove.redirect(url, request, response);
		} else if ("blindOne".equals(act)) {
			contentPath = AdminFactory.getReviewBlindOneAction().execute(request, response);
			request.setAttribute("titleTagValue", "타이틀");
			request.setAttribute("contentPath", contentPath);
			request.setAttribute("addHeadPath", "/template/admin/include/head.jsp");
			request.setAttribute("addBottomPath", "/page/adminpage/include/bottom_exhibition.jsp");
			
			PageMove.forward(contentPath, request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}
