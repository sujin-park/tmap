package com.secondproject.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.factory.ReviewFactory;
import com.secondproject.util.PageMove;

@WebServlet("/review")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String path = "";
		
		if ("writeForm".equals(act)) {
			path = ReviewFactory.getReviewWriteFormAction().execute(request, response);
		} else if ("modifyForm".equals(act)) {
			path = ReviewFactory.getReviewModifyFormAction().execute(request, response);
		} else if ("view".equals(act)) {
			path = ReviewFactory.getReviewViewAction().execute(request, response);
		} else if ("delete".equals(act)) {
			path = ReviewFactory.getReviewDeleteAction().execute(request, response);
		} else if ("goodbad".equals(act)) {
			String json = ReviewFactory.getReviewGoodBadAction().execute(request, response);
			response.setContentType("text/html; charset=EUC-KR");
			response.getWriter().print(json);
		}
		
		if (path.isEmpty() == false) {
			PageMove.forward(path, request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}
