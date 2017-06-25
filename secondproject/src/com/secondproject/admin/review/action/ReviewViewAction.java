package com.secondproject.admin.review.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.admin.service.AdminReviewServiceImpl;
import com.secondproject.review.model.AdminReviewDto;
import com.secondproject.util.NumberCheck;

public class ReviewViewAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int seq = NumberCheck.nullToZero(request.getParameter("seq"));
		String path = "/adminIndex.jsp";
		
		AdminReviewDto adminReviewDto = AdminReviewServiceImpl.getAdminReviewService().viewReview(seq);
		if (adminReviewDto != null) {
			request.setAttribute("reviewInfo", adminReviewDto);
			path = "/page/adminpage/include/modal.jsp";
		}
		return path;
	}

}