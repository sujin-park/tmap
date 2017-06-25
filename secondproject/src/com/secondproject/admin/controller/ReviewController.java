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

@WebServlet("/review")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("act");
		String path = "/index.jsp";
		String contentPath = "";
		String key = Encoding.nullToBlank(request.getParameter("key"));
		String word = request.getParameter("word");
		String order = Encoding.nullToBlank(request.getParameter("order"));
		String column = Encoding.nullToBlank(request.getParameter("column"));
		String queryString = "?key=" + key + "&word=" + Encoding.urlFormat(word) + "&order=" + order + "&column="
				+ column;
		
		if ("view".equals(act)) {

			contentPath = AdminFactory.getReviewViewAction().execute(request, response);
			path = "/template/admin/admin.jsp";
			request.setAttribute("titleTagValue", "타이틀");
			request.setAttribute("contentPath", contentPath);
			request.setAttribute("addHeadPath", "/template/admin/include/head.jsp");
			request.setAttribute("addBottomPath", "/page/adminpage/include/bottom_exhibition.jsp");

			PageMove.forward(path, request, response);
		} else if ("blind".equals(act)) {
			contentPath = AdminFactory.getReviewBlindAction().execute(request, response);
			String url = "/admin?act=mvreview";
			// request.setAttribute("titleTagValue", "타이틀");
			// request.setAttribute("contentPath", contentPath);
			// request.setAttribute("addHeadPath",
			// "/template/admin/include/head.jsp");
			// request.setAttribute("addBottomPath",
			// "/page/adminpage/include/bottom_exhibition.jsp");

			PageMove.redirect(url, request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}