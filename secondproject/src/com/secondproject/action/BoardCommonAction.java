package com.secondproject.action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.secondproject.util.Encoding;
import com.secondproject.util.NumberCheck;

public class BoardCommonAction {

	private HttpServletRequest request;
	private int pg;
	private String key;
	private String word;
	private String orderKey;
	private String orderValue;
	HashMap<String, Object> parameterMap;

	protected void setBoardParameter(HttpServletRequest request) {
		this.request = request;
		pg = NumberCheck.nullToOne(getParameterAfterCheck("pg"));
		key = Encoding.nullToBlank(getParameterAfterCheck("key"));
		word = Encoding.nullToBlank(getParameterAfterEncodigCheck("word"));
		orderKey = Encoding.nullToBlank(getParameterAfterCheck("orderKey"));
		orderValue = Encoding.nullToBlank(getParameterAfterCheck("orderValue"));
		parameterMap = new HashMap<String, Object>();
		parameterMap.put("pg", pg);
		parameterMap.put("key", key);
		parameterMap.put("word", word);
		parameterMap.put("orderKey", orderKey);
		parameterMap.put("orderValue", orderValue);
	}

	private String getParameterAfterCheck(String key) {
		return whiteSpaceToBlank(request.getParameter(key));
	}

	private String getParameterAfterEncodigCheck(String key) {
		return whiteSpaceToBlank(Encoding.isoToEuc(request.getParameter(key)));
	}

	private String whiteSpaceToBlank(String tmp) {
		return tmp == null ? tmp : tmp.trim();
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

	public HashMap<String, Object> getParameterMap() {
		return parameterMap;
	}

	public void setParameterMap(HashMap<String, Object> parameterMap) {
		this.parameterMap = parameterMap;
	}

}
