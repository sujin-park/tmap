package com.secondproject.mypage.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.secondproject.action.Action;
import com.secondproject.action.BoardCommonAction;
import com.secondproject.constant.BoardConstant;
import com.secondproject.mypage.model.FollowCategoryDto;
import com.secondproject.mypage.model.FollowUserDto;
import com.secondproject.mypage.service.MypageServiceImpl;
import com.secondproject.userdto.UserDto;
import com.secondproject.util.QueryString;
import com.secondproject.util.pagination.Pagination;

public class FollowSelectAction extends BoardCommonAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path="/page/mypage/select.jsp";
		HttpSession session = request.getSession();
		UserDto udto = (UserDto)session.getAttribute("logininfo");
		if(udto!=null) {
		int userId = udto.getUser_id();
		setBoardParameter(request);
		HashMap<String, Object> params = getParameterMap();
		params.put("userId", userId);
		List<FollowUserDto> followselect = MypageServiceImpl.getMypageService().followselect(params);
		request.setAttribute("followselect", followselect);

		} else {
			path="/index.jsp";
		}
		return path;
	}
 
}

