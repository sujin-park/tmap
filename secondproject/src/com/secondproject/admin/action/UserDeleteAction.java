package com.secondproject.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.admin.service.UserDeleteServiceImpl;

public class UserDeleteAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/admin?act=userview";
		String[] users = request.getParameterValues("checkRow");
		int cnt = UserDeleteServiceImpl.getUserDeleteService().deleteUsers(users);
		//System.out.println(users.length);
//		for (int i = 0; i < users.length; i++){	
//		System.out.println(users[i]);}
		return path;
	}

}
