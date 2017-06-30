<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.secondproject.constant.ContextPath" %>
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
				<li><a href="<%=ContextPath.root%>/admin?act=userview">회원관리</a></li>
				<li class="dropdown">
        			<a class="dropdown-toggle" data-toggle="dropdown" href="#">사장관리
        			<span class="caret"></span></a>
			        <ul class="dropdown-menu">
			          <li><a href="<%=ContextPath.root%>/admin?act=ownerview">인증 대기리스트</a></li>
			          <li><a href="<%=ContextPath.root%>/admin?act=realownerview">사장 리스트</a></li>
			        </ul>
			    </li>
				<li><a href="<%=ContextPath.root%>/admin?act=shopinfo">매장관리</a></li>
				<li><a href="#">통계관리</a></li>
				<li><a href="<%=ContextPath.root%>/admin?act=mvreview&board=review&pg=1&key=&word=">후기관리</a></li>
				<li class="dropdown">
					<li><a class="dropdown-toggle" data-toggle="dropdown" href="#">기획전관리
	        			<span class="caret"></span></a>
				        	<ul class="dropdown-menu">
					          <li><a href="<%=ContextPath.root%>/admin?act=mvexhibition&board=exhibition&pg=1&key=&word=">기획전 리스트</a></li>
					          <li><a href="<%=ContextPath.root%>/admin?act=mvexhibition&board=exhibitionPic&pg=1&key=&word=">기획전 배치도</a></li>
				        	</ul>
				</li>
			</ul>
		</div>
	</div>
</nav>