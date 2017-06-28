package com.secondproject.admin.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.admin.service.*;
import com.secondproject.review.model.AdminReviewDto;
import com.secondproject.util.*;

public class ReviewListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pg = NumberCheck.nullToOne(request.getParameter("pg"));
		String key = Encoding.nullToBlank(request.getParameter("key"));
		String word = Encoding.isoToEuc(request.getParameter("word"));
		String order = Encoding.nullToBlank(request.getParameter("order"));
		String column = Encoding.nullToBlank(request.getParameter("column"));
		String board = "review";

		if (order.isEmpty() || order.equals("asc")) {
			order = "desc";
		} else if ("desc".equals(order)) {
			order = "asc";
		}

		if (column.isEmpty()) {
			column = "orderby";
		}
		List<AdminReviewDto> list = AdminReviewServiceImpl.getAdminReviewService().listReview(key, word, order, column,
				pg);
		request.setAttribute("order", order);
		request.setAttribute("column", column);
		request.setAttribute("reviewList", list);

		PageNavigation pageNavigation = CommonServiceImpl.getCommonService().makePageNavigation(pg, key, word, board);
		// root는 여기서 가져옴
		pageNavigation.setRoot(request.getContextPath());
		pageNavigation.setListSize(BoardConstance.LIST_SIZE);
		pageNavigation.setPageSize(BoardConstance.PAGE_SIZE);
		pageNavigation.setNavigator();
		request.setAttribute("navigator", pageNavigation);
		return "/page/adminpage/reviewpage/reviewList.jsp";
	}

}