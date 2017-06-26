package com.secondproject.review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.factory.ReviewFactory;
import com.secondproject.factory.ShopFactory;
import com.secondproject.util.PageMove;

@WebServlet("/review")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		
		if ("writeForm".equals(act)) {
			String contentPath = "/page/review/write.jsp";
			request.setAttribute("titleTagValue", "TMAP - ∏Æ∫‰¿€º∫");
			request.setAttribute("contentPath", contentPath);
			request.setAttribute("addHeadPath", "/page/review/include/head.jsp");
			request.setAttribute("addBottomPath", "/page/review/include/bottom.jsp");
			PageMove.forward("/template/default/default.jsp", request, response);
		} else if ("write".equals(act)) {
			ReviewFactory.getReviewWriteAction().execute(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
