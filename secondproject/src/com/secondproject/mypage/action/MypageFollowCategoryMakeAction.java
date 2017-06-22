package com.secondproject.mypage.action;

import java.io.IOException;
import java.util.List;

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
		String name = request.getParameter("catename");
		int id = 2;
		
		FollowCategoryDto fcdto = new FollowCategoryDto();
		fcdto.setCategoryName(name);
		fcdto.setUserId(id);
		int cnt = MypageServiceImpl.getMypageService().followCategoryMake(fcdto);
		List<FollowUserDto> list= MypageServiceImpl.getMypageService().followListView(id);
		List<FollowCategoryDto> fclist = MypageServiceImpl.getMypageService().followCategoryListView(id);
		request.setAttribute("favoriteCategoryList", fclist);
		request.setAttribute("list", list);
		return "/page/mypage/mypage.jsp";
	}

}
