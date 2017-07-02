<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"
	import="com.secondproject.constant.*, java.util.*"%>
<script>
function moveWrite(){
	document.location.href = "<%=ContextPath.root%>/exhibition?act=mvwrite";
}
function viewExhibition(seq) {
	document.location.href = "<%=ContextPath.root%>/exhibition?act=view&seq=" + seq;
}
function searchExhibition() {
	if (document.searchForm.word.value == "")	{
		alert("검색어 입력!!!!!");
	} else {
		document.searchForm.action = "<%=ContextPath.root%>/admin";
		document.searchForm.submit();
	}
		
}

function mvshoplist(seq) {
	document.location.href ="<%=ContextPath.root%>/exhibition?act=mvshoplist&seq=" + seq;
	$('#shopModal').modal({show:true});
}

function deleteExhibition() {
	var valueArr = new Array();
	$("input[name=checkbox]:checked").each(function() {
		valueArr.push($(this).val());
	});
	if (valueArr == "") {
		alert("삭제할 기획전을 선택해주세요");
	} else if (confirm("삭제하시겠습니까?")) {
		document.exhibitionForm.action = "<%=ContextPath.root%>/exhibition";
		document.exhibitionForm.submit();
	}
	
}
</script>
<script type="text/javascript" src="<%=ContextPath.root%>/page/adminpage/js/checkbox.js"></script>