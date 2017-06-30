package com.secondproject.admin.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.admin.service.UserViewServiceImpl;
import com.secondproject.userdto.UserDto;
import com.secondproject.util.Encoding;

public class UserViewAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String keyword = Encoding.isoToEuc(request.getParameter("keyword"));
		String type = request.getParameter("key_type");
		String userOrder = Encoding.nullToBlank(request.getParameter("userorder"));
		String column = request.getParameter("column");
		
		//System.out.println("column == " + column);
		//System.out.println("userOrder == " + userOrder);

		if (userOrder.isEmpty()) {
			userOrder = "asc";
		}
		
		
		if ("type".equals(type) && "회원".equals(keyword)) {
			keyword = "1";
		} else if ("type".equals(type) && "사장".equals(keyword)) {
			keyword = "2";
		} else if ("gender".equals(type) && "남성".equals(keyword)) {
			keyword = "1";
		} else if ("gender".equals(type) && "여성".equals(keyword)) {
			keyword = "2";
		}

			
		
		
		
		ArrayList<UserDto> list= UserViewServiceImpl.getUserViewService().getArticles(keyword,type,userOrder,column);
		
	
		if (userOrder.equals("asc")) {
			userOrder = "desc";
		} else {
			userOrder = "asc";
		}
		request.setAttribute("userOrder", userOrder);
		request.setAttribute("list", list);
		return "/page/adminpage/member/member.jsp";
		
	}

}
