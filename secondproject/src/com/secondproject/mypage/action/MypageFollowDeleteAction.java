package com.secondproject.mypage.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.mypage.model.FollowCategoryDto;
import com.secondproject.mypage.model.FollowUserDto;
import com.secondproject.mypage.service.MypageServiceImpl;
import com.secondproject.util.Encoding;
import com.secondproject.util.NumberCheck;

public class MypageFollowDeleteAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/index.jsp";
		String idArr = request.getParameter("id");
		String idd[] =idArr.split(",");
		int size = idd.length;
		int cnt =0;
		for(int i=0;i<size;i++) {
			cnt =MypageServiceImpl.getMypageService().followdelete(Integer.parseInt(idd[i]));
			if(cnt==0) {
				break;
			}
		}
		if(cnt!=0){
			path="/page/mypage/mypage.jsp";
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
			List<FollowUserDto> list= MypageServiceImpl.getMypageService().followListView(map);
			List<FollowCategoryDto> fclist = MypageServiceImpl.getMypageService().followCategoryListView(id);
			request.setAttribute("favoriteCategoryList", fclist);
			request.setAttribute("list", list);		
			}
		return path;
	}

}

