package com.secondproject.map.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.secondproject.action.Action;
import com.secondproject.map.model.FollowCategoryDto;
import com.secondproject.map.model.FollowCategoryUserDto;
import com.secondproject.map.service.MapServiceImpl;
import com.secondproject.userdto.UserDto;

public class CategoryListAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("logininfo");
		ArrayList<FollowCategoryDto> categoryList = null;
		
//		if (userDto != null) {
//			categoryList = MapServiceImpl.getMapService().getCategoryByUser(userDto.getUser_id());
//			int size = categoryList.size();
//			if (size > 0) {
//				for (FollowCategoryDto dto : categoryList) {
//					if (dto.getFollowCategoryId() != null) {
//						FollowCategoryUserDto followCategoryUserDto = MapServiceImpl.getMapService().getCategoryUser(dto.getFollowCategoryId());
//						dto.getCategoryUserList().add(followCategoryUserDto);
//					}
//				}
//			}
//		}
//		
		request.setAttribute("followList", categoryList);
		return "/page/map/map.jsp";
	}
	
}
