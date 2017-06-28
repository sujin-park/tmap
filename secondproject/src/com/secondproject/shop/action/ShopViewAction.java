package com.secondproject.shop.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.review.model.ReviewDto;
import com.secondproject.review.service.ReviewServiceImpl;
import com.secondproject.shop.model.ShopDto;
import com.secondproject.shop.service.ShopServiceImpl;
import com.secondproject.util.NumberCheck;
import com.secondproject.util.PagenationParameter;

public class ShopViewAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int shopId = NumberCheck.nullToZero(request.getParameter("shopId"));
		ShopDto shopDto = ShopServiceImpl.getShopService().getShop(shopId);
		PagenationParameter pagenationParameter = new PagenationParameter(request);
		List<ReviewDto> reviewList = ReviewServiceImpl.getReviewService().getReviewList(pagenationParameter);
		request.setAttribute("shopDto", shopDto);
		request.setAttribute("reviewList", reviewList);
		return "/page/shop/shop.jsp";
	}

}
