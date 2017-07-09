package com.secondproject.joinlogin.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.secondproject.action.Action;
import com.secondproject.joinlogin.service.LoginServiceImpl;
import com.secondproject.userdto.UserDto;

public class LoginAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/index.jsp";
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String old_url = request.getHeader("referer");
		System.out.println("LOGIN" + old_url);
		UserDto userDto = LoginServiceImpl.getLoginService().login(email, password);
		if(userDto != null){
			HttpSession session = request.getSession();
			session.setAttribute("logininfo", userDto);
			path = old_url;
		} else { 
			path = "/page/joinlogin/login/loginfail.jsp";
		}
		return path;
	}
	
}
