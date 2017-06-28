package com.secondproject.review.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.review.model.ReviewDto;
import com.secondproject.review.service.ReviewService;
import com.secondproject.review.service.ReviewServiceImpl;
import com.secondproject.util.NumberCheck;

public class ReviewViewAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "";
		int reviewId = NumberCheck.nullToZero(request.getParameter("reviewId"));
		ReviewDto reviewDto = ReviewServiceImpl.getReviewService().getReview(reviewId);
		request.setAttribute("reviewDto", reviewDto);
		if (reviewDto == null) {
			path = "";
		} else {
			path = "/page/review/view.jsp";
		}
		
		return path;
	}

}
