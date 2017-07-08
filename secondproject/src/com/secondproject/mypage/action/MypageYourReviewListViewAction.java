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
import com.secondproject.mypage.dao.MypageFollowDaoImpl;
import com.secondproject.mypage.model.FollowUserDto;
import com.secondproject.mypage.model.MyReviewDto;
import com.secondproject.mypage.service.MypageReviewServiceImpl;
import com.secondproject.mypage.service.MypageServiceImpl;
import com.secondproject.userdto.UserDto;
import com.secondproject.util.NumberCheck;
import com.secondproject.util.QueryString;
import com.secondproject.util.pagination.Pagination;

public class MypageYourReviewListViewAction extends BoardCommonAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/page/mypage/yourreview.jsp";
		
		
		
		int followUserId = NumberCheck.nullToZero(request.getParameter("followUserId"));
		setBoardParameter(request);
		HashMap<String, Object> params = getParameterMap();
		params.put("userId", followUserId);
		int totalReviewCount =  MypageReviewServiceImpl.getMypageReviewService().totalReviewCount(params);
		List<MyReviewDto> list = MypageReviewServiceImpl.getMypageReviewService().reviewListView(params);
		UserDto fudto = MypageFollowDaoImpl.getMypageFollowDao().getUser(followUserId);
		Pagination pagination = new Pagination();
		pagination.setTotalCount(totalReviewCount);
		pagination.setCurrentPageNum((int) params.get("pg"));
		pagination.setListCountPerPage(BoardConstant.MYREVIEW_PAGE_SIZE);
		pagination.setPageCount(BoardConstant.MYREVIEW_PAGE_SIZE);
		pagination.setStartQueryString("/myreview?act=yourreview&followUserId"+followUserId);
		
		ArrayList<String> filter = new ArrayList<String>();
		filter.add("pg");
		String queryString = QueryString.getQueryString(params, filter);
		
		pagination.setQueryString(queryString);
		pagination.setHtml();
		
		request.setAttribute("pagination", pagination);
		request.setAttribute("followUserDto", fudto);
		
		request.setAttribute("reviewlist", list);
		return path;
	}

}

