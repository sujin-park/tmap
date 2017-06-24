<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	
<div class="pgnav">
	<ul class="pagination">
		
		<li><a href="#" aria-label="Previous"> 
		<span aria-hidden="true"><font color="#ec9a25">√÷Ω≈</font></span>
		</a></li>
		<li><a href="#" aria-label="Previous"> 
		<span aria-hidden="true"><font color="#ec9a25">&laquo;</font></span>
		</a></li>
		<%
			int count = 11;
			for (int i = 1; i < count; i++) {
		%>
		<li><a href="#" class="color-orange"><%=i%></a></li>
		<%
			}
		%>
		<li><a href="#" aria-label="Next"> <span aria-hidden="true">
		<font color="#ec9a25">&raquo;</font></span>
		</a></li>
		<li><a href="#" aria-label="Next"> 
		<span aria-hidden="true"><font color="#ec9a25">≥°</font></span>
		</a></li>
	</ul>
</div>