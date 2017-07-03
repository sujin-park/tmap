package com.secondproject.util.pagination;

import com.secondproject.constant.BoardConstant;
import com.secondproject.constant.ContextPath;
import com.secondproject.util.QueryString;

public class Pagination {

	private int currentPageNum;
	private int listCountPerPage;
	private int pageCount;
	private int totalCount;
	private int totalPageCount;
	private String startQueryString;
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

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageButtonCount) {
		this.pageCount = pageButtonCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public String getStartQueryString() {
		return startQueryString;
	}

	public void setStartQueryString(String startQueryString) {
		this.startQueryString = startQueryString;
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

	private String getPageHref(int pageNum) {
		return ContextPath.root + startQueryString + "&pg=" + pageNum + queryString;
	} 
	
	public void setHtml() {
		
		if (listCountPerPage == 0) {
			listCountPerPage = BoardConstant.LIST_SIZE;
		}
		if (pageCount == 0) {
			pageCount = BoardConstant.PAGE_SIZE;
		}
		
		totalPageCount = totalCount / listCountPerPage + 1;
		
		int startPoint = (currentPageNum - 1) / pageCount * pageCount;
		int startPageNum = startPoint + 1;
		int endPageNum = startPageNum - 1 + pageCount;
		int prevPageNum = (startPageNum - 1 > 0) ? startPageNum - 1 : 0;
		int nextPageNum = (endPageNum + 1 <= totalPageCount) ? endPageNum + 1 : 0;
		int lastPageNum = totalPageCount;
		
		String firstPageHref = "javascript:;";
		String prevPageHref = "javascript:;";
		String nextPageHref = "javascript:;";
		String lastPageHref = "javascript:;";
		String isFirstPageActive =  "class=\"disabled\"";
		String isPrevPageActive =  "class=\"disabled\"";
		String isNextPageActive =  "class=\"disabled\"";
		String isLastPageActive =  "class=\"disabled\"";
		
		if (currentPageNum != 1) {
			firstPageHref = getPageHref(1);
			isFirstPageActive = "";
		}
		
		if (prevPageNum != 0) {
			prevPageHref = getPageHref(prevPageNum);
			isPrevPageActive = "";
		}
		
		if (nextPageNum != 0) {
			nextPageHref = getPageHref(nextPageNum);
			isNextPageActive = "";
		}
		
		if (currentPageNum != totalPageCount) {
			lastPageHref = getPageHref(lastPageNum);
			isLastPageActive = "";
		}
		
		StringBuffer html = new StringBuffer();
		html.append("<nav class=\"pageNavigation\" aria-label=\"Page navigation\">\n");
		html.append("	<ul class=\"pagination\">\n");
		html.append("		<li " + isFirstPageActive + "><a href=\"" + firstPageHref + "\">처음</a></li>\n");
		html.append("		<li " + isPrevPageActive + "><a href=\"" + prevPageHref + "\" aria-label=\"Previous\"> <span aria-hidden=\"true\">이전</span></a></li>\n");
		
		for (int i = startPageNum; i <= endPageNum; i++) {
			if (i > lastPageNum) {
				break;
			}
			String isActive = (currentPageNum == i) ? "class=\"active\"" : "";
			html.append("		<li " + isActive + "><a href=\"" + getPageHref(i) + "\">" + i + "</a></li>\n");
		}
		
		html.append("		<li " + isNextPageActive + "><a href=\"" + nextPageHref + "\" aria-label=\"Next\"> <span aria-hidden=\"true\">다음</span></a></li>\n");
		html.append("		<li " + isLastPageActive + "><a href=\"" + lastPageHref + "\">끝</a></li>\n");
		html.append("	</ul>\n");
		html.append("</nav>\n");
		this.html = html.toString();
	}

}
