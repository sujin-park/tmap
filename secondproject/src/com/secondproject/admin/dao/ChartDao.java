package com.secondproject.admin.dao;

import java.util.List;
import java.util.Map;

public interface ChartDao {

	List<Map<String, String>> ageChart(String snum);

	List<Map<String, String>> ageYearChart(); // ³²ÀÚ

	List<Map<String, String>> ageMonthChart(String snum);
	
	List<Map<String, String>> categoryChart(String number);

	List<Map<String, String>> areaChart(String num);
}
