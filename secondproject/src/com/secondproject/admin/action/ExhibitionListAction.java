package com.secondproject.admin.action;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.action.BoardCommonAction;
import com.secondproject.admin.model.ExhibitionDetailDto;
import com.secondproject.admin.model.ExhibitionDto;
import com.secondproject.admin.service.CommonServiceImpl;
import com.secondproject.admin.service.ExhibitionServiceImpl;
import com.secondproject.constant.BoardConstant;
import com.secondproject.map.model.ShopDto;
import com.secondproject.util.*;
import com.secondproject.util.pagination.Pagination;

public class ExhibitionListAction extends BoardCommonAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/adminIndex.jsp";
		String board = request.getParameter("board");
		setBoardParameter(request);
		HashMap<String, Object> params = getParameterMap();

		// pg, key, word, orderKey, orderValue
		String orderValue = (String) params.get("orderValue");
		if (orderValue.isEmpty() || orderValue.equals("asc")) {
			orderValue = "desc";
		} else if ("desc".equals(orderValue)) {
			orderValue = "asc";
		}
		params.put("orderValue", orderValue);

		List<ExhibitionDto> list = ExhibitionServiceImpl.getExhibitionService().listExhibition(params);
		
		int totalArticleCount = CommonServiceImpl.getCommonService().totalExhibitionCount(params);
		Pagination pagination = new Pagination();
		pagination.setTotalCount(totalArticleCount);
		pagination.setCurrentPageNum((int) params.get("pg"));
		pagination.setListCountPerPage(BoardConstant.LIST_SIZE);
		pagination.setPageCount(BoardConstant.PAGE_SIZE);
		pagination.setStartQueryString("/admin?act=mvexhibition&board=" + board);

		ArrayList<String> filter = new ArrayList<String>();
		filter.add("pg");
		filter.add("board");
		String queryString = QueryString.getQueryString(params, filter);

		pagination.setQueryString(queryString);
		pagination.setHtml();

		request.setAttribute("exhibitionList", list);
		request.setAttribute("pagination", pagination);
		request.setAttribute("orderValue", (String) params.get("orderValue"));
		
		if (board.equals("exhibition")) {
			path = "/page/adminpage/expage/exhibition.jsp";
		} else {
			path = "/page/adminpage/expage/exhibitionPic.jsp";
		}
		return path;
	}

}