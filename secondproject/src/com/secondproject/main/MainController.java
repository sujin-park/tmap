package com.secondproject.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.factory.MainFactory;

@WebServlet("/main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String act = request.getParameter("act");
		String contentPath = "";
		if("ex_main".equals(act)) {
			contentPath = MainFactory.getMainListAction().execute(request, response);
		}
		request.setAttribute("titleTagValue", "Tmap");
		request.setAttribute("contentPath", contentPath);
		request.setAttribute("addHeadPath", "/page/main/include/head.jsp");
		request.setAttribute("addBottomPath", "/page/main/include/bottom.jsp");
		RequestDispatcher dist = request.getRequestDispatcher("/template/main/index.jsp");
		dist.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request,response);
	}

}
