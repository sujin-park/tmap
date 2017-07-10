package com.secondproject.review.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.secondproject.action.Action;
import com.secondproject.review.service.ReviewServiceImpl;
import com.secondproject.userdto.UserDto;
import com.secondproject.util.NumberCheck;

public class ReviewGoodBadAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = "";
		HttpSession session = request.getSession();
		UserDto loginUserDto = (UserDto)session.getAttribute("logininfo");
		
		if(loginUserDto != null) {
			int userId = loginUserDto.getUser_id();
			String goodBad = request.getParameter("goodBad").trim();
			int reviewId =NumberCheck.nullToZero(request.getParameter("reviewId"));
			
			Map<String, Object> args = new HashMap<String, Object>();
			args.put("loginUserId", userId);
			args.put("goodBad", goodBad);
			args.put("reviewId", reviewId);
			
			json = ReviewServiceImpl.getReviewService().getReviewGoodBadJSON(args);
		} else {
			Map<String, String> aa = new HashMap<String, String>();
			aa.put("status", "로그인하세요");
			json = new Gson().toJson(aa);
		}
		
		return json;
	}

}
