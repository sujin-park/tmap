<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" import="com.secondproject.constant.*, com.secondproject.userdto.UserDto"%>
<%
	UserDto userDto = (UserDto) session.getAttribute("logininfo");
%>
<div id="header-container">
	<header id="header">
		<h1 id="logo"><a href="<%=ContextPath.root%>">¾ß!ÁøÂ¥</a></h1>
		<ul class="nav-container">
			<li><a href="<%=ContextPath.root%>/map" class="nav-btn btn-map"><i class="fa fa-map-marker" aria-hidden="true"></i>MAP</a></li>
			<% if (userDto == null){ %>
				<li><a href="javascript:loginmove();" class="nav-btn btn-login">LOGIN</a></li>
			<% } else { %>
				<li><a href="<%=ContextPath.root%>/myreview?act=myreviewView&pg=1" class="nav-btn btn-login">Review</a></li>
				<li><a href="<%=ContextPath.root%>/mypage?act=followView&pg=1" class="nav-btn btn-login">Follow</a></li>
				<li><a href="javascript:logoutmove();" class="nav-btn btn-login">Logout</a></li>
				<% if(userDto.getType() == 0)  {%>
				<li><a href="javascript:adminmove();" class="nav-btn btn-login">Admin</a></li>
			<%		}
				} %>
		</ul>
	</header>
</div>
<script type="text/javascript">
function adminmove() {
	document.location.href = "<%=ContextPath.root%>/adminIndex.jsp";
}
</script>