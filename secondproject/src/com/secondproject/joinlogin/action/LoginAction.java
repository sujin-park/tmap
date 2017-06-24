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
		
		UserDto userDto = LoginServiceImpl.getLoginService().login(email, password);
		if(userDto != null){
			//session ����
			HttpSession session = request.getSession();
			session.setAttribute("logininfo", userDto);
			path = "/login/loginok.jsp";
		} else {
			path = "/login/loginfail.jsp";
		}
		return path;
	}
	
}
