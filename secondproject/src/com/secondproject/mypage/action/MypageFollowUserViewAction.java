package com.secondproject.mypage.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.mypage.dao.MypageFollowDaoImpl;
import com.secondproject.mypage.model.FollowUserDto;

public class MypageFollowUserViewAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path="/page/mypage/followUserData.jsp";
		int followuserid = Integer.parseInt(request.getParameter("followuserid"));
		FollowUserDto udto = MypageFollowDaoImpl.getMypageFollowDao().getFollow(followuserid);
			request.setAttribute("fudata", udto);
		return path;
	}

}

