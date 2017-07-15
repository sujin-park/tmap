package com.secondproject.joinlogin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.secondproject.constant.ContextPath;
import com.secondproject.factory.JoinLoginFactory;
import com.secondproject.util.PageMove;

@WebServlet("/joinlogin")
public class JoinLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String path ="/index.jsp";
		if("login".equals(act)){ //로그인
			 String url = JoinLoginFactory.getLoginAction().execute(request, response);
	         if(url != "/page/joinlogin/login/loginfail.jsp"){
	            String[] urlselect = url.split("/");
	            int size = urlselect.length;
	            if (size == 5) {
	               String loginURL = urlselect[4];
	               path = "/" + loginURL;
	            }
	            PageMove.redirect(path, request, response);
	         } else {
	            PageMove.forward(url, request, response);
	         }
		} else if ("logout".equals(act)) { //로그아웃
			HttpSession session = request.getSession();
			session.removeAttribute("logininfo"); //세션 삭제
			path = "/page/joinlogin/login/logout.jsp";
			PageMove.redirect(path, request, response);
		} else if ("attest".equals(act)){ //이메일 인증
			path = JoinLoginFactory.getAttestAction().execute(request, response);
			PageMove.forward(path, request, response);
		} else if ("idcheck".equals(act)){ // 아디 중복확인검사 ajax 용
			path = JoinLoginFactory.getIdCheckAction().execute(request, response);
			PageMove.forward(path, request, response);
		} else if ("lastcheck".equals(act)){ // email 인증 확인 용
			path = JoinLoginFactory.getLastCheckAction().execute(request, response);
			PageMove.forward(path, request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		doGet(request, response);
	}

}
