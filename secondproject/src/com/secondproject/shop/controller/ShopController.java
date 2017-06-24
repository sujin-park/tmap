package com.secondproject.shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.factory.ShopFactory;


@WebServlet("/shop")
public class ShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String path = "";
		boolean isAjax = false;
		
		if (act == null) {
			
		} else if ("addShopForm".equals(act)) {
			path = "/page/shop/addshopform.jsp";
		} else if ("addShop".equals(act)) {
			path = ShopFactory.getShopAddAction().execute(request, response);
		}
		
		if (isAjax == false) {
			request.setAttribute("titleTagValue", "TMAP");
			request.setAttribute("contentPath", path);
			request.setAttribute("addHeadPath", "/page/shop/include/head.jsp");
			request.setAttribute("addBottomPath", "/page/shop/include/bottom.jsp");
			RequestDispatcher dist = request.getRequestDispatcher("/template/default/default.jsp");
			dist.forward(request, response);
		}		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
