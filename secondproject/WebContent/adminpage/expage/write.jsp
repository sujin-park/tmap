<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.secondproject.constant.*"%>

<section class="content page-top">
		<div class="col-md-10 col-md-push-1">
			<div class="panel panel-default">
				<div class="panel-body">
				<div class="row">
					<form id="writeForm" name="writeForm" method="post" action="">
						<div class="form-group">
							<input type="hidden" name="act" value="write">
							<label for="inputName">기획전 이름</label>
							<input type="text" class="form-control" name="subject" placeholder="기획전 제목을 입력해주세요"/>
						</div>
						<div class="ckbox">
							<input type="checkbox" id="checkbox1" name="checkbox1"> 노출 여부 <label for="checkbox1"></label>
						</div>
						<label for="inputStore">매장명</label>
						<div class="input-group">
							<input type="text" class="form-control" id="store" name="store" placeholder="추가할 매장명을 입력해주세요">
								<span class="input-group-btn">
									<button class="btn btn-warning" type="button" onclick="javascript:mvshoplist();">Search</button>
								</span>
						</div>
						<div class="form-group">
							<label for="inputContent">기획전 설명</label>
							<textarea class="form-control" id="content" name="content" rows="15" cols="15" placeholder="기획전 내용을 입력해주세요"></textarea>
						</div>
						<div class="btn-group pull-right">
							<button type="button" class="btn btn-warning" onclick="javascript:writeArticle();">등록</button>
							<button type="button" class="btn btn-default" onclick="javascript:moveList();">취소</button>
						</div>
					</form>
					</div>
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

function mvshoplist() {
	document.location.href ="<%=ContextPath.root%>/exhibition?act=mvshoplist";
}

</script>