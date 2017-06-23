<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" import="sun.rmi.server.Dispatcher" %>
<%

RequestDispatcher dist = request.getRequestDispatcher("/adminmain");
dist.forward(request, response);
%>
