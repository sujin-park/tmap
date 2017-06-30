package com.secondproject.shop.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.review.model.ReviewListDto;
import com.secondproject.review.service.ReviewServiceImpl;
import com.secondproject.shop.model.ShopDto;
import com.secondproject.shop.service.ShopServiceImpl;
import com.secondproject.util.NumberCheck;
import com.secondproject.util.PageNavigation;
import com.secondproject.util.Params;
import com.secondproject.util.pagination.Pagination;

public class ShopViewAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int shopId = NumberCheck.nullToZero(request.getParameter("shopId"));
		
		HashMap<String, Object> optionParams = new HashMap<String, Object>();
		optionParams.put("shopId", shopId);
		Params params = new Params(request, optionParams);
		
		ShopDto shopDto = ShopServiceImpl.getShopService().getShop(shopId);
		List<ReviewListDto> reviewList = ReviewServiceImpl.getReviewService().getReviewListByShopNotBlind(params);
		int reviewListTotalCount = ReviewServiceImpl.getReviewService().getTotalCountByShopNotBlind(params);
		
		Pagination pagination = new Pagination();
		pagination.setTotalCount(reviewListTotalCount);
		pagination.setCurrentPageNum(params.getPg());
		pagination.setListCountPerPage(6);
		pagination.setPageButtonCount(5);
		pagination.setQueryString(params.getQueryStringWithoutPg());
		System.out.println(params.getQueryStringWithoutPg());
		pagination.setHtml();
		
		request.setAttribute("pagination", pagination);
		request.setAttribute("params", params);
		request.setAttribute("shopDto", shopDto);
		request.setAttribute("reviewList", reviewList);
		
		return "/page/shop/shop.jsp";
	}

}
