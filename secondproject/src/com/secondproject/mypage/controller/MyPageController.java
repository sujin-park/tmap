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
import com.secondproject.util.Encoding;
import com.secondproject.util.NumberCheck;

@WebServlet("/mypage")
public class MyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "index.jsp"; 		
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
		} else if ("followUser".equals(act)) {
			path = MypageFactory.getMypageFollowUserViewAction().execute(request, response);
		} else if ("followmodify".equals(act)) {
			path = MypageFactory.getMypageFollowModifyAction().execute(request, response);
		} else if ("followView".equals(act)) {
			path = MypageFactory.getMypageFollowViewAction().execute(request, response);
			
		} else if ("catemodify".equals(act)) {
			path = MypageFactory.getMypageFollowCategoryModifyAction().execute(request, response);
		}
//		path += queryString;
		request.setAttribute("titleTagValue", "마이페이지");
		request.setAttribute("contentPath", path);
		request.setAttribute("addHeadPath", "/page/mypage/include/head.jsp");
//		request.setAttribute("addBottomPath", "/page/mypage/include/bottom.jsp");
		RequestDispatcher dist=null;
		if(path.equals("/page/mypage/catelistview.jsp")){
			dist = request.getRequestDispatcher("/page/mypage/catelistview.jsp");
		} else if(path.equals("/page/mypage/followUserData.jsp")) {
			dist = request.getRequestDispatcher("/page/mypage/followUserData.jsp");
		} else {
			dist = request.getRequestDispatcher("/template/default/default.jsp");
		}dist.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request,response);
	}

}
