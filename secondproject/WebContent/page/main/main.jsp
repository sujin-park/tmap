<%@page import="com.secondproject.constant.ContextPath"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"
	import="java.util.*, com.secondproject.main.model.*"%>
<%
List<MainExhibitionDto> list = (List<MainExhibitionDto>) request.getAttribute("mainlist");
if (list != null) {
%>
<div id="main-visual-container">

	<div class="visual-title">
		<span class="sub-title">친구<span>야! 진짜</span> 여기가 맛집이야</span>
		<span class="title">야진짜</span>
	</div>
	
	<div class="visual-imgs">
		<div style="background-image: url(<%=ContextPath.root%>/page/main/img/main_banner_1.png)"></div>
		<div style="background-image: url(<%=ContextPath.root%>/page/main/img/main_banner_2.png)"></div>
		<div style="background-image: url(<%=ContextPath.root%>/page/main/img/main_banner_3.png)"></div>
	</div>
	
</div>


<%
		int size = list.size();
		int code = 0;
		for (int i=0; i<size; i++) {
			MainExhibitionDto mainExhibitionDto = list.get(i);
			if (mainExhibitionDto.getEx_visiable() != 0) {
				if (code != mainExhibitionDto.getExhibitionId()) {
					code = mainExhibitionDto.getExhibitionId();
				
					if (i == 0) {
%>
<div class="exhibition-container black">
<%
					} else {
%>
	<div class="exhibition-container">
<%
			}
%>
		<div class="ex-title"><%=mainExhibitionDto.getEx_title()%></div>
		<div class="ex-desc"><%=mainExhibitionDto.getEx_desc()%></div>
		<div class="ex-slick-container">
<%
				   }
%>
		<a href="#" class="shop">
			<div class="shop-img">
				<img  data-lazy="<%=ContextPath.root%>/page/main/img/shopimg/<%=mainExhibitionDto.getEx_shopid()%>.jpg"
				 width="200" height="200"/>
				<div class="shop-score"><%=mainExhibitionDto.getScore()%></div>
			</div>
			<div class="shop-content">
				<div class="shop-title"><%=mainExhibitionDto.getShop_name()%></div>
				<div class="shop-desc"><%=mainExhibitionDto.getExd_desc()%></div>
				<div class="shop-address"><%=mainExhibitionDto.getAddress()%></div>
			</div>
		</a>
<%
	if(i < size - 1) {
		if(code != list.get(i + 1).getExhibitionId()) {
%>
		</div>

<%
					}
				}
			}
		}
%>
	</div>
</div>
<%
	} else {
%>

<%
	}
%>