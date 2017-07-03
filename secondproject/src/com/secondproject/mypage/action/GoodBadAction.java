package com.secondproject.mypage.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.secondproject.action.Action;
import com.secondproject.mypage.model.ReviewGoodBad;
import com.secondproject.mypage.service.MypageReviewServiceImpl;
import com.secondproject.userdto.UserDto;
import com.secondproject.util.NumberCheck;

public class GoodBadAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/index.jsp";
		HttpSession session = request.getSession();
		UserDto udto = (UserDto)session.getAttribute("logininfo");
		if(udto!=null) {
			int userId = udto.getUser_id();
			int good= NumberCheck.nullToZero(request.getParameter("good"));
			int bad = NumberCheck.nullToZero(request.getParameter("bad"));
			int reviewId =NumberCheck.nullToZero(request.getParameter("reviewId"));
			MypageReviewServiceImpl.getMypageReviewService().goodbadselect(good, bad, userId, reviewId);
			ReviewGoodBad goodbad = MypageReviewServiceImpl.getMypageReviewService().goodbad(reviewId, userId);
			request.setAttribute("goodbad", goodbad);
			path = "/page/mypage/goodbad.jsp";
		}
		
		return path;
	}

}
