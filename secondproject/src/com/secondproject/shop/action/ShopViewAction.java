package com.secondproject.shop.action;

import java.io.IOException;
import java.util.ArrayList;
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
import com.secondproject.util.Encoding;
import com.secondproject.util.NumberCheck;
import com.secondproject.util.Params;

public class ShopViewAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int shopId = NumberCheck.nullToZero(request.getParameter("shopId"));
		ShopDto shopDto = ShopServiceImpl.getShopService().getShop(shopId);
		
		Params params = new Params(request);
		List<ReviewListDto> reviewList = ReviewServiceImpl.getReviewService().getReviewListByShopNotBlind(params);
		request.setAttribute("shopDto", shopDto);
		request.setAttribute("reviewList", reviewList);
		return "/page/shop/shop.jsp";
	}

}
