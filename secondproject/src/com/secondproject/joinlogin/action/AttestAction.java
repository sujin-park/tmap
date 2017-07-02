package com.secondproject.joinlogin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.secondproject.action.Action;
import com.secondproject.joinlogin.service.JoinServiceImpl;
import com.secondproject.userdto.UserDto;


public class AttestAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/index.jsp";
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
//		System.out.println(request.getParameter("email"));
//		System.out.println(request.getParameter("password"));
//		System.out.println(request.getParameter("age"));
//		System.out.println(request.getParameter("gender"));
		
		UserDto userDto = JoinServiceImpl.getJoinService().attest(email, password, age, gender);
		if(userDto != null){
			// 이메일 인증을 위한 session 생성
			HttpSession session = request.getSession();
			session.setAttribute("attestinfo", userDto);
			session.setMaxInactiveInterval(60*10); // 지속시간 10분 설정?? 시간 설정 
			//TODO 밑에 경로 수정
			path = "/page/joinlogin/join/mailform.jsp";
			request.setAttribute("userinfo", userDto);
		} else {
			path = "/page/joinlogin/join/joinfail.jsp";
		}
		return path;
	}
}


