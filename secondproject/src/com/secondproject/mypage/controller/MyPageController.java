package com.secondproject.mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.factory.MypageFactory;
import com.secondproject.mypage.action.MypageFollowAddAction;

@WebServlet("/mypage")
public class MyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = MypageFactory.getMypageFollowViewAction().execute(request, response);
		String act = request.getParameter("act");
		if("followCategoryListView".equals(act)) {
			path = MypageFactory.getMypageFollowCategoryListView().execute(request, response);
		} else if("upOrder".equals(act)) {
			path = MypageFactory.getMypageFollowCategoryUpOrderAction().execute(request, response);
		} else if("downOrder".equals(act)) {
			path = MypageFactory.getMypageFollowCategoryDownOrderAction().execute(request, response);
		} else if("catemake".equals(act)) {
			path = MypageFactory.getMypageFollowCategoryMakeAction().execute(request, response);
		} else if("followdelete".equals(act)) {
			path = MypageFactory.getMypageFollowDeleteAction().execute(request, response);
		} else if("catedelete".equals(act)) {
			path = MypageFactory.getMypageFollowCategoryDeleteAction().execute(request, response);
		}
		request.setAttribute("titleTagValue", "����������");
		request.setAttribute("contentPath", path);
		request.setAttribute("addHeadPath", "/page/mypage/include/head.jsp");
//		request.setAttribute("addBottomPath", "/page/mypage/include/bottom.jsp");
		RequestDispatcher dist=null;
		if(path.equals("/page/mypage/followdata.jsp")){
		dist = request.getRequestDispatcher("/page/mypage/followdata.jsp");
		} else {
			dist = request.getRequestDispatcher("/template/default/default.jsp");
		}
		dist.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request,response);
	}

}