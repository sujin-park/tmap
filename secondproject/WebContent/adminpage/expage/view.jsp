<%@page import="com.secondproject.admin.model.ExhibitionDetailDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.secondproject.constant.*"%>
<%
	ExhibitionDetailDto exhibitionDetailDto = (ExhibitionDetailDto) request.getAttribute("exhibitionInfo");
%>
<section class="content page-top">
	<div class="title"><h3>Detail</h3></div>
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-body">
					<form id="writeForm" name="writeForm" method="post" action="">
						<div class="form-group">
							<input type="hidden" name="act" value="write">
							<label for="inputName">기획전 이름</label>
							<input type="text" class="form-control" name="subject" value="<%=exhibitionDetailDto.getExTitle()%>">
						</div>
						<div class="ckbox">
						<%
						if (exhibitionDetailDto.getExVisiable() != 0) {
						%>
							<input type="checkbox" id="checkbox1" name="checkbox1" checked="checked"><label for="checkbox1"></label>
						<%
						} else {
						%>
						<input type="checkbox" id="checkbox1" name="checkbox1" checked="checked"><label for="checkbox1"></label>
						<%	
						}
						%>
						</div>
						<label for="inputStore"></label>
						<div class="input-group">
							<input type="text" class="form-control" id="store" name="store" value="<%=exhibitionDetailDto.getShopId()%>">
								<span class="input-group-btn">
									<button class="btn btn-warning" type="button" data-toggle="modal" data-target="#myModal">Search</button>
								</span>
						</div>
						<%@ include file="/adminpage/expage/modal.jsp"%>
						<div class="form-group">
							<label for="inputContent">기획전 설명</label>
							<textarea class="form-control" id="content" name="content" rows="15" cols="15">
<%=exhibitionDetailDto.getExDesc()%>							
</textarea>
						</div>
						<div class="btn-group pull-right">
							<button type="button" class="btn btn-warning" onclick="javascript:writeArticle();">수정</button>
							<button type="button" class="btn btn-default" onclick="javascript:moveList();">취소</button>
						</div>
					</form>
			</div>
		</div>
	</div>
</section>
<script>
function writeArticle() {
	if(document.writeForm.subject.value == "") {
		alert("기획전 제목을 입력해주세요");
	} else if (document.writeForm.store.value == "") {
		alert("매장명을 추가해주세요");
	} else if (document.writeForm.content.value =="") {
		alert("기획전 내용을 입력해주세요");
	} else {
		alert(document.writeForm.subject.value);
		document.writeForm.action = "<%=ContextPath.root%>/exhibition";
		document.writeForm.submit();
	}
}

function moveList() {
	document.location.href = "<%=ContextPath.root%>/admin?act=mvexhibition";	
}

</script>