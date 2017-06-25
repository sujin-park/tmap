package com.secondproject.joinlogin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.joinlogin.service.JoinServiceImpl;
import com.secondproject.userdto.UserDto;


public class JoinAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/index.jsp";
		UserDto userDto = new UserDto();
//		System.out.println(request.getParameter("email"));
//		System.out.println(request.getParameter("password"));
//		System.out.println(request.getParameter("age"));
//		System.out.println(request.getParameter("gender"));
		
		userDto.setEmail(request.getParameter("email"));
		userDto.setPassword(request.getParameter("password"));
		userDto.setAge(Integer.parseInt(request.getParameter("age")));
		userDto.setGender(Integer.parseInt(request.getParameter("gender")));
		
		int cnt = JoinServiceImpl.getJoinService().join(userDto);
		if(cnt != 0){
			path = "/page/joinlogin/join/joinok.jsp";
			request.setAttribute("userinfo", userDto);
		} else {
			path = "/page/joinlogin/join/joinfail.jsp";
		}
		return path;
	}
}


