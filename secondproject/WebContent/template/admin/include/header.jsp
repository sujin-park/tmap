<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.secondproject.constant.ContextPath" %>
<div id="header-container">
	<header id="header">
		<h1 id="logo"><a href="<%=ContextPath.root%>/adminIndex.jsp">야진짜</a></h1>
		<ul class="nav-container">
				<li><a href="<%=ContextPath.root%>/admin?act=userview&pg=1&key=&word=&orderValue=asc" class="nav-btn btn-login">회원</a></li>
				<li><a href="<%=ContextPath.root%>/admin?act=ownerview&pg=1key=&word=&orderValue=asc" class="nav-btn btn-login">사장</a></li>
				<li><a href="<%=ContextPath.root%>/admin?act=shopinfo&pg=1&key=&word=&orderValue=" class="nav-btn btn-login">매장</a></li>
				<li><a href="<%=ContextPath.root%>/admin?act=mvreview&board=review&pg=1&key=&word=&orderValue=asc" class="nav-btn btn-login">후기</a></li>
				<li><a href="<%=ContextPath.root%>/chart?act=ageChart" class="nav-btn btn-login">통계</a></li>
				<li><a href="<%=ContextPath.root%>/admin?act=mvexhibition&board=exhibition&pg=1&key=&word=&orderValue=asc" class="nav-btn btn-login">기획전</a></li>
		</ul>
	</header>
</div>
<!-- 
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<%=ContextPath.root%>/adminIndex.jsp">Trust Map</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="<%=ContextPath.root%>/admin?act=userview&pg=1&key=&word=&orderValue=asc">회원관리</a></li>
				<li class="dropdown">
        			<a class="dropdown-toggle" data-toggle="dropdown" href="#">사장관리
        			<span class="caret"></span></a>
			        <ul class="dropdown-menu">
			          <li><a href="<%=ContextPath.root%>/admin?act=ownerview&pg=1&key=&word=&orderValue=">인증 대기리스트</a></li>
			          <li><a href="<%=ContextPath.root%>/admin?act=realownerview&pg=1&key=&word=&orderValue=">사장 리스트</a></li>
			        </ul>
			    </li>
				<li><a href="<%=ContextPath.root%>/admin?act=shopinfo&pg=1&key=&word=&orderValue=">매장관리</a></li>
				<li><a href="<%=ContextPath.root%>/admin?act=mvstats">통계관리</a></li>
				<li><a href="<%=ContextPath.root%>/admin?act=mvreview&board=review&pg=1&key=&word=&orderValue=asc">후기관리</a></li>
				<li class="dropdown">
					<li><a class="dropdown-toggle" data-toggle="dropdown" href="#">기획전관리
	        			<span class="caret"></span></a>
				        	<ul class="dropdown-menu">
					          <li><a href="<%=ContextPath.root%>/admin?act=mvexhibition&board=exhibition&pg=1&key=&word=&orderValue=asc">기획전 리스트</a></li>
					          <li><a href="<%=ContextPath.root%>/admin?act=mvexhibition&board=exhibitionPic&pg=1&key=&word=&orderValue=asc">기획전 배치도</a></li>
				        	</ul>
				</li>
			</ul>
		</div>
	</div>
</nav>
 -->