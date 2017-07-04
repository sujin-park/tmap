<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%

RequestDispatcher dist = request.getRequestDispatcher("/admin?act=userview");
dist.forward(request, response);
%>