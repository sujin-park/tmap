package com.secondproject.mypage.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.secondproject.action.Action;
import com.secondproject.mypage.model.MyReviewDto;
import com.secondproject.mypage.model.ReviewCommentDto;
import com.secondproject.mypage.model.ReviewGoodBad;
import com.secondproject.mypage.service.MypageReviewServiceImpl;
import com.secondproject.userdto.UserDto;
import com.secondproject.util.Encoding;
import com.secondproject.util.NumberCheck;

public class CommentInsertAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/index.jsp";
		HttpSession session = request.getSession();
		UserDto udto = (UserDto)session.getAttribute("logininfo");
		if(udto!=null) {
		int userId = udto.getUser_id();
			String text = Encoding.isoToUtf(request.getParameter("text"));
			int reviewId = NumberCheck.nullToZero(request.getParameter("reviewId"));
			MypageReviewServiceImpl.getMypageReviewService().commentinsert(reviewId, userId, text);
			MyReviewDto mrdto = MypageReviewServiceImpl.getMypageReviewService().reviewView(reviewId);
			List<ReviewCommentDto>  clist = MypageReviewServiceImpl.getMypageReviewService().commentList(reviewId);
			ReviewGoodBad goodbad = MypageReviewServiceImpl.getMypageReviewService().goodbad(reviewId, userId);
			request.setAttribute("myreview", mrdto);
			request.setAttribute("clist", clist);
			request.setAttribute("goodbad", goodbad);
		}
		path="/page/mypage/myreviewview.jsp";
		return path;
	}

}
