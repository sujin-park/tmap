package com.secondproject.util.validation;

import javax.servlet.http.HttpServletRequest;

import com.secondproject.userdto.UserDto;

public class LoginCheck {

	public static boolean isLogin(HttpServletRequest request) {
		return ((UserDto) request.getSession().getAttribute("logininfo") == null ? false : true);
	}
	
}
