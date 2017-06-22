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

public class MypageFollowViewAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path="/page/mypage/mypage.jsp";
		int id = 2;
		List<FollowUserDto> list= MypageServiceImpl.getMypageService().followListView(id);
		List<FollowCategoryDto> fclist = MypageServiceImpl.getMypageService().followCategoryListView(id);
		request.setAttribute("favoriteCategoryList", fclist);
		request.setAttribute("list", list);
		
		return path;
	}

}

