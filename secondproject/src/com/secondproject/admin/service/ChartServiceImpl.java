package com.secondproject.admin.service;

import java.util.*;

import com.google.gson.Gson;
import com.secondproject.admin.dao.ChartDaoImpl;

public class ChartServiceImpl implements ChartService {

	private static ChartService chartService;

	static {
		chartService = new ChartServiceImpl();
	}

	public static ChartService getChartService() {
		return chartService;
	}

	private ChartServiceImpl() {
	}

	@Override
	public List<Map<String, String>> ageChart() {
		return ChartDaoImpl.getChartDao().ageChart();
	}

	@Override
	public String getAgeChartJSON() {
		return new Gson().toJson(ageChart());
	}

	@Override
	public List<Map<String, String>> categoryChart(String number) {
		return ChartDaoImpl.getChartDao().categoryChart(number);
	}

	@Override
	public String getCategoryJSON(String number) {
		return new Gson().toJson(categoryChart(number));
	}

	@Override
	public List<Map<String, String>> areaChart() {
		return ChartDaoImpl.getChartDao().areaChart();
	}

	@Override
	public String getAreaJSON() {
		return new Gson().toJson(areaChart());
	}

}