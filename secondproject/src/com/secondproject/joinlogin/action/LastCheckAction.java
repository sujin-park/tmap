package com.secondproject.joinlogin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.secondproject.action.Action;
import com.secondproject.joinlogin.service.JoinServiceImpl;
import com.secondproject.userdto.UserDto;

public class LastCheckAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/index.jsp";
		String user_id = request.getParameter("user_id");
		String email = request.getParameter("email");
		String checkkey = request.getParameter("checkkey");
		
		UserDto userDto = JoinServiceImpl.getJoinService().lastcheck(email, checkkey);
		if(userDto != null) {
			HttpSession session = request.getSession();
			session.setAttribute("logininfo", userDto);
			path = "/page/joinlogin/join/joinok.jsp";
		} else { 
			path = "/page/joinlogin/join/joinfail.jsp";
		}
		return path;
	}

}
