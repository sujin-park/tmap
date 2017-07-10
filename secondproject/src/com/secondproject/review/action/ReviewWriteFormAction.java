package com.secondproject.review.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.util.NumberCheck;
import com.secondproject.util.validation.LoginCheck;

public class ReviewWriteFormAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contentPath = "";
		boolean isLogin = LoginCheck.isLogin(request);
		int shopId = NumberCheck.nullToZero(request.getParameter("shopId"));

		if (isLogin && shopId != 0) {
			contentPath = "/page/review/write.jsp";
		} else if (isLogin == false) {
			contentPath = "/page/error/login.jsp";
		} else {
			contentPath = "/page/error/error.jsp";
		}

		request.setAttribute("titleTagValue", "TMAP - ∏Æ∫‰¿€º∫");
		request.setAttribute("contentPath", contentPath);
		request.setAttribute("addHeadPath", "/page/review/include/head.jsp");
		request.setAttribute("addBottomPath", "/page/review/include/bottom.jsp");

		return "/template/default/default.jsp";
	}

}
