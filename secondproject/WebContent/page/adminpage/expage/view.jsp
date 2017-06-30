<%@page import="com.secondproject.admin.model.ExhibitionDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.secondproject.constant.*" import="com.secondproject.shop.model.*, java.util.*"%>
<%
	ExhibitionDto exhibitionDto = (ExhibitionDto) request.getAttribute("exhibitionInfo");
	List<ShopDto> list = (List<ShopDto>) request.getAttribute("shopList");
%>
<script>
function deleteShoplist(exseq ,shopseq) {
			$.get("/secondproject/exhibition?act=deleteShop&exseq="+exseq +"&shopseq=" + shopseq, 
				function(data, status){
				var tt = document.getElementById("exShoplist");
				tt.innerHTML=data;
			});
}

function modifyArticle() {
	if (confirm("수정하시겠습니까?")) {
		document.writeForm.action = "<%=ContextPath.root%>/exhibition";
		document.writeForm.submit();
	}
	
}
function moveList() {
	document.location.href = "<%=ContextPath.root%>/admin?act=mvexhibition";	
}
</script>
<section class="content page-top">
	<div class="title"><h3>Detail</h3></div>
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-body">
					<form id="writeForm" name="writeForm" method="post" action="">
						<div class="form-group">
							<input type="hidden" name="act" value="modify">
							<input type="hidden" name="seq" value="<%=exhibitionDto.getExhibitionId()%>">
							<input type="hidden" name="eximage" value="<%=exhibitionDto.getExImage()%>">
							<label for="inputName">기획전 이름</label>
							<input type="text" class="form-control" name="subject" value="<%=exhibitionDto.getExTitle()%>">
						</div>
						<div class="ckbox">
						<%
						if (exhibitionDto.getExVisiable() != 0) {
						%>
							<input type="checkbox" id="checkbox1" name="isvisiable" checked="checked" value="1"><label for="checkbox1"></label>
						<%
						} else {
						%>
						<input type="checkbox" id="checkbox1" name="isvisiable" value="1"><label for="checkbox1"></label>
						<%	
						}
						%>
						</div>
						<label for="inputStore"></label>
						<div class="input-group">
							<input type="text" class="form-control" id="store" name="store" placeholder="버튼을 눌러 매장을 추가해주세요" readonly="readonly">
								<span class="input-group-btn">
									<button class="btn btn-warning" type="button" onclick="javascript:mvshoplist('<%=exhibitionDto.getExhibitionId()%>');">매장 추가</button>
								</span>
						</div>
					<div class="table-container table-responsive">
					<table class="table table-filter" id="extable">
						<thead>
							<tr class="warning" align="center">
								<td>매장명</td>
								<td>음식종류</td>
								<td>매장 주소</td>
								<td>영업시간</td>
								<td>평점</td>
								<td>상세 설명</td>
								<td>Delete</td>
							</tr>
						</thead>
						<tbody id="exShoplist">
							<%
							if (list != null) {
								int size = list.size();
								for (int i = 0; i < size; i++) {
									ShopDto shopDto = list.get(i);
									String checkbox = "checkbox" + i;
							%>
							<tr>
								
								<td>
									<div class="media">
										<span class="media-meta"><%=shopDto.getTitle() %></span>
									</div>
								</td>
								<td>
									<div class="media">
										<div class="media-body">
											<p class="media-meta"><%=shopDto.getCategoryTitle() %></p>
										</div>
									</div>
								</td>
								<td>
									<div class="media">
										<div class="media-body">
											<span class="media-meta"><%=shopDto.getAddress()%></span>
										</div>
									</div>
								</td>
								<td>
									<div class="media">
										<div class="media-body">
											<span class="media-meta"><%=shopDto.getBusinessTime() %></span>
										</div>
									</div>
								</td>
								<td>
									<div class="media">
										<div class="media-body">
											<span class="media-meta"><%=shopDto.getScore()%></span>
										</div>
									</div>
								</td>
								<td>
									<div class="media">
										<div class="media-body">
											<span class="media-meta"><%=shopDto.getDetail() %></span>
										</div>
									</div>
								</td>
								<td>
								<p data-placement="top" data-toggle="tooltip" title="Delete">
								<button type="button" class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete" onclick="javascript:deleteShoplist(<%=exhibitionDto.getExhibitionId()%>, <%=shopDto.getShopId() %> );" ><span class="glyphicon glyphicon-trash"></span></button></p>
								</td>
							</tr>
							<%
								}
								}
							%>
						</tbody>
					</table>
				</div>
				<div class="col-md-6">
					<img src="<%=ContextPath.root%>/upload/<%=exhibitionDto.getExhibitionId()%>/<%=exhibitionDto.getExImage()%>" width="500" padding="0px"/>
				</div>
				<div class="col-md-6">
						<div class="form-group">
							<label for="inputContent">기획전 설명</label>
							<textarea class="form-control" id="content" name="content" rows="10" cols="10">
<%=exhibitionDto.getExDesc()%>							
</textarea>
						</div>
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
