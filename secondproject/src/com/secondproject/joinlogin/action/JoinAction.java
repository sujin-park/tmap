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
		//System.out.println(request.getParameter("gender"));
		userDto.setEmail(request.getParameter("email"));
		userDto.setPassword(request.getParameter("password"));
		userDto.setGender(Integer.parseInt(request.getParameter("gender")));
		userDto.setAge(Integer.parseInt(request.getParameter("age")));
		
		int cnt = JoinServiceImpl.getJoinService().join(userDto);
		if(cnt != 0){
			path = "/join/joinok.jsp";
		} else {
			path = "/join/joinfail.jsp";
		}
		return path;
	}
}


