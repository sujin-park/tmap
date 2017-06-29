package com.secondproject.joinlogin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.joinlogin.service.JoinServiceImpl;

public class IdCheckAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sid = request.getParameter("email");
		//String path = "/index.jsp";
		
		int count = JoinServiceImpl.getJoinService().idCheck(sid);
//		request.setAttribute("count", count);
		String path = "/page/joinlogin/join/idcheck.jsp?sid=" + sid + "&count=" + count;
		return path;
	}
	

}
