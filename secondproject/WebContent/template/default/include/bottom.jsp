<%@page import="com.secondproject.constant.ContextPath"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<script src="https://code.jquery.com/jquery-3.2.1.js" integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE=" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="<%=ContextPath.root%>/template/default/js/common.js?root=<%=ContextPath.root%>"></script>

<!-- 로그인 회원가입 모달창 띄우기 script -->
<script> 
function loginmove() {
	$("#loginmodal").modal("show");
}
function joinmove() {
	$("#joinmodal").modal("show");
}
function logoutmove() {
	document.location.href = "<%=ContextPath.root%>/joinlogin?act=logout";
}
</script>