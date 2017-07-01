package com.secondproject.admin.action;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.action.BoardCommonAction;
import com.secondproject.admin.service.*;
import com.secondproject.constant.BoardConstant;
import com.secondproject.review.model.AdminReviewDto;
import com.secondproject.util.*;
import com.secondproject.util.pagination.Pagination;

public class ReviewListAction extends BoardCommonAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String board = request.getParameter("board");
		setBoardParameter(request);
		HashMap<String, Object> params = getParameterMap();

		String orderValue = (String) params.get("orderValue");
		if (orderValue.isEmpty() || orderValue.equals("asc")) {
			orderValue = "desc";
		} else if ("desc".equals(orderValue)) {
			orderValue = "asc";
		}
		params.put("orderValue", orderValue);

		List<AdminReviewDto> list = AdminReviewServiceImpl.getAdminReviewService().listReview(params);
		int totalArticleCount = CommonServiceImpl.getCommonService().totalReviewCount(params);
		System.out.println(totalArticleCount + " total");
		Pagination pagination = new Pagination();
		pagination.setTotalCount(totalArticleCount);
		pagination.setCurrentPageNum((int) params.get("pg"));
		pagination.setListCountPerPage(BoardConstant.LIST_SIZE);
		pagination.setPageCount(BoardConstant.PAGE_SIZE);
		pagination.setStartQueryString("/admin?act=mvreview&board=" + board);

		ArrayList<String> filter = new ArrayList<String>();
		filter.add("pg");
		filter.add("board");
		String queryString = QueryString.getQueryString(params, filter);

		pagination.setQueryString(queryString);
		pagination.setHtml();
		
		request.setAttribute("pagination", pagination);
		request.setAttribute("orderValue", orderValue);
		request.setAttribute("reviewList", list);
		System.out.println(list.size() + " LIST SIZE ");

		return "/page/adminpage/reviewpage/reviewList.jsp";
	}

}