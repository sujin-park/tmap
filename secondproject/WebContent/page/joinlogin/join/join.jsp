<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	
<%
	//String root = request.getContextPath();
%>
	<form id="joinform" name="joinform" method="post" action="">
		<input type="hidden" name="act" value="join">
		<div class="modal" id="joinmodal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<center>
							<h4 class="modal-title">Join</h4>
						</center>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="inputEmail" class="col-lg-2 control-label">Email</label>
							<input type="text" class="form-control" id="joinEmail" placeholder="Email" name="email">
							<!-- <div class="col-lg-10">
							</div> -->
						</div>
						<div class="form-group">
							<label for="inputPassword" class="col-lg-2 control-label">Password</label>
							<input type="password" class="form-control" id="joinPassword" name="password"
								placeholder="Password">
							<!-- <div class="col-lg-10">
							</div>  -->
						</div>
						<div class="form-group">
							<label for="inputPassword" class="col-lg-2 control-label">Password Check</label>
							<input type="password" class="form-control"
								id="password_check" placeholder="Password check">
							<!-- <div class="col-lg-10">
							</div>  -->
						</div>
						<div class="form-group">
							<label for="inputEmail" class="col-lg-2 control-label">Age</label>
							<input type="text" class="form-control" id="age" name="age"
								placeholder="age">
							<!-- <div class="col-lg-10">
							</div> -->
						</div>
						<div class="form-group">
							<label for="inputEmail" class="col-lg-2 control-label">Gender</label>
							<input type="text" class="form-control" id="gender" name="gender"
								placeholder="gender">
							<!-- <div class="col-lg-10">
							</div> -->
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="javascript:join();">Join</button>
						<button type="button" class="btn btn-default" onclick="javascript:cancel();">Cencel</button>
					</div>
				</div>
			</div>
		</div>
	</form>
	<script>
function join(){
	if(document.getElementById("joinEmail").value == ""){
		alert("이메일을 입력해주세요.");
	} else if (document.getElementById("joinPassword").value == ""){
		alert("비밀번호를 입력해주세요.");
		return;
	} else if (document.getElementById("joinPassword").value != document.getElementById("password_check").value){
		alert("비밀번호를 확인해주세요.");
		return;
	} else if (document.getElementById("gender").value == ""){
		alert("성별를 입력해주세요.");
		return;
	} else if (document.getElementById("age").value == ""){
		alert("나이를 입력해주세요.");
		return;
	} else { 
		document.joinform.action = "/secondproject/joinlogin"
		document.joinform.submit();
	}
}
function cancel() {
	self.close();
}
	</script>