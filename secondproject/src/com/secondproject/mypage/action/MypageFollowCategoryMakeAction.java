package com.secondproject.mypage.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.mypage.model.FollowCategoryDto;
import com.secondproject.mypage.model.FollowUserDto;
import com.secondproject.mypage.service.MypageServiceImpl;

public class MypageFollowCategoryMakeAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		int id = Integer.parseInt(request.getParameter("id"));
		String name = new String(request.getParameter("catename").getBytes("ISO-8859-1"),"UTF-8");
		String path = "index.jsp";
		int id = 2;
		
		FollowCategoryDto fcdto = new FollowCategoryDto();
		fcdto.setCategoryName(name);
		fcdto.setUserId(id);
		int cnt = MypageServiceImpl.getMypageService().followCategoryMake(fcdto);
		int userId=2;
		List<FollowCategoryDto> list = MypageServiceImpl.getMypageService().followCategoryListView(userId);
		request.setAttribute("favoriteCategoryList", list);
		path = "/page/mypage/catelistview.jsp";
		return path;
	}

}
