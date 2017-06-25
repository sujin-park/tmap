package com.secondproject.mypage.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.mypage.model.FollowCategoryDto;
import com.secondproject.mypage.model.FollowUserDto;
import com.secondproject.mypage.service.MypageServiceImpl;

public class MypageFollowDeleteAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/index.jsp";
		String idArr = request.getParameter("id");
		String id[] =idArr.split(",");
		int size = id.length;
		int cnt =0;
		for(int i=0;i<size;i++) {
			cnt =MypageServiceImpl.getMypageService().followdelete(Integer.parseInt(id[i]));
			if(cnt==0) {
				break;
			}
		}
		if(cnt!=0){
			path="/page/mypage/mypage.jsp";
			int idd = 2;
			List<FollowUserDto> list= MypageServiceImpl.getMypageService().followListView(idd);
			List<FollowCategoryDto> fclist = MypageServiceImpl.getMypageService().followCategoryListView(idd);
			request.setAttribute("favoriteCategoryList", fclist);
			request.setAttribute("list", list);		
			}
		return path;
	}

}

