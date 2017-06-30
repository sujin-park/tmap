package com.secondproject.mypage.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.mypage.model.FollowCategoryDto;
import com.secondproject.mypage.model.FollowUserDto;
import com.secondproject.mypage.service.MypageServiceImpl;
import com.secondproject.util.Encoding;
import com.secondproject.util.NumberCheck;

public class MypageFollowCategoryMakeAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		int id = Integer.parseInt(request.getParameter("id"));
		String name = new String(request.getParameter("catename").getBytes("ISO-8859-1"),"UTF-8");
		String path = "index.jsp";
		int id = 2;
		int pg = NumberCheck.nullToOne(request.getParameter("pg"));
		String key = Encoding.nullToBlank(request.getParameter("key"));
		String word = Encoding.nullToBlank(request.getParameter("word"));
		String board = Encoding.nullToBlank(request.getParameter("board"));
		Map<String,String> map = new HashMap<String, String>();
		map.put("pg", pg+"");
		map.put("key", key);
		map.put("word", word);
		map.put("board", board);
		map.put("userId", id+"");
		FollowCategoryDto fcdto = new FollowCategoryDto();
		fcdto.setCategoryName(name);
		fcdto.setUserId(id);
		int cnt = MypageServiceImpl.getMypageService().followCategoryMake(fcdto);
		List<FollowCategoryDto> list = MypageServiceImpl.getMypageService().followCategoryListView(map);
		request.setAttribute("favoriteCategoryList", list);
		path = "/page/mypage/catelistview.jsp";
		return path;
	}

}
