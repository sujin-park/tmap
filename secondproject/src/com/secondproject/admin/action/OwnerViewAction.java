package com.secondproject.admin.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.action.BoardCommonAction;
import com.secondproject.admin.model.OwnerConfirmDto;
import com.secondproject.admin.service.CommonServiceImpl;
import com.secondproject.admin.service.OwnerServiceImpl;
import com.secondproject.constant.BoardConstant;
import com.secondproject.util.Encoding;
import com.secondproject.util.QueryString;
import com.secondproject.util.pagination.Pagination;

public class OwnerViewAction extends BoardCommonAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setBoardParameter(request);
		String contentPath = "";
		HashMap<String, Object> params = getParameterMap();
		
		String word = Encoding.isoToEuc((String)params.get("word"));
		params.put("word", word);
		
		String orderValue = (String) params.get("orderValue");
		String act = request.getParameter("act");
		
		int confirm_ok = 0;

		if (orderValue.isEmpty()) {
			orderValue = "asc";
		}
		if (act.equals("ownerview")){
			confirm_ok = 1;
			contentPath = "owner.jsp";
		} else  {
			confirm_ok = 2;
			contentPath = "realowner.jsp";
		}
		params.put("confirm_ok", confirm_ok);
		
		ArrayList<OwnerConfirmDto> list = OwnerServiceImpl.getOwnerService().getArticles(params);
		
		if (orderValue.equals("asc")) {
			orderValue = "desc";
		} else {
			orderValue = "asc";
		}
		int totalArticleCount = CommonServiceImpl.getCommonService().totalOwnerCount(params);
		Pagination pagination = new Pagination();
		pagination.setTotalCount(totalArticleCount);
		pagination.setCurrentPageNum((int) params.get("pg"));
		pagination.setListCountPerPage(BoardConstant.LIST_SIZE);
		pagination.setPageCount(BoardConstant.PAGE_SIZE);
		pagination.setStartQueryString("/admin?act="+act);

		ArrayList<String> filter = new ArrayList<String>();
		filter.add("pg");
		filter.add("board");
		String queryString = QueryString.getQueryString(params, filter);

		pagination.setQueryString(queryString);
		pagination.setHtml();
		
		request.setAttribute("pagination", pagination);
		request.setAttribute("orderValue", orderValue);
		request.setAttribute("list", list);
		return "/page/adminpage/owner/" + contentPath;

	}

}
