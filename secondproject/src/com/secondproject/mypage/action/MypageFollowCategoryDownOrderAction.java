package com.secondproject.mypage.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.mypage.model.FollowCategoryDto;
import com.secondproject.mypage.service.MypageServiceImpl;

public class MypageFollowCategoryDownOrderAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "index.jsp";
		int id = Integer.parseInt(request.getParameter("id"));
		int cnt =MypageServiceImpl.getMypageService().downOrder(id);
		if(cnt!=0){
		int userId=2;
		List<FollowCategoryDto> list = MypageServiceImpl.getMypageService().followCategoryListView(userId);
		request.setAttribute("favoriteCategoryList", list);
		path = "/page/mypage/followCategoryList.jsp";
		}
		return path;
	}

}
