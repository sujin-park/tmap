package com.secondproject.map.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

public class ShopListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsonData = "";
		HttpSession session = request.getSession();
		UserDto loginUserDto = (UserDto) session.getAttribute("logininfo");
		int userId = 0;
		
		if (loginUserDto != null) {
			userId = loginUserDto.getUser_id();
		}
		
		Bounds bounds = new Gson().fromJson(request.getParameter("bounds"), Bounds.class);
		int categoryId = NumberCheck.nullToZero(request.getParameter("categoryId"));
		List<Integer> followUsers = new ArrayList<Integer>();
		
		if (userId != 0) {
			String followUsersId[] = request.getParameterValues("followUsersId[]");
			// TODO 팔로우 유저아이디 들어온값 유효성검사도 해야하지만...그렇지만...했다고 치자..
			if (followUsersId != null && followUsersId.length > 0) {
				for (String a : followUsersId) {
					int tmp = NumberCheck.nullToZero(a.trim());
					if (tmp != 0) {
						followUsers.add(tmp);
					}
				}
				jsonData = MapServiceImpl.getMapService().getShopListByFollowUsersJSON(bounds, categoryId, followUsers);
			} else {
				followUsers = MapServiceImpl.getMapService().getAllFolloewUserId(userId);
				jsonData = MapServiceImpl.getMapService().getShopListJSON(bounds, categoryId, followUsers);
			}
		} else {
			jsonData = MapServiceImpl.getMapService().getShopListJSON(bounds, categoryId, followUsers);
		}
		
		return jsonData;
	}

}