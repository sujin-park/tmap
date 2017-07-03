<%@page import="com.secondproject.constant.ContextPath"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" import="com.secondproject.userdto.UserDto"%>
<script>
	alert('로그인 되었습니다.');
	location.href = "<%=ContextPath.root%>/";
</script>