<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*,com.secondproject.mypage.model.*, com.secondproject.constant.ContextPath,com.secondproject.userdto.*"%>
<% List<ReviewCommentDto>  clist =(List<ReviewCommentDto>) request.getAttribute("clist"); 
MyReviewDto mrdto = (MyReviewDto) request.getAttribute("myreview");%>
<%UserDto udto = (UserDto)session.getAttribute("logininfo"); %>
<script type="text/javascript">

</script><div id="co" class="co">´ñ±Û(<%=clist.size() %>)</div>
			
		
		
			
			<div id="com" class="com" style="">
			<form method="post" action="" id="commentform" name="commentform">
			<input type="hidden" id="reviewId" name="reviewId" value="<%=mrdto.getReviewId()%>">
			<input type="hidden" name="act" value="commentinsert">
				<table style="margin-bottom: 100px;">
			
	
	
					<%	for(ReviewCommentDto cdto : clist) {
					
					%>
					<tr>
						<td width="10%" align="center" style="text-align: center;padding-bottom: 5px; padding-right: 5px;"><%=cdto.getEmail() %></td>
						<td colspan="2" width="90%">&nbsp;<%=cdto.getReviewContent() %></td>
					</tr>
						<% 
				}
				%>
					<tr>
						<td width="10%" align="center" style="text-align: center;"><%=udto.getEmail() %>
						<td width="80%"><textarea id="commenttext" rows="3" cols="130" ></textarea></td>	
						<td width="10%"><a href="javascript:com();" class="btnbtn" >ÀÔ·Â</a></td>
					</tr>
				</table>
				</form>
			</div>