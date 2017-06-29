package com.secondproject.admin.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.admin.service.AdminReviewServiceImpl;
import com.secondproject.review.model.AdminReviewDto;
import com.secondproject.util.Encoding;
import com.secondproject.util.NumberCheck;

public class ReviewBlindOneAction implements Action {

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
		
		int reviewseq = Integer.parseInt(request.getParameter("reviewseq"));
		String reviews[] = new String[1];
		reviews[0] = reviewseq +"";
		
		int cnt = AdminReviewServiceImpl.getAdminReviewService().blindExhibition(reviews);
		List<AdminReviewDto> list = AdminReviewServiceImpl.getAdminReviewService().listReview(key, word, order, column, pg);
		request.setAttribute("reviewList", list);
		return "/page/adminpage/reviewpage/reviewBlind.jsp";
	}

}
