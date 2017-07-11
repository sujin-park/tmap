package com.secondproject.admin.service;

import java.util.List;
import java.util.Map;


public interface ChartService {
	// 연령대별
	List<Map<String, String>> ageChart(String snum);
	String getAgeChartJSON(String snum);
	
	// 성별 2000 - 2017
	List<Map<String, String>> ageYearChart();
	String getAgeYearJSON();
	
	List<Map<String, String>> ageMonthChart(String snum);
	String getAgeMonthJSON(String snum);
	
	List<Map<String, String>> categoryChart(String number);
	String getCategoryJSON(String number);
	
	List<Map<String, String>> areaChart(String num);
	String getAreaJSON(String num);
}
