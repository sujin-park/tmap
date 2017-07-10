package com.secondproject.review.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.review.model.ReviewDto;
import com.secondproject.review.service.ReviewServiceImpl;
import com.secondproject.userdto.UserDto;
import com.secondproject.util.NumberCheck;
import com.secondproject.util.validation.LoginCheck;

public class ReviewModifyFormAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contentPath = "";
		boolean isLogin = LoginCheck.isLogin(request);
		UserDto loginUserDto = (UserDto) request.getSession().getAttribute("logininfo");
		
		int reviewId = NumberCheck.nullToZero(request.getParameter("reviewId"));

		ReviewDto reviewDto = ReviewServiceImpl.getReviewService().getReview(reviewId);
		
		if (isLogin && reviewId != 0 && reviewDto.getUserId() == loginUserDto.getUser_id()) {
			request.setAttribute("reviewDto", reviewDto);
			contentPath = "/page/review/write.jsp";
		} else if (isLogin == false) {
			contentPath = "/page/error/login.jsp";
		} else {
			contentPath = "/page/error/error.jsp";
		}
		
		request.setAttribute("titleTagValue", "이게진짜 리뷰수정");
		request.setAttribute("contentPath", contentPath);
		request.setAttribute("addHeadPath", "/page/review/include/head.jsp");
		request.setAttribute("addBottomPath", "/page/review/include/bottom.jsp");
		
		return "/template/default/default.jsp";
	}

}
