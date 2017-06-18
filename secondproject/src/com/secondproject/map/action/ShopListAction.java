package com.secondproject.map.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.secondproject.action.Action;
import com.secondproject.map.model.ShopDto;
import com.secondproject.map.service.MapServiceImpl;

public class ShopListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String minLat = request.getParameter("minLat");
		String minLng = request.getParameter("minLng");
		String maxLat = request.getParameter("maxLat");
		String maxLng = request.getParameter("maxLng");
		String bounds = request.getParameter("bounds");
		System.out.println("bounds = " + bounds);
		return MapServiceImpl.getMapService().getShopListInJsonString();
	}

}
