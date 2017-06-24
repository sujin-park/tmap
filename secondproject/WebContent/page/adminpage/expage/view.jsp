<%@page import="com.secondproject.admin.model.ExhibitionDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.secondproject.constant.*"%>
<%
	ExhibitionDto exhibitionDto = (ExhibitionDto) request.getAttribute("exhibitionInfo");
%>
<section class="content page-top">
	<div class="title"><h3>Detail</h3></div>
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-body">
					<form id="writeForm" name="writeForm" method="post" action="">
						<div class="form-group">
							<input type="hidden" name="act" value="modify">
							<input type="hidden" name="seq" value="<%=exhibitionDto.getExhibitionId()%>">
							<label for="inputName">기획전 이름</label>
							<input type="text" class="form-control" name="subject" value="<%=exhibitionDto.getExTitle()%>">
						</div>
						<div class="ckbox">
						<%
						if (exhibitionDto.getExVisiable() != 0) {
						%>
							<input type="checkbox" id="checkbox1" name="checkbox1" checked="checked" value="1"><label for="checkbox1"></label>
						<%
						} else {
						%>
						<input type="checkbox" id="checkbox1" name="checkbox1"><label for="checkbox1"></label>
						<%	
						}
						%>
						</div>
						<label for="inputStore"></label>
						<div class="input-group">
							<input type="text" class="form-control" id="store" name="store" value="<%=exhibitionDto.getExImage()%>">
								<span class="input-group-btn">
									<button class="btn btn-warning" type="button" onclick="javascript:mvshoplist('<%=exhibitionDto.getExhibitionId()%>');">매장 추가</button>
								</span>
						</div>
						<div class="form-group">
							<label for="inputContent">기획전 설명</label>
							<textarea class="form-control" id="content" name="content" rows="15" cols="15">
<%=exhibitionDto.getExDesc()%>							
</textarea>
						</div>
						<div class="btn-group pull-right">
							<button type="button" class="btn btn-warning" onclick="javascript:modifyArticle();">수정</button>
							<button type="button" class="btn btn-default" onclick="javascript:moveList();">취소</button>
						</div>
					</form>
			</div>
		</div>
	</div>
</section>
<script>
function modifyArticle() {
	document.writeForm.action = "<%=ContextPath.root%>/exhibition";
	document.writeForm.submit();
}
function moveList() {
	document.location.href = "<%=ContextPath.root%>/admin?act=mvexhibition";	
}
</script>