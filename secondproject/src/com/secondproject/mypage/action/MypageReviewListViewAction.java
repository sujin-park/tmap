package com.secondproject.mypage.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.mypage.model.MyReviewDto;
import com.secondproject.mypage.service.MypageReviewServiceImpl;

public class MypageReviewListViewAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/page/mypage/myreview.jsp";
		
		int userId = 2;
		List<MyReviewDto> list = MypageReviewServiceImpl.getMypageReviewService().reviewListView(userId);
		request.setAttribute("reviewlist", list);
		return path;
	}

}

