package com.secondproject.admin.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.action.BoardCommonAction;
import com.secondproject.admin.service.CommonServiceImpl;
import com.secondproject.admin.service.UserViewServiceImpl;
import com.secondproject.constant.BoardConstant;
import com.secondproject.userdto.UserDto;
import com.secondproject.util.Encoding;
import com.secondproject.util.QueryString;
import com.secondproject.util.pagination.Pagination;

public class UserViewAction extends BoardCommonAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setBoardParameter(request);
		HashMap<String, Object> params = getParameterMap();
		String key = (String) params.get("key");
		String word = Encoding.isoToEuc((String)params.get("word"));
		String orderValue = (String) params.get("orderValue");
		// userOrder 내림차순  / column 컬럼명 type : 검색조건 / keyword = word
		if (orderValue.isEmpty()) {
			orderValue = "asc";
		}

		if ("type".equals(key) && "회원".equals(word)) {
			word = "1";
		} else if ("type".equals(key) && "사장".equals(word)) {
			word = "2";
		} else if ("gender".equals(key) && "남성".equals(word)) {
			word = "1";
		} else if ("gender".equals(key) && "여성".equals(word)) {
			word = "2";
		}
		params.put("word", word);
		
		ArrayList<UserDto> list = UserViewServiceImpl.getUserViewService().getArticles(params);

		if (orderValue.equals("asc")) {
			orderValue = "desc";
		} else {
			orderValue = "asc";
		}
		int totalUserCount = CommonServiceImpl.getCommonService().totalUserCount(params);
		Pagination pagination = new Pagination();
		pagination.setTotalCount(totalUserCount);
		pagination.setCurrentPageNum((int) params.get("pg"));
		pagination.setListCountPerPage(BoardConstant.LIST_SIZE);
		pagination.setPageCount(BoardConstant.PAGE_SIZE);
		pagination.setStartQueryString("/admin?act=userview");
		
		ArrayList<String> filter = new ArrayList<String>();
		filter.add("pg");
		String queryString = QueryString.getQueryString(params, filter);
		
		pagination.setQueryString(queryString);
		pagination.setHtml();
		
		
		request.setAttribute("pagination", pagination);
		request.setAttribute("orderValue", orderValue);
		request.setAttribute("list", list);
		return "/page/adminpage/member/member.jsp";

	}

}
