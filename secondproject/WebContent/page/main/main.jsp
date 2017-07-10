<%@page import="com.secondproject.constant.ContextPath"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"
	import="java.util.*, com.secondproject.admin.model.*, com.secondproject.main.model.*"%>
<%
List<ExhibitionDto> list = (List<ExhibitionDto>) request.getAttribute("mainlist");
List<MainExhibitionDto> shoplist = (List<MainExhibitionDto>) request.getAttribute("mainShoplist");
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
	if (list != null) {
		int size = list.size();
			for(int i=0; i<size; i++) {
				ExhibitionDto exhibitionDto = list.get(i);
				if (exhibitionDto.getExVisiable() != 0) {
				if (i==0) {
%>
<div class="exhibition-container black">
<%
				} else {
%>
<div class="exhibition-container">
<%
				}
%>
	<div class="ex-title"><%=exhibitionDto.getExTitle() %></div>
	<div class="ex-desc"><%=exhibitionDto.getExDesc()%></div>
	<div class="ex-slick-container">
<%
			int shopsize = shoplist.size();
				for(int j=0; j<shopsize; j++) {
					MainExhibitionDto mainExhibitionDto = shoplist.get(j);
						if (mainExhibitionDto.getExhibitionId() == exhibitionDto.getExhibitionId()) {
%>
	
		<a href="<%=ContextPath.root%>/shop?act=view&shopId=<%=mainExhibitionDto.getEx_shopid()%>" class="shop">
			<div class="shop-img">
				<img  data-lazy="<%=ContextPath.root%>/page/main/img/shopimg/<%=mainExhibitionDto.getEx_shopid()%>.jpg" width="300" height="200"/>
				<div class="shop-score"><%=mainExhibitionDto.getScore()%></div>
			</div>
			<div class="shop-content" height="163px">
				<div class="shop-title"><%=mainExhibitionDto.getShop_name()%></div>
				<div class="shop-desc"><%=mainExhibitionDto.getExd_desc()%></div>
				<div class="shop-address"><%=mainExhibitionDto.getAddress()%></div>
			</div>
		</a>

<%
						}
				}
%>
		</div>
	</div>
		<div class="ex-hr"></div>
<%
				}
			}
	}
%>