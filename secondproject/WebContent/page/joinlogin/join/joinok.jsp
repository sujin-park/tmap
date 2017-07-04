<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.secondproject.userdto.UserDto"%>
    <%
    
	//UserDto userDto = (UserDto) request.getAttribute("userinfo");
    //if(userDto != null) {
    %>
	<div class="modal" id="joinokmodal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<center>
						<h4 class="modal-title">Join Success</h4>
					</center>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<center>
						<label for="inputEmail" class="col-lg-2 control-label"><font color="blue"></font>님 인증이 성공적으로 완료되었습니다.<br>
						회원가입을 축하합니다. 로그인하시면 서비스를 이용하실 수 있습니다.
						</label>
						</center>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal"
						onclick="javascript:loginmove();">Go Login</button>
					<button type="button" class="btn btn-default"
						onclick="javascript:cancel();">Cancel</button>
				</div>
			</div>
		</div>
	</div>
	
<script> 
function loginmove() {
	$("#loginmodal").modal("show");
}
</script>
<!--  
<script>
alert("부적절한 접근입니다.");
document.location.href ="/index.jsp";
</script>
-->