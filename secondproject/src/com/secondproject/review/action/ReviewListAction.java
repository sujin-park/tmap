package com.secondproject.review.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.review.model.ReviewDto;
import com.secondproject.review.service.ReviewServiceImple;
import com.secondproject.util.NumberCheck;

public class ReviewListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "";
		int shopId = NumberCheck.nullToZero(request.getParameter("shopId"));
		//int userId = NumberCheck.nullToZero(request.getParameter("userId"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int score = Integer.parseInt(request.getParameter("score"));
		
		ReviewDto reviewDto = new ReviewDto();
		reviewDto.setShopId(shopId);
		reviewDto.setUserId(1);
		reviewDto.setTitle(title);
		reviewDto.setContent(content);
		reviewDto.setScore(score);
		int isSuccess = ReviewServiceImple.getReviewService().addReview(reviewDto);
		if (isSuccess == 1) {
			path = "/review?act=view&reviewId=" + 1;
		} else {
			
		}
		
		return path;
	}

}
