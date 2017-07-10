package com.secondproject.admin.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.action.BoardCommonAction;
import com.secondproject.admin.model.ShopInfoDto;
import com.secondproject.admin.service.*;
import com.secondproject.constant.BoardConstant;
import com.secondproject.util.Encoding;
import com.secondproject.util.QueryString;
import com.secondproject.util.pagination.Pagination;

public class ShopInfoAction extends BoardCommonAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		setBoardParameter(request);
		HashMap<String, Object> params = getParameterMap();
		
		String orderValue = (String) params.get("orderValue");
		if (orderValue.isEmpty()) {
			orderValue = "asc";
		}
		ArrayList<ShopInfoDto> shoplist= ShopInfoServiceImpl.getShopInfoService().getArticles(params);
		
		if (orderValue.equals("asc")) {
			orderValue = "desc";
		} else {
			orderValue = "asc";
		}
		
		int totalUserCount = CommonServiceImpl.getCommonService().totalShopListCount(params);
		Pagination pagination = new Pagination();
		pagination.setTotalCount(totalUserCount);
		pagination.setCurrentPageNum((int) params.get("pg"));
		pagination.setListCountPerPage(BoardConstant.SHOP_REVIEW_LIST_COUNT_PER_PAGE);
		pagination.setPageCount(BoardConstant.SHOP_REVIEW_PAGE_COUNT);
		pagination.setStartQueryString("/admin?act=shopinfo");
		
		ArrayList<String> filter = new ArrayList<String>();
		filter.add("pg");
		String queryString = QueryString.getQueryString(params, filter);
		
		pagination.setQueryString(queryString);
		pagination.setHtml();
		
		request.setAttribute("pagination", pagination);
		request.setAttribute("orderValue", orderValue);
		request.setAttribute("list", shoplist);
		return "/page/adminpage/shop/shopinfo.jsp";
	}

}
