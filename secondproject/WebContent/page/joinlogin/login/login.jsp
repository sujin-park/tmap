<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<form id="loginform" name="loginform" method="post" action=""> 
	<input type="hidden" name="act" value="login">
		<div class="modal" id="loginmodal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<center><h4 class="modal-title">Login</h4></center>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="inputEmail" class="col-lg-2 control-label">Email</label>
								<input type="text" class="form-control" id="email"
									placeholder="Email">
							<!-- <div class="col-lg-10">
							</div> -->
						</div>
						<div class="form-group">
							<label for="inputPassword" class="col-lg-2 control-label">Password</label>
								<input type="password" class="form-control" id="password"
									placeholder="Password">
							<!-- <div class="col-lg-10">
							</div>  -->
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal" onclick="javascript:joinmove();" align="left">Join</button>
						<button type="button" class="btn btn-primary">Login</button>
					</div>
				</div>
			</div>
		</div>
	</form>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
	<script>
function logincheck(){
	if(document.getElementById("email").value == ""){
		alert("이메일을 입력해주세요.");
		return;
	} else if (document.getElementById("password").value == ""){
		alert("비밀번호를 입력해주세요.");
		return; 
	} else { 
		document.loginform.action = "/secondproject/joinlogin"
		document.loginform.submit();
	}
}
//function joinmove() {
//	document.location.href = "";
//}
</script>