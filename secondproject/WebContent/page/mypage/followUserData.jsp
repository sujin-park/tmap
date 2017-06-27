<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	import="com.secondproject.mypage.model.*,java.util.*"%>

<%
FollowUserDto udto = (FollowUserDto)request.getAttribute("fudata");
%>

<input type="hidden" name="act" value=""> 
<input type="hidden" id="<%=udto.getUserId()%>" name="userid" value="<%=udto.getUserId()%>">
<input type="hidden" name="alias" value="">
<input type="hidden" name="memo" value="">

						<div class="form-group">
							<label for="alias" class="col-lg-2 control-label">alias</label>
								<input type="text" class="form-control" id="alias" name="alias"
									value="<%=udto.getAlias() %>" placeholder="alias">
						</div>
						<div class="form-group">
							<label for="memo" class="col-lg-2 control-label">memo</label>
								<textarea rows="" cols="" class="form-control" id="memo" name="memo"><%=udto.getMemo() %></textarea>
						</div>