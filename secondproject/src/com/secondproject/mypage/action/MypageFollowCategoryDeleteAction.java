package com.secondproject.mypage.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.mypage.model.FollowCategoryDto;
import com.secondproject.mypage.service.MypageServiceImpl;

public class MypageFollowCategoryDeleteAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path ="index.jsp";
		int id = Integer.parseInt(request.getParameter("cateid"));
		int cnt = MypageServiceImpl.getMypageService().followCategoryDelete(id);
		List<FollowCategoryDto> fclist = MypageServiceImpl.getMypageService().followCategoryListView(2);
		request.setAttribute("favoriteCategoryList", fclist);
		if(cnt!=0) {
			path ="/page/mypage/catelistview.jsp";
		}
		return path;
	}

}
