package com.secondproject.shop.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.action.BoardCommonAction;
import com.secondproject.constant.BoardConstant;
import com.secondproject.constant.ContextPath;
import com.secondproject.review.model.ReviewListDto;
import com.secondproject.review.service.ReviewServiceImpl;
import com.secondproject.shop.model.ShopDto;
import com.secondproject.shop.service.ShopServiceImpl;
import com.secondproject.util.NumberCheck;
import com.secondproject.util.QueryString;
import com.secondproject.util.pagination.Pagination;
import com.secondproject.util.search.Search;

public class ShopViewAction extends BoardCommonAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "";
		setBoardParameter(request);
		int shopId = NumberCheck.nullToZero(request.getParameter("shopId"));
		
		HashMap<String, Object> params = getParameterMap();
		params.put("shopId", shopId);
		params.put("act", request.getParameter("act"));
		
		LinkedHashMap<String, String> searchKey = new LinkedHashMap<String, String>();
		searchKey.put("title", "리뷰명");
		searchKey.put("userEmail", "회원아이디");
		
		HashMap<String, Object> inputHiddenList = new HashMap<String, Object>();
		inputHiddenList.put("act", "view");
		inputHiddenList.put("shopId", shopId);
		
		Search search = new Search();
		search.setFormActionValue(ContextPath.root + "/shop");
		search.setDefaultKey("title");
		search.setParams(params);
		search.setSearchKey(searchKey);
		search.setInputHiddenList(inputHiddenList);
		search.setHtml();
		
		ShopDto shopDto = ShopServiceImpl.getShopService().getShop(shopId);
		if (shopDto != null) {
			List<ReviewListDto> reviewList = ReviewServiceImpl.getReviewService().getReviewListByShopNotBlind(params);
			int reviewListTotalCount = ReviewServiceImpl.getReviewService().getTotalCountByShopNotBlind(params);
			
			Pagination pagination = new Pagination();
			pagination.setTotalCount(reviewListTotalCount);
			pagination.setCurrentPageNum((int) params.get("pg"));
			pagination.setListCountPerPage(BoardConstant.SHOP_REVIEW_LIST_COUNT_PER_PAGE);
			pagination.setPageCount(BoardConstant.SHOP_REVIEW_PAGE_COUNT);
			pagination.setStartQueryString("/shop?act=view&shopId=" + shopId);
			
			ArrayList<String> filter = new ArrayList<String>();
			filter.add("pg");
			filter.add("shopId");
			String queryString = QueryString.getQueryString(params, filter);
			
			pagination.setQueryString(queryString);
			pagination.setHtml();
			
			request.setAttribute("pagination", pagination.getHtml());
			request.setAttribute("shopDto", shopDto);
			request.setAttribute("reviewList", reviewList);
			request.setAttribute("searchForm", search.getHtml());
			path = "/page/shop/shop.jsp";
		} else {
			path = "/page/error/error.jsp";
		}
		
		return path;
	}
}
