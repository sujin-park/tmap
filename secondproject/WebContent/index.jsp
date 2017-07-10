<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" import="sun.rmi.server.Dispatcher" 
import="com.secondproject.constant.*"%>
<%
RequestDispatcher dist = request.getRequestDispatcher("/main?act=ex_main");
dist.forward(request, response);
%>
