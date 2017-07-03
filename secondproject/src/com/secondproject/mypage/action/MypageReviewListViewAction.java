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
import com.secondproject.mypage.model.MyReviewDto;
import com.secondproject.mypage.service.MypageReviewServiceImpl;
import com.secondproject.userdto.UserDto;
import com.secondproject.util.QueryString;
import com.secondproject.util.pagination.Pagination;

public class MypageReviewListViewAction extends BoardCommonAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/page/mypage/myreview.jsp";
		
		
		
		HttpSession session = request.getSession();
		UserDto udto = (UserDto)session.getAttribute("logininfo");
		if(udto!=null) {
		int userId = udto.getUser_id();
		setBoardParameter(request);
		HashMap<String, Object> params = getParameterMap();
		params.put("userId", userId);
		int totalReviewCount =  MypageReviewServiceImpl.getMypageReviewService().totalReviewCount(params);
		List<MyReviewDto> list = MypageReviewServiceImpl.getMypageReviewService().reviewListView(params);
		Pagination pagination = new Pagination();
		pagination.setTotalCount(totalReviewCount);
		pagination.setCurrentPageNum((int) params.get("pg"));
		pagination.setListCountPerPage(BoardConstant.MYREVIEW_PAGE_SIZE);
		pagination.setPageCount(BoardConstant.MYREVIEW_PAGE_SIZE);
		pagination.setStartQueryString("/myreview?act=myreviewView");
		
		ArrayList<String> filter = new ArrayList<String>();
		filter.add("pg");
		String queryString = QueryString.getQueryString(params, filter);
		
		pagination.setQueryString(queryString);
		pagination.setHtml();
		
		request.setAttribute("pagination", pagination);

		request.setAttribute("reviewlist", list);
		} else {
			path="/index.jsp";
		}
		return path;
	}

}

