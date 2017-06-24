package com.secondproject.shop.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.secondproject.action.Action;
import com.secondproject.shop.model.ShopDto;
import com.secondproject.shop.service.ShopServiceImpl;
import com.secondproject.util.NumberCheck;

public class ShopAddAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoryId = NumberCheck.nullToZero(request.getParameter("addShopCategory"));
		String title = request.getParameter("addShopTitle");
		Double lat = Double.parseDouble(request.getParameter("addShopLat"));
		Double lng = Double.parseDouble(request.getParameter("addShopLng"));
		int ownerId = NumberCheck.nullToZero(request.getParameter("owner_id"));
		String reserveUrl = request.getParameter("reserve_url");
		String address = request.getParameter("addShopAddress1") + " " + request.getParameter("addShopAddress2");
		String businessTime = request.getParameter("business_time");
		String tel = request.getParameter("addShopTel");
		String detail = request.getParameter("addShopDetail");
		
		// 유효성 검사 어디서??
		if (categoryId == 0) {
			
		} else if (title.trim().isEmpty()) {
			
		}
		
		ShopDto shopDto = new ShopDto();
		shopDto.setCategoryId(categoryId);
		shopDto.setTitle(title);
		shopDto.setLat(lat);
		shopDto.setLng(lng);
		shopDto.setOwnerId(ownerId);
		shopDto.setReserveUrl(reserveUrl);
		shopDto.setAddress(address);
		shopDto.setTel(tel);
		shopDto.setBusinessTime(businessTime);
		shopDto.setDetail(detail);
		
		String jsonData = ShopServiceImpl.getShopService().addShopAjax(shopDto);
		
		return jsonData;
	}

}
