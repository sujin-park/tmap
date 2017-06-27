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

public class MypageFollowModifyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String alias = new String(request.getParameter("alias").getBytes("ISO-8859-1"),"utf-8");
		String memo = new String(request.getParameter("memo").getBytes("ISO-8859-1"),"utf-8");
		int userId = Integer.parseInt(request.getParameter("userid"));
		FollowUserDto fudto = new FollowUserDto();
		fudto.setAlias(alias);
		fudto.setMemo(memo);
		fudto.setUserId(userId);
		MypageServiceImpl.getMypageService().followModify(fudto);
		int id = 2;
		List<FollowUserDto> list= MypageServiceImpl.getMypageService().followListView(id);
		List<FollowCategoryDto> fclist = MypageServiceImpl.getMypageService().followCategoryListView(id);
		request.setAttribute("favoriteCategoryList", fclist);
		request.setAttribute("list", list);
		
		return "/page/mypage/mypage.jsp";
	}

}
