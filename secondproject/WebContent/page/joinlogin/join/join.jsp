<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<form id="joinform" name="joinform" method="post" action="">
	<input type="hidden" name="act" value="attest">
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
						<input type="email" class="form-control" id="joinEmail"
							placeholder="Email" name="email" onkeyup="javascript:idcheck();">
						<div id="idresult"></div>
					</div>
					<div class="form-group">
						<label for="inputPassword" class="col-lg-2 control-label">Password</label>
						<input type="password" class="form-control" id="joinPassword"
							name="password" placeholder="Password">
					</div>
					<div class="form-group">
						<label for="inputPassword" class="col-lg-2 control-label">Password
							Check</label> <input type="password" class="form-control"
							id="password_check" placeholder="Password check" onkeyup="javascript:pwcheck();">
						<div id="pw_check"></div>
					</div>
					<div class="form-group">
						<label for="inputAge" class="col-lg-2 control-label"><h4>Age</h4></label>
						<div class="col-xs-3">
							<input type="text" class="form-control" placeholder="Age"
								id="age" name="age">
						</div>
						<label for="inputGender" class="col-lg-2 control-label"><h4>Gender</h4></label>
						<div class="btn-group">
							<select class="form-control" id="gender" name="gender">
								<option>Gender</option>
								<option value="1">Male</option>
								<option value="2">Female</option>
							</select>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<!-- <center>
					아래 버튼을 클릭시 입력하신 Email 주소로 mail이 발송됩니다.<br>
					</center>  -->
					<button type="button" class="btn btn-warning" data-dismiss="modal"
						onclick="javascript:attest();">Join</button>
					<button type="button" class="btn btn-default"
						onclick="">Cancel</button>
				</div>
			</div>
		</div>
	</div>
</form>