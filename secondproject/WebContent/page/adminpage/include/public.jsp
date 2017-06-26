<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.secondproject.util.*" import="com.secondproject.constant.*"%>
<%
String board = request.getParameter("board"); // 링크가 지워졌을 때, 0 = 게시판 목록같은곳으로 가게끔 하기
int pg = NumberCheck.nullToOne(request.getParameter("pg")); // 페이지는 0번째 페이지가 없기때문에 1로 초기화
String key = Encoding.nullToBlank(request.getParameter("key"));
String word = Encoding.isoToEuc(request.getParameter("word")); // 여기도 한글처리해줘야함
String act = request.getParameter("act");
String root = ContextPath.root;
%>
<script>
var board = "<%=board%>";
var pg = "<%=pg%>";
var key = "<%=key%>";
var word = "<%=word%>";

</script>
<form name="commonForm" method="get" action="">
<input type="hidden" name="act" value=""> <!-- 값들이 항상 바뀌니까 value="" -->
<input type="hidden" name="board" value="">
<input type="hidden" name="pg" value="">
<input type="hidden" name="key" value="">
<input type="hidden" name="word" value="">
</form>
<script type="text/javascript" src="<%=root%>/page/adminpage/js/paging.js"></script>