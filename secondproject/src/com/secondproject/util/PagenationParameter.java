package com.secondproject.util;

import javax.servlet.http.HttpServletRequest;

public class PagenationParameter {
	private int pg;
	private String key;
	private String word;
	private String queryString;
	
	public PagenationParameter(HttpServletRequest request) {
		pg = NumberCheck.nullToOne(request.getParameter("pg"));
		key = request.getParameter("key");
		word = request.getParameter("word");
		queryString = "&pg=" + pg + "&key=" + key + "&word=" + word;
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
	
	public String getQueryString() {
		return queryString;
	}

}
