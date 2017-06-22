package com.secondproject.joinlogin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.factory.JoinLoginFactory;
import com.secondproject.util.PageMove;

@WebServlet("/joinlogin")
public class JoinLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.print("1");
		String act = request.getParameter("act");
		String path ="/index.jsp";
//		String queryString = ""; 
		//System.out.print("2");
		if("login".equals(act)){
			path = JoinLoginFactory.getLoginAction().execute(request, response);
//			path += queryString;
			PageMove.forward(path, request, response);
		} else if ("join".equals(act)){
			//System.out.print("3");
			path = JoinLoginFactory.getJoinAction().execute(request, response);
			//System.out.print(path);
//			path += queryString;
			PageMove.forward(path, request, response);
			System.out.print("5");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		doGet(request, response);
	}

}
