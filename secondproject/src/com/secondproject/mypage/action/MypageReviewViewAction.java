package com.secondproject.mypage.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.mypage.dao.MypageReviewDaoImpl;
import com.secondproject.mypage.model.MyReviewDto;
import com.secondproject.mypage.model.ReviewCommentDto;
import com.secondproject.mypage.service.MypageReviewServiceImpl;
import com.secondproject.util.Encoding;
import com.secondproject.util.NumberCheck;

public class MypageReviewViewAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/page/mypage/myreviewview.jsp";
		int reviewId = NumberCheck.nullToZero(request.getParameter("reviewId"));
		int userId = 2;
		MyReviewDto mrdto = MypageReviewServiceImpl.getMypageReviewService().reviewView(reviewId);
		List<ReviewCommentDto>  clist = MypageReviewServiceImpl.getMypageReviewService().commentList(reviewId);
		request.setAttribute("myreview", mrdto);
		request.setAttribute("clist", clist);
		return path;
	}

}

