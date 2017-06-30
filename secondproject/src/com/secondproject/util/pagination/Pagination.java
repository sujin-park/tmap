package com.secondproject.util.pagination;

import com.secondproject.constant.ContextPath;
import com.secondproject.util.Params;

public class Pagination {

	private int currentPageNum;
	private int listCountPerPage;
	private int pageButtonCount;
	private int totalCount;
	private int totalPageCount;
	private String queryString;
	private String html;

	public int getCurrentPageNum() {
		return currentPageNum;
	}

	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}

	public int getListCountPerPage() {
		return listCountPerPage;
	}

	public void setListCountPerPage(int listCountPerPage) {
		this.listCountPerPage = listCountPerPage;
	}

	public int getPageButtonCount() {
		return pageButtonCount;
	}

	public void setPageButtonCount(int pageButtonCount) {
		this.pageButtonCount = pageButtonCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml() {
		totalPageCount = totalCount / listCountPerPage + 1;
		
		int startPageNum = ((currentPageNum - 1) / pageButtonCount * pageButtonCount) + 1;
		int endPageNum = startPageNum - 1 + pageButtonCount;
		
		int prevPageNum = 0;
		int nextPageNum = 0;
		int lastPageNum = totalPageCount;
		
		StringBuffer html = new StringBuffer();
		html.append("<nav aria-label=\"Page navigation\">\n");
		html.append("	<ul class=\"pagination\">\n");
		html.append("		<li><a href=\"#\">처음</a></li>\n");
		html.append("		<li><a href=\"#\" aria-label=\"Previous\"> <span aria-hidden=\"true\">이전</span></a></li>\n");
		
		for (int i = startPageNum; i <= endPageNum; i++) {
			html.append("		<li><a href=\"#\">" + i + "</a></li>\n");
		}
		
		html.append("		<li><a href=\"#\">2</a></li>\n");
		html.append("		<li><a href=\"#\">3</a></li>\n");
		html.append("		<li><a href=\"#\">4</a></li>\n");
		html.append("		<li><a href=\"#\">5</a></li>\n");
		html.append("		<li><a href=\"#\" aria-label=\"Next\"> <span aria-hidden=\"true\">다음</span></a></li>\n");
		html.append("		<li><a href=\"#\">끝</a></li>\n");
		html.append("	</ul>\n");
		html.append("</nav>\n");
		this.html = html.toString();
	}

}
