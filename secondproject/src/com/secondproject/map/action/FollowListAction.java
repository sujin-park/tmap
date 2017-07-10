package com.secondproject.map.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.secondproject.action.Action;
import com.secondproject.map.service.MapServiceImpl;
import com.secondproject.userdto.UserDto;
import com.secondproject.util.NumberCheck;
import com.secondproject.util.map.Bounds;

public class FollowListAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsonData = "";
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("logininfo");
		
		Bounds bounds = new Gson().fromJson(request.getParameter("bounds"), Bounds.class);
		int categoryId = NumberCheck.nullToZero(request.getParameter("categoryId").trim());
		
		if (userDto != null) {
			jsonData = MapServiceImpl.getMapService().getFollowListJSON(bounds, userDto.getUser_id(), categoryId);
		}
		
		return jsonData;
	}
	
}
