<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	import="com.secondproject.mypage.model.*,java.util.*,com.secondproject.constant.ContextPath"%>

<% ReviewGoodBad goodbad = (ReviewGoodBad)request.getAttribute("goodbad"); %>이 리뷰가 도움이 되었습니까?&nbsp;&nbsp;
			<a href="javascript:like(<%=goodbad.getGood() %>,<%=goodbad.getBad() %>,<%=goodbad.getReview_id()%>);"><img src="<%=ContextPath.root %>/page/mypage/img/like<%=goodbad.getGood() %>.png"></a>
			<a href="javascript:hate(<%=goodbad.getGood() %>,<%=goodbad.getBad() %>,<%=goodbad.getReview_id()%>);"><img src="<%=ContextPath.root %>/page/mypage/img/hate<%=goodbad.getBad() %>.png"></a>
