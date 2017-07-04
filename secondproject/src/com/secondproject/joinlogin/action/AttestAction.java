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
//        String email1 = email.substring(0, 5);

		String password = request.getParameter("password");
//		String pass = email.substring(0, 4);
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		
//		System.out.println(request.getParameter("email"));
//		System.out.println(request.getParameter("password"));
//		System.out.println(request.getParameter("age"));
//		System.out.println(request.getParameter("gender"));
		
//		int checkkey = Integer.parseInt(email1);
//		System.out.println(checkkey);
		
		int cnt = JoinServiceImpl.getJoinService().attest(email, password, age, gender);
		System.out.println("1");
		if(cnt != 0){
			System.out.println("2");
			//TODO 밑에 경로 수정??
//			request.setAttribute("userinfo", userDto);
			path = "/page/joinlogin/join/joinok.jsp";
			//path += "?email=" + email + "&checkkey=" + checkkey;
			
		} else {
			System.out.println("3");
			path = "/page/joinlogin/join/joinfail.jsp";
		}
		return path;
	}
}


