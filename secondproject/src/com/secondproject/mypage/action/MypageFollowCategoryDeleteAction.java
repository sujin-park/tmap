package com.secondproject.mypage.action;

import java.io.IOException;
import java.io.PrintWriter;
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

public class MypageFollowCategoryDeleteAction extends BoardCommonAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "index.jsp";
//		HttpSession session = request.getSession();
//		UserDto udto = (UserDto)session.getAttribute("logininfo");
		int userId = 2;
		int cateId = Integer.parseInt(request.getParameter("cateid"));
		int cnt = MypageServiceImpl.getMypageService().followCategoryDelete(cateId);
		setBoardParameter(request);
		HashMap<String, Object> params = getParameterMap();
		params.put("userId", userId);
		List<FollowCategoryDto> fclist = MypageServiceImpl.getMypageService().followCategoryListView(params);
		request.setAttribute("followCategoryList", fclist);
		if(cnt!=0) {
			path ="/page/mypage/catelistview.jsp";
		}
	
		return path;
	}

}
