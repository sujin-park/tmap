package com.secondproject.util;

import javax.servlet.http.HttpServletRequest;

public class Params {
	
	private HttpServletRequest request;
	private int pg;
	private String key;
	private String word;
	private String orderKey;
	private String orderValue;

	public Params(HttpServletRequest request) {
		this.request = request;
		pg = NumberCheck.nullToOne(getParameterAfterCheck("pg"));
		key = Encoding.nullToBlank(getParameterAfterCheck("key"));
		word = Encoding.nullToBlank(getParameterAfterCheck("word"));
		orderKey = Encoding.nullToBlank(getParameterAfterCheck("orderKey"));
		orderValue = Encoding.nullToBlank(getParameterAfterCheck("orderValue"));
	}

	private String getParameterAfterCheck(String key) {
		return whiteSpaceToBlank(request.getParameter(key));
	}
	
	private String whiteSpaceToBlank(String tmp) {
		return tmp != null ? tmp.trim() : tmp;
	}
	
	public String getQueryString() {
		return "&pg=" + pg + "&key=" + key + "&word=" + word + "&orderKey="  + orderKey + "&orderValue=" + orderValue;
	}

	public String getStartQueryString() {
		String queryString = getQueryString();
		return "?" + queryString.substring(1, queryString.length());
	}

	public int getPg() {
		return pg;
	}

	public void setPg(int pg) {
		this.pg = pg;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getOrderKey() {
		return orderKey;
	}

	public void setOrderKey(String orderKey) {
		this.orderKey = orderKey;
	}

	public String getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(String orderValue) {
		this.orderValue = orderValue;
	}

}
