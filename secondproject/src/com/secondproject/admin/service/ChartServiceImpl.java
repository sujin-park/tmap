package com.secondproject.admin.service;

import java.util.*;

import com.google.gson.Gson;
import com.secondproject.admin.dao.ChartDao;
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
	public List<Map<String, String>> ageChart(String snum) {
		return ChartDaoImpl.getChartDao().ageChart(snum);
	}

	@Override
	public String getAgeChartJSON(String snum) {
		return new Gson().toJson(ageChart(snum));
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
	public List<Map<String, String>> areaChart(String num) {
		return ChartDaoImpl.getChartDao().areaChart(num);
	}

	@Override
	public String getAreaJSON(String num) {
		return new Gson().toJson(areaChart(num));
	}

	@Override
	public List<Map<String, String>> ageYearChart() {
		return ChartDaoImpl.getChartDao().ageYearChart();
	}

	@Override
	public String getAgeYearJSON() {
		return new Gson().toJson(ageYearChart());
	}

}