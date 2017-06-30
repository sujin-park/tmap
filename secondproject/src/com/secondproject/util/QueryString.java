package com.secondproject.util;

import java.util.List;
import java.util.Map;

public class QueryString {

	public static String getQueryString(Map<String, Object> map) {
		StringBuffer queryString = new StringBuffer();
		for (String key : map.keySet()) {
			queryString.append("&" + key + "=" + map.get(key));
		}
		return queryString.toString();
	}

	public static String getQueryString(Map<String, Object> map, String withoutkey) {
		map.remove(withoutkey);
		return getQueryString(map);
	}

	public static String getQueryString(Map<String, Object> map, List<String> withoutKeys) {
		for (String key : withoutKeys) {
			map.remove(key);
		}
		return getQueryString(map);
	}
	
	public static String getStartQueryString(String queryString) {
		return "?" + queryString.substring(1, queryString.length());
	}

	public static String getStartQueryString(Map<String, Object> map, String withoutkey) {
		return getStartQueryString(getQueryString(map, withoutkey));
	}

	public static String getStartQueryString(Map<String, Object> map, List<String> withoutKeys) {
		return getStartQueryString(getQueryString(map, withoutKeys));
	}
}
