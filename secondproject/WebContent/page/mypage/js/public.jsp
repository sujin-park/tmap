<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR" import="com.secondproject.util.*,com.secondproject.userdto.*,com.secondproject.constant.ContextPath"%>
<%
String root = ContextPath.root;

int pg = NumberCheck.nullToOne(request.getParameter("pg"));
String key = Encoding.nullToBlank(request.getParameter("key"));
String word = Encoding.isoToUtf(request.getParameter("word"));

UserDto udto = (UserDto) session.getAttribute("logininfo");
%>

<script type="text/javascript">
var pg="<%=pg%>";
var key="<%=key%>";
var word ="<%=word%>";
var root = "<%=root%>";
</script>
<script type="text/javascript" src="<%=root %>/page/mypage/js/my.js"></script>