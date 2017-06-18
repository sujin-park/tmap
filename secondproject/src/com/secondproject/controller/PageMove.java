package com.secondproject.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageMove {

	public static void redirect(String url,HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(request.getContextPath() +url);
	}
	
	public static void forward(String path,HttpServletRequest request, HttpServletResponse response) throws  ServletException,IOException {
		RequestDispatcher disp = request.getRequestDispatcher(path);
		disp.forward(request, response);
	}
	
	
}
