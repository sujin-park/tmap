<%@page import="com.secondproject.constant.ContextPath"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<script>
alert("일치하는 정보가 없습니다.\n확인 후 다시 시도해 주세요.");
location.href="<%=ContextPath.root%>";
</script>