<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" import="com.secondproject.constant.*, com.secondproject.userdto.UserDto"%>
<%
	UserDto userDto = (UserDto) session.getAttribute("logininfo");
%>
<div id="header-container">
	<header id="header">
		<h1 id="logo"><a href="<%=ContextPath.root%>">Tmap</a></h1>
		<ul class="nav-container">
			<li><a href="<%=ContextPath.root%>/map" class="nav-btn btn-map"><i class="fa fa-map-marker" aria-hidden="true"></i>MAP</a></li>
			<li><a href="javascript:loginmove();" class="nav-btn btn-login">LOGIN</a></li>
		</ul>
	</header>
</div>