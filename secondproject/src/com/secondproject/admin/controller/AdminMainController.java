package com.secondproject.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.util.PageMove;

@WebServlet("/adminmain")
public class AdminMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/template/admin/admin.jsp";
		request.setAttribute("titleTagValue", "≈∏¿Ã∆≤");
		request.setAttribute("contentPath", "/template/admin/main.jsp");
		PageMove.forward(path, request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}