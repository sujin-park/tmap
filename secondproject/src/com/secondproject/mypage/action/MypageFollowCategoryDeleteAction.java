package com.secondproject.mypage.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.mypage.service.MypageServiceImpl;

public class MypageFollowCategoryDeleteAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path ="";
		int id = Integer.parseInt(request.getParameter("cateid"));
		int cnt = MypageServiceImpl.getMypageService().followCategoryDelete(id);
		
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(cnt);
		return path;
	}

}
