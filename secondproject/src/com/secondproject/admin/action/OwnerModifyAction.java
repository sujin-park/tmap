package com.secondproject.admin.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.admin.model.OwnerConfirmDto;
import com.secondproject.admin.service.OwnerServiceImpl;
import com.secondproject.admin.service.UserDeleteServiceImpl;

public class OwnerModifyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int ownerOk = Integer.parseInt(request.getParameter("ownerok"));
		System.out.println(ownerOk + "=yesorno");
		String path = "/admin?act=ownerview";
		String[] user_id = request.getParameterValues("checkRow");
		ArrayList<OwnerConfirmDto> cnt = OwnerServiceImpl.getOwnerService().modifyArticles(user_id, ownerOk);	
		//int cnt = OwnerServiceImpl.getOwnerService().modifyArticles(users);	
		return path;
	}

}
