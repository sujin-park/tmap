package com.secondproject.admin.action;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.action.BoardCommonAction;
import com.secondproject.admin.service.CommonServiceImpl;
import com.secondproject.admin.service.ExhibitionServiceImpl;
import com.secondproject.constant.BoardConstant;
import com.secondproject.shop.model.ShopDto;
import com.secondproject.util.*;
import com.secondproject.util.pagination.Pagination;

public class ExhibitionShopAction extends BoardCommonAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/adminIndex.jsp";
		int seq = NumberCheck.nullToZero(request.getParameter("seq"));

		setBoardParameter(request);
		HashMap<String, Object> params = getParameterMap();
		String orderValue = (String) params.get("orderValue");
		if (orderValue.isEmpty() || orderValue.equals("asc")) {
			orderValue = "desc";
		} else if ("desc".equals(orderValue)) {
			orderValue = "asc";
		}
		params.put("orderValue", orderValue);

		List<ShopDto> list = ExhibitionServiceImpl.getExhibitionService().shopExhibition(params);
		int size = list.size();

		int totalArticleCount = CommonServiceImpl.getCommonService().totalShopListCount(params);
		Pagination pagination = new Pagination();
		pagination.setTotalCount(totalArticleCount);
		pagination.setCurrentPageNum((int) params.get("pg"));
		pagination.setListCountPerPage(BoardConstant.LIST_SIZE);
		pagination.setPageCount(BoardConstant.PAGE_SIZE);
		pagination.setStartQueryString("/exhibition?act=mvshoplist");

		ArrayList<String> filter = new ArrayList<String>();
		filter.add("pg");
		filter.add("board");
		String queryString = QueryString.getQueryString(params, filter);

		pagination.setQueryString(queryString);
		pagination.setHtml();
		
		request.setAttribute("pagination", pagination);
		request.setAttribute("exhibitionId", seq + "");
		request.setAttribute("exShopList", list);
		path = "/page/adminpage/expage/shopList.jsp";
		return path;
	}

}
