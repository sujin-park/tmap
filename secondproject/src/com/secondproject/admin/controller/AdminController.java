package com.secondproject.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.secondproject.factory.AdminFactory;
import com.secondproject.util.*;

@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/index.jsp";
		String contentPath = "";
		
		String act = request.getParameter("act");
		String board = request.getParameter("board");
		int pg = NumberCheck.nullToOne(request.getParameter("pg"));
		String key = Encoding.nullToBlank(request.getParameter("key"));
		String word = request.getParameter("word");
		String order = Encoding.nullToBlank(request.getParameter("order"));
		String column = Encoding.nullToBlank(request.getParameter("column"));
		
		String queryString = "?pg=" + pg + "&board=" + board + "&key=" + key + "&word=" + Encoding.urlFormat(word) + "&order=" + order + "&column=" + column;
		
		if ("mvexhibition".equals(act)) {
			path ="/template/admin/admin.jsp";
			contentPath = AdminFactory.getExhibitionListAction().execute(request, response);
//			request.setAttribute("pg", pg + "");
//			request.setAttribute("key", key);
//			request.setAttribute("word", word);
//			request.setAttribute("order", order);
//			request.setAttribute("column", column);
//			request.setAttribute("board", board);
			request.setAttribute("titleTagValue", "타이틀");
			request.setAttribute("contentPath", contentPath);
			request.setAttribute("addHeadPath", "/template/admin/include/head.jsp");
			request.setAttribute("addBottomPath", "/page/adminpage/include/bottom_exhibition.jsp");
			PageMove.forward(path, request, response);
		} else if ("mvmember".equals(act)) {
			path ="/template/admin/admin.jsp";
			request.setAttribute("titleTagValue", "타이틀");
			request.setAttribute("contentPath", "/page/adminpage/member/member.jsp");
			request.setAttribute("addHeadPath", "/template/admin/include/head.jsp");
			request.setAttribute("addBottomPath", "/page/adminpage/include/bottom_exhibition.jsp");
			
			PageMove.forward(path, request, response);
			// 수정아직 안된부분
		} else if ("mvreview".equals(act)) {
			path ="/template/admin/admin.jsp";
			request.setAttribute("pg", pg + "");
			request.setAttribute("key", key);
			request.setAttribute("word", word);
			request.setAttribute("order", order);
			request.setAttribute("column", column);
			contentPath = AdminFactory.getReviewListAction().execute(request, response);
			request.setAttribute("titleTagValue", "타이틀");
			request.setAttribute("contentPath", contentPath);
			request.setAttribute("addHeadPath", "/template/admin/include/head.jsp");
			request.setAttribute("addBottomPath", "/page/adminpage/include/bottom_exhibition.jsp");
			
			PageMove.forward(path, request, response);
		}else if ("userview".equals(act)){
			path ="/template/admin/admin.jsp";
			contentPath = AdminFactory.getUserViewAction().execute(request, response);
			request.setAttribute("titleTagValue", "타이틀");
			request.setAttribute("contentPath", contentPath);
			request.setAttribute("addHeadPath", "/template/admin/include/head.jsp");
			request.setAttribute("addBottomPath", "/page/adminpage/include/bottom_exhibition.jsp");
			PageMove.forward(path, request, response);
		} else if("userdelete".equals(act)) {
			path ="/admin?act=userview";
			contentPath = AdminFactory.getUserDeleteAction().execute(request, response);
			request.setAttribute("titleTagValue", "타이틀");
			request.setAttribute("contentPath", contentPath);
			request.setAttribute("addHeadPath", "/template/admin/include/head.jsp");
			request.setAttribute("addBottomPath", "/page/adminpage/include/bottom_exhibition.jsp");
			PageMove.forward(path, request, response);
		} 
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}

}
