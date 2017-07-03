package com.secondproject.admin.service;

import java.util.List;
import java.util.Map;


public interface ChartService {
	List<Map<String, String>> ageChart();
	String getAgeChartJSON();
	
	List<Map<String, String>> categoryChart(String number);
	String getCategoryJSON(String number);
	
	List<Map<String, String>> areaChart();
	String getAreaJSON();
}
