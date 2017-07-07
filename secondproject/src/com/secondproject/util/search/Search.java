package com.secondproject.util.search;

import java.util.LinkedHashMap;
import java.util.Map;

public class Search {

	private String html;
	private String defaultKey;
	private String formActionValue;
	private LinkedHashMap<String, String> searchKeyMap;
	private Map<String, Object> params;
	private String inputWordName = "word";
	private Map<String, Object> inputHiddenList;

	public void setHtml() {
		if (searchKeyMap.size() != 0) {
			String key = (String) params.get("key");
			String keyValue = (String) searchKeyMap.get(key); // 키값에 대한 한글명
			String word = (String) params.get("word");

			// String orderKey = (String) params.get("orderKey");
			// String orderValue = (String) params.get("orderValue");

			StringBuffer html = new StringBuffer();
			html.append("<form action=\"" + formActionValue + "\" id=\"commonBoardSearchForm\">");
			// html.append(" <input type=\"hidden\" name=\"orderKey\" value=\""
			// + orderKey + "\" />");
			// html.append(" <input type=\"hidden\" name=\"orderValue\"
			// value=\"" + orderValue + "\" />");
			
			if (inputHiddenList.size() > 0) {
				for (String k : inputHiddenList.keySet()) {
					html.append("	<input type=\"hidden\" name=\"" + k + "\" value=\"" + inputHiddenList.get(k) + "\"/>");
				}
			}
			
			if (key == null || key.isEmpty()) {
				key = defaultKey;
				keyValue = searchKeyMap.get(defaultKey);
			}
			html.append("	<input type=\"hidden\" name=\"key\" value=\"" + key + "\"/>");
			
			html.append("	<div class=\"input-group\">");
			html.append("		<div class=\"input-group-btn\">");
			html.append("			<button type=\"button\" class=\"btn btn-default dropdown-toggle\" data-toggle=\"dropdown\">");
			html.append("				<span id=\"commonBoardSearchFormKeyView\">" + keyValue + "</span>&nbsp;<span class=\"caret\"></span>");
			html.append("			</button>");
			html.append("			<ul class=\"dropdown-menu\">");

			for (String k : searchKeyMap.keySet()) {
				html.append("				<li><a href=\"javascript:changeCommonBoardSearchKey('" + searchKeyMap.get(k) + "', '" + k + "');\">" + searchKeyMap.get(k) + "</a></li>");
			}

			html.append("			</ul>");
			html.append("		</div>");
			html.append("		<input type=\"text\" name=\"" + inputWordName + "\" class=\"form-control\" value=\""
					+ word + "\">");
			html.append("		<span class=\"input-group-btn\">");
			html.append("			<button class=\"btn btn-default\" type=\"submit\">검색</button>");
			html.append("		</span>");
			html.append("	</div>");
			html.append("</form>");
			this.html = html.toString();
		}
	}

	public void setDefaultKey(String defaultKey) {
		this.defaultKey = defaultKey;
	}

	public void setInputHiddenList(Map<String, Object> inputHiddenList) {
		this.inputHiddenList = inputHiddenList;
	}

	public void setFormActionValue(String formActionValue) {
		this.formActionValue = formActionValue;
	}

	public void setSearchKey(LinkedHashMap<String, String> searchKey) {
		this.searchKeyMap = searchKey;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public void setInputWordName(String inputWordName) {
		this.inputWordName = inputWordName;
	}

	public String getHtml() {
		return html;
	}
}
