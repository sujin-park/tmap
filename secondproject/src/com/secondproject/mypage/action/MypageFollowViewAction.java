package com.secondproject.mypage.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.admin.service.CommonServiceImpl;
import com.secondproject.constant.BoardConstant;
import com.secondproject.mypage.model.FollowCategoryDto;
import com.secondproject.mypage.model.FollowUserDto;
import com.secondproject.mypage.service.MypageServiceImpl;
import com.secondproject.util.*;

public class MypageFollowViewAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path="/page/mypage/mypage.jsp";
		int id = 2;
		int pg = NumberCheck.nullToOne(request.getParameter("pg"));
		String key = Encoding.nullToBlank(request.getParameter("key"));
		String word = request.getParameter("word");
		String board = request.getParameter("board");
		Map<String,String> map = new HashMap<String, String>();
		map.put("pg", pg+"");
		map.put("key", key);
		map.put("word", word);
		map.put("board", board);
		map.put("id", id+"");
		int end = pg * BoardConstant.MYPAGE_LIST_SIZE;
		int start = end -BoardConstant.MYPAGE_LIST_SIZE;
		map.put("start", start+"");
		map.put("end", end+"");
		List<FollowUserDto> list= MypageServiceImpl.getMypageService().followListView(map);
		List<FollowCategoryDto> fclist = MypageServiceImpl.getMypageService().followCategoryListView(id);
		request.setAttribute("favoriteCategoryList", fclist);
		request.setAttribute("list", list);
		PageNavigation pageNavigation = CommonServiceImpl.getCommonService().mypagePageNavigation(pg, key, word, board);
		pageNavigation.setRoot(request.getContextPath());
		pageNavigation.setListSize(BoardConstant.MYPAGE_LIST_SIZE);
		pageNavigation.setPageSize(BoardConstant.MYPAGE_PAGE_SIZE);
		
		pageNavigation.setNavigator();
		request.setAttribute("navigator", pageNavigation);
		
		return path;
	}

}

