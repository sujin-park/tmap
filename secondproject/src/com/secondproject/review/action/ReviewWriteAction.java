package com.secondproject.review.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.review.model.ReviewDto;
import com.secondproject.review.service.ReviewServiceImple;
import com.secondproject.util.NumberCheck;

public class ReviewWriteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isValidate = false;
		
		int shopId = NumberCheck.nullToZero(request.getParameter("shopId"));
		int userId = NumberCheck.nullToZero(request.getParameter("userId"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int score = Integer.parseInt(request.getParameter("score"));

		if (shopId == 0) {
			
		} else if (userId == 0) {
			
		}
			
		

		
		// shopId == 0 || userId == 0 이라면 서비스에 일 시킬필요가 없음.
		// 그렇다면.....실패페이지로 바로 가버리면 될테고..
		// 실패페이지에서는 경고창만 뛰우고 뒤로가기?
		
		ReviewDto reviewDto = new ReviewDto();
		reviewDto.setShopId(shopId);
		reviewDto.setUserId(userId);
		reviewDto.setTitle(title);
		reviewDto.setContent(content);
		reviewDto.setScore(score);
		ReviewServiceImple.getReviewService().addReview(reviewDto);
		
		return null;
	}
	
	private boolean validate() {
		return false;
	}

}
