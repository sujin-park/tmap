<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.secondproject.constant.*, java.util.*"%>
<script>
function moveWrite(){
	document.location.href = "<%=ContextPath.root%>/exhibition?act=mvwrite";
}
function viewExhibition(seq) {
	document.location.href = "<%=ContextPath.root%>/exhibition?act=view&seq="+seq;
}
function searchExhibition() {
	if (document.searchForm.word.value == "")	{
		alert("검색어 입력!!!!!");
	} else {
		document.searchForm.action = "<%=ContextPath.root%>/admin?act=mvexhibition";
		document.searchForm.submit();
	}
		
}

function deleteExhibition(seq) {
	document.location.href ="<%=ContextPath.root%>/exhibition?act=delete&seq=" + seq;
}
</script>
<script type="text/javascript" src="<%=ContextPath.root%>/page/adminpage/js/checkbox.js"></script>