package com.secondproject.map.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.secondproject.action.Action;
import com.secondproject.map.service.MapServiceImpl;
import com.secondproject.util.map.Bounds;

public class ShopListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bounds bounds = new Gson().fromJson(request.getParameter("bounds"), Bounds.class);
//		System.out.println("bounds._min._lat = " + bounds._min._lat);
//		System.out.println("bounds._min._lng = " + bounds._min._lng);
//		System.out.println("bounds._max._lat = " + bounds._max._lat);
//		System.out.println("bounds._max._lng = " + bounds._max._lng);
		return MapServiceImpl.getMapService().getShopListJSON(bounds);
	}

}
