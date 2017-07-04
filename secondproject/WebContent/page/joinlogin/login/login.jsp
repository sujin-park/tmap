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
					<center>
						<h4 class="modal-title">Login</h4>
					</center>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="inputEmail" class="col-lg-2 control-label">Email</label>
						<input type="text" class="form-control" id="email" name="email"
							placeholder="Email">
					</div>
					<div class="form-group">
						<label for="inputPassword" class="col-lg-2 control-label">Password</label>
						<input type="password" class="form-control" id="password"
							name="password" placeholder="Password">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal"
						onclick="javascript:joinmove();" align="left">Go Join</button>
					<button type="button" class="btn btn-warning" onclick="javascript:logincheck();">Login</button>
				</div>
			</div>
		</div>
	</div>
</form>