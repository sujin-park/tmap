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
import com.secondproject.util.Encoding;
import com.secondproject.util.NumberCheck;
import com.secondproject.util.PageNavigation;

public class MypageFollowCategoryModifyAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String seq = request.getParameter("seq");
		int cateId = NumberCheck.nullToZero(request.getParameter("id"));
		String seqArr[] =seq.split(",");
		int size = seqArr.length;
		int cnt =0;
		for(int i=0;i<size;i++) {
			
			cnt =MypageServiceImpl.getMypageService().followCategoryModify(cateId,Integer.parseInt(seqArr[i]));
			if(cnt==0) {
				break;
			}
			
			
		}
		int pg = NumberCheck.nullToOne(request.getParameter("pg"));
		String key = Encoding.nullToBlank(request.getParameter("key"));
		String word = Encoding.nullToBlank(request.getParameter("word"));
		String control = request.getParameter("control");
		Map<String,String> map = new HashMap<String, String>();
		map.put("pg", pg+"");
		map.put("key", key);
		map.put("word", word);
		map.put("control", control);
		map.put("userId", 2+"");
		int end = pg * BoardConstant.MYPAGE_LIST_SIZE;
		int start = end -BoardConstant.MYPAGE_LIST_SIZE;
		map.put("start", start+"");
		map.put("end", end+"");
		List<FollowUserDto> list= MypageServiceImpl.getMypageService().followListView(map);
		List<FollowCategoryDto> fclist = MypageServiceImpl.getMypageService().followCategoryListView(map);
		request.setAttribute("favoriteCategoryList", fclist);
		request.setAttribute("list", list);
		PageNavigation pageNavigation = CommonServiceImpl.getCommonService().mypagePageNavigation(pg, key, word, control);
		pageNavigation.setRoot(request.getContextPath());
		pageNavigation.setListSize(BoardConstant.MYPAGE_LIST_SIZE);
		pageNavigation.setPageSize(BoardConstant.MYPAGE_PAGE_SIZE);
		
		pageNavigation.setNavigator();
		request.setAttribute("navigator", pageNavigation);
		return "/page/mypage/mypage.jsp";
	}

}
