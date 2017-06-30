package com.secondproject.admin.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.admin.model.OwnerConfirmDto;
import com.secondproject.admin.service.OwnerServiceImpl;

import com.secondproject.util.Encoding;

public class OwnerViewAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String keyword = Encoding.isoToEuc(request.getParameter("keyword"));
		String type = request.getParameter("key_type");
		String userOrder = Encoding.nullToBlank(request.getParameter("userorder"));
		String column = request.getParameter("column");
		String act = request.getParameter("act");
		int confirm_ok = 0;


		
		if (userOrder.isEmpty()) {
			userOrder = "asc";
		}
				
		if (act.equals("ownerview")){
			confirm_ok = 1;
		} else if (act.equals("realownerview")) {
			confirm_ok = 2;
		}
		
		System.out.println(act);
		System.out.println(confirm_ok);
		System.out.println("keyword=" + keyword + " type=" + type + " userOrder=" + userOrder + " column=" + column);


		
		ArrayList<OwnerConfirmDto> list = OwnerServiceImpl.getOwnerService().getArticles(keyword, type, userOrder, column, confirm_ok);
		
		if (userOrder.equals("asc")) {
			userOrder = "desc";
		} else {
			userOrder = "asc";
		}
		

		
		
		request.setAttribute("userOrder", userOrder);
		request.setAttribute("list", list);
		return "/page/adminpage/owner/owner.jsp";


	
	}

}
