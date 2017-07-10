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
		boolean isForword = false;
		
		if ("writeForm".equals(act)) {
			path = ReviewFactory.getReviewWriteFormAction().execute(request, response);
			isForword = true;
		} else if ("modifyForm".equals(act)) {
			path = ReviewFactory.getReviewModifyFormAction().execute(request, response);
			isForword = true;
		} else if ("view".equals(act)) {
			path = ReviewFactory.getReviewViewAction().execute(request, response);
			isForword = true;
		} else if ("delete".equals(act)) {
			path = ReviewFactory.getReviewDeleteAction().execute(request, response);
		}
		
		if (isForword) {
			PageMove.forward(path, request, response);
		} else {
			PageMove.redirect(path, request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}
