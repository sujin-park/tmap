package com.secondproject.util;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public class Params {

	private HttpServletRequest request;
	private int pg;
	private String key;
	private String word;
	private String orderKey;
	private String orderValue;
	private HashMap<String, Object> optionParams;

	public Params(HttpServletRequest request) {
		this(request, null);
	}
	
	public Params(HttpServletRequest request, HashMap<String, Object> optionParams) {
		this.request = request;
		this.optionParams = optionParams;
		pg = NumberCheck.nullToOne(getParameterAfterCheck("pg"));
		key = Encoding.nullToBlank(getParameterAfterCheck("key"));
		word = Encoding.nullToBlank(getParameterAfterCheck("word"));
		orderKey = Encoding.nullToBlank(getParameterAfterCheck("orderKey"));
		orderValue = Encoding.nullToBlank(getParameterAfterCheck("orderValue"));
	}

	public Object getOptionValue(String key) {
		return optionParams.get(key);
	}
	
	private String getParameterAfterCheck(String key) {
		return whiteSpaceToBlank(request.getParameter(key));
	}

	private String whiteSpaceToBlank(String tmp) {
		return tmp == null ? tmp : tmp.trim();
	}

	public String getQueryString() {
		return "&pg=" + pg + "&key=" + key + "&word=" + word + "&orderKey=" + orderKey + "&orderValue=" + orderValue;
	}

	public String getStartQueryString() {
		String queryString = getQueryString();
		return "?" + queryString.substring(1, queryString.length());
	}

	public String getQueryStringWithoutPg() {
		return "&key=" + key + "&word=" + word + "&orderKey=" + orderKey + "&orderValue=" + orderValue;
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
