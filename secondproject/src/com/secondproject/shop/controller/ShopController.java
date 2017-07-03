package com.secondproject.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.factory.ShopFactory;
import com.secondproject.util.PageMove;


@WebServlet("/shop")
public class ShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String path = "";
		
		if ("view".equals(act)) {
			path = ShopFactory.getShopViewAction().execute(request, response);
			request.setAttribute("titleTagValue", "TMAP - ∏≈¿Â View");
			request.setAttribute("contentPath", path);
			request.setAttribute("addHeadPath", "/page/shop/include/head.jsp");
			request.setAttribute("addBottomPath", "/page/shop/include/bottom.jsp");
			PageMove.forward("/template/default/default.jsp", request, response);
		} else if ("addShopAjax".equals(act)) {
			String jsonData = ShopFactory.getShopAddAction().execute(request, response);
			response.setContentType("text/html; charset=EUC-KR");
			response.getWriter().print(jsonData);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
