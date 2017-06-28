package com.secondproject.util;

public class PageNavigation {
	private String root;
	private boolean nowFirst; // 현재 pg가BoardConstance에서 Page_size보다 작을때 true, 크면 false
	private boolean nowEnd; // 마지막 범위에 속해있는지
	private int totalArticleCount; // 전체글수
	private int newArticleCount; // 새글수
	private int totalPageCount; // 전체페이지수
	private int pageNo; // 현재페이지
	private String navigator; // 페이징
	private int listSize;
	private int pageSize;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	public boolean isNowFirst() {
		return nowFirst;
	}

	public void setNowFirst(boolean nowFirst) {
		this.nowFirst = nowFirst;
	}

	public boolean isNowEnd() {
		return nowEnd;
	}

	public void setNowEnd(boolean nowEnd) {
		this.nowEnd = nowEnd;
	}

	public int getTotalArticleCount() {
		return totalArticleCount;
	}

	public void setTotalArticleCount(int totalArticleCount) {
		this.totalArticleCount = totalArticleCount;
	}

	public int getNewArticleCount() {
		return newArticleCount;
	}

	public void setNewArticleCount(int newArticleCount) {
		this.newArticleCount = newArticleCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getNavigator() {
		return navigator;
	}

	public void setNavigator() {
		 StringBuffer tmpNavigator = new StringBuffer();
		 
		 int prePage = (pageNo -1) / pageSize * pageSize; // 마지막페이지가 40이었을때
		 
	      tmpNavigator.append("<div class=\"pgnav\"> \n");
	      tmpNavigator.append(" <ul class=\"pagination\"> \n");
	      if (this.isNowFirst()) {

	         tmpNavigator.append("  <li><a href='' aria-label=\"Previous\">");
	         tmpNavigator.append("   <span aria-hidden=\"true\"><font color=\"#ec9a25\">&laquo;</font></span>\n");
	         tmpNavigator.append("   </a></li> \n");
	      } else {

		         tmpNavigator.append("  <li><a href='javascript:listArticle("+ prePage +")' aria-label=\"Previous\">");
		         tmpNavigator.append("   <span aria-hidden=\"true\"><font color=\"#ec9a25\">&laquo;</font></span>\n");
		         tmpNavigator.append("   </a></li> \n");
	      }
	      
	      int startPage = prePage + 1;
	      int endPage = startPage + (pageSize - 1) ;
	      if (endPage > totalPageCount) {
	    	  endPage = totalPageCount; // 총 페이지의 마지막보다 위에 endPage가 더 크면 총 페이지의 마지막이 endPage가 된다. totalPage : 37 / endPage : 40
	      }
	      for (int i = startPage; i <= endPage; i++) {
	         if (pageNo == i) { // 현재페이지 글씨 크기는 색이 다름, 클릭할 수 없음
	          tmpNavigator.append("	 <li><a href='' class=\"color-orange\">" + i + "</a></li> \n");
	         } else { // 현재페이지가 아닌 다른 페이지는 클릭할 수 있고, 글씨는 다름
	          tmpNavigator.append("	 <li><a href='javascript:listArticle(" + i + ")' class=\"color-orange\">" + i + "</a></li> \n");
	         }
	      }
	      
	      if (this.isNowEnd()) {
	         tmpNavigator.append("		<li><a href='' aria-label=\"Next\"> <span aria-hidden=\"true\"> \n");
	         tmpNavigator.append("   	<font color=\"#ec9a25\">&raquo;</font></span> \n");
	         tmpNavigator.append(" 		</a></li> \n");

	      } else {
	 		 int nextPage = prePage + pageSize + 1; // 40 + 페이지사이즈에 1 하면 그 다음 페이지사이즈에서 첫번째인 51
	 		 tmpNavigator.append("		<li><a href='javascript:listArticle("+ totalPageCount +")' aria-label=\"Next\"> <span aria-hidden=\"true\"> \n");
	         tmpNavigator.append("   	<font color=\"#ec9a25\">&raquo;</font></span> \n");
	         tmpNavigator.append(" 		</a></li> \n");
	      }

	      tmpNavigator.append("  </ul>\n");
	      tmpNavigator.append(" </div>\n");

	      this.navigator = tmpNavigator.toString();
	}

}