<%@page import="com.secondproject.constant.ContextPath"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
int shopId = (Integer) request.getAttribute("shopId");
%>
<script>
alert('삭제되었습니다.');
location.href="<%=ContextPath.root%>/shop?act=view&shopId=<%=shopId%>";
</script>