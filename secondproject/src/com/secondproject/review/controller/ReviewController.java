package com.secondproject.review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.factory.*;
import com.secondproject.util.Encoding;
import com.secondproject.util.PageMove;

@WebServlet("/review")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String path = "/index.jsp";
		String contentPath = "";
		String key = Encoding.nullToBlank(request.getParameter("key"));
		String word = request.getParameter("word");
		String order = Encoding.nullToBlank(request.getParameter("order"));
		String column = Encoding.nullToBlank(request.getParameter("column"));
		String queryString = "?key=" + key + "&word=" + Encoding.urlFormat(word) + "&order=" + order + "&column=" + column;
		if ("writeForm".equals(act)) {
			request.setAttribute("titleTagValue", "TMAP - 리뷰작성");
			request.setAttribute("contentPath", "/page/review/write.jsp");
			request.setAttribute("addHeadPath", "/page/review/include/head.jsp");
			request.setAttribute("addBottomPath", "/page/review/include/bottom.jsp");
			PageMove.forward("/template/default/default.jsp", request, response);
		} else if ("write".equals(act)) {
			path = ReviewFactory.getReviewWriteAction().execute(request, response);
			PageMove.redirect(path, request, response);
		} else if ("view".equals(act)) {
			contentPath = ReviewFactory.getReviewViewAction().execute(request, response);
			request.setAttribute("titleTagValue", "타이틀");
			request.setAttribute("contentPath", contentPath);
			PageMove.forward("/template/default/default.jsp", request, response);
		} 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}
