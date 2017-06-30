package com.secondproject.shop.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.action.BoardCommonAction;
import com.secondproject.constant.BoardConstant;
import com.secondproject.review.model.ReviewListDto;
import com.secondproject.review.service.ReviewServiceImpl;
import com.secondproject.shop.model.ShopDto;
import com.secondproject.shop.service.ShopServiceImpl;
import com.secondproject.util.*;
import com.secondproject.util.pagination.Pagination;

public class ShopViewAction extends BoardCommonAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setBoardParameter(request);
		int shopId = NumberCheck.nullToZero(request.getParameter("shopId"));
		
		HashMap<String, Object> params = getParameterMap();
		params.put("shopId", shopId);
		
		ShopDto shopDto = ShopServiceImpl.getShopService().getShop(shopId);
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
		
		request.setAttribute("pagination", pagination);
		request.setAttribute("shopDto", shopDto);
		request.setAttribute("reviewList", reviewList);
		
		return "/page/shop/shop.jsp";
	}
}
