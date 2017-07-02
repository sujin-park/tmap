package com.secondproject.mypage.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.action.BoardCommonAction;
import com.secondproject.mypage.model.FollowCategoryDto;
import com.secondproject.mypage.service.MypageServiceImpl;
import com.secondproject.util.Encoding;
import com.secondproject.util.NumberCheck;

public class MypageFollowCategoryDownOrderAction extends BoardCommonAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "index.jsp";
		int id = Integer.parseInt(request.getParameter("id"));
		int cnt =MypageServiceImpl.getMypageService().downOrder(id);
		if(cnt!=0){
			int userId = 2;
			setBoardParameter(request);
			HashMap<String, Object> params = getParameterMap();
			params.put("userId", userId);
			List<FollowCategoryDto> list = MypageServiceImpl.getMypageService().followCategoryListView(params);
			request.setAttribute("followCategoryList", list);
			path = "/page/mypage/catelistview.jsp";
		}
//		return path;
//		HttpSession session = request.getSession();
//		UserDto udto = (UserDto)session.getAttribute("logininfo");
//		int userId= udto.getUser_id();
		
		
		return path;
	}

}
