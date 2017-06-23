<?xml version="1.0" encoding="utf-8"?>
<%@ page language="java" contentType="text/xml; charset=utf-8"
    pageEncoding="utf-8" import="com.secondproject.mypage.model.*"%>
<%

FollowCategoryDto fcdto = (FollowCategoryDto) request.getAttribute("favoriteCategory");
%>    
<category>
   <cateid><%=fcdto.getFollowCategoryId() %></cateid>
	<order><%=fcdto.getCategoryOrder()%></order>
	<name><%=fcdto.getCategoryName()%></name>
</category>				