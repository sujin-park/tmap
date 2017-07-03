<%@page import="com.secondproject.constant.ContextPath"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"
	import="java.util.*, com.secondproject.main.model.*"%>
<%
List<MainExhibitionDto> list = (List<MainExhibitionDto>) request.getAttribute("mainlist");
%>
<div id="main-visual-container">

	<div class="visual-title">
		<span class="sub-title">친구가 추천해준 믿을 수 있는 맛집</span>
		<span class="title">야!진짜</span>
	</div>
	
	<div class="visual-imgs">
		<div style="background-image: url(<%=ContextPath.root%>/page/main/img/main_banner_1.png)"></div>
		<div style="background-image: url(<%=ContextPath.root%>/page/main/img/main_banner_2.png)"></div>
		<div style="background-image: url(<%=ContextPath.root%>/page/main/img/main_banner_3.png)"></div>
	</div>
	
</div>

<div class="exhibition-container black">
<%
	if (list != null) {
		int size = list.size();
		int code = 0;
	for (int i=0; i<size; i++) {
		MainExhibitionDto mainExhibitionDto = list.get(i);
		if (code!= mainExhibitionDto.getExhibitionId()) {
			code = mainExhibitionDto.getExhibitionId();
%>
	<div class="ex-title"><%=mainExhibitionDto.getEx_title()%></div>
	<div class="ex-desc"><%=mainExhibitionDto.getEx_desc()%></div>
	<div class="ex-slick-container">
<%
	}
%>
		<a href="#" class="shop">
			<div class="shop-img">
				<img  data-lazy="<%=ContextPath.root%>/page/main/img/shopimg1.png"/>
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
<div class="exhibition-container">
	<div class="ex-title">캠핑엔 바베큐죠 그쵸</div>
	<div class="ex-desc">#캠핑 #바비큐 #여름휴가 #야외음식 #가족</div>
	
	<div class="ex-slick-container">
		<a href="#" class="shop">
			<div class="shop-img">
				<img  data-lazy="<%=ContextPath.root%>/page/main/img/shopimg1.png"/>
				<div class="shop-score">7.74</div>
			</div>
			<div class="shop-content">
				<div class="shop-title">고스히얼</div>
				<div class="shop-desc">연희동으로 이사온 폴앤폴리나! 연희김밥집보다 좀더 안으로 들어 가다보면 있다.</div>
				<div class="shop-address">경기도 시흥시 정왕동 46-2</div>
			</div>
		</a>
		
		<a href="#" class="shop">
			<div class="shop-img">
				<img  data-lazy="<%=ContextPath.root%>/page/main/img/shopimg1.png"/>
				<div class="shop-score">7.74</div>
			</div>
			<div class="shop-content">
				<div class="shop-title">고스히얼</div>
				<div class="shop-desc">연희동으로 이사온 폴앤폴리나! 연희김밥집보다 좀더 안으로 들어 가다보면 있다.</div>
				<div class="shop-address">경기도 시흥시 정왕동 46-2</div>
			</div>
		</a>
		
		<a href="#" class="shop">
			<div class="shop-img">
				<img  data-lazy="<%=ContextPath.root%>/page/main/img/shopimg1.png"/>
				<div class="shop-score">7.74</div>
			</div>
			<div class="shop-content">
				<div class="shop-title">고스히얼</div>
				<div class="shop-desc">연희동으로 이사온 폴앤폴리나! 연희김밥집보다 좀더 안으로 들어 가다보면 있다.</div>
				<div class="shop-address">경기도 시흥시 정왕동 46-2</div>
			</div>
		</a>
		
		<a href="#" class="shop">
			<div class="shop-img">
				<img  data-lazy="<%=ContextPath.root%>/page/main/img/shopimg1.png"/>
				<div class="shop-score">7.74</div>
			</div>
			<div class="shop-content">
				<div class="shop-title">고스히얼</div>
				<div class="shop-desc">연희동으로 이사온 폴앤폴리나! 연희김밥집보다 좀더 안으로 들어 가다보면 있다.</div>
				<div class="shop-address">경기도 시흥시 정왕동 46-2</div>
			</div>
		</a>
		<a href="#" class="shop">
			<div class="shop-img">
				<img  data-lazy="<%=ContextPath.root%>/page/main/img/shopimg1.png"/>
				<div class="shop-score">7.74</div>
			</div>
			<div class="shop-content">
				<div class="shop-title">고스히얼</div>
				<div class="shop-desc">연희동으로 이사온 폴앤폴리나! 연희김밥집보다 좀더 안으로 들어 가다보면 있다.</div>
				<div class="shop-address">경기도 시흥시 정왕동 46-2</div>
			</div>
		</a>
		
		<a href="#" class="shop">
			<div class="shop-img">
				<img  data-lazy="<%=ContextPath.root%>/page/main/img/shopimg1.png"/>
				<div class="shop-score">7.74</div>
			</div>
			<div class="shop-content">
				<div class="shop-title">고스히얼</div>
				<div class="shop-desc">연희동으로 이사온 폴앤폴리나! 연희김밥집보다 좀더 안으로 들어 가다보면 있다.</div>
				<div class="shop-address">경기도 시흥시 정왕동 46-2</div>
			</div>
		</a>
		
		<a href="#" class="shop">
			<div class="shop-img">
				<img  data-lazy="<%=ContextPath.root%>/page/main/img/shopimg1.png"/>
				<div class="shop-score">7.74</div>
			</div>
			<div class="shop-content">
				<div class="shop-title">고스히얼</div>
				<div class="shop-desc">연희동으로 이사온 폴앤폴리나! 연희김밥집보다 좀더 안으로 들어 가다보면 있다.</div>
				<div class="shop-address">경기도 시흥시 정왕동 46-2</div>
			</div>
		</a>
		
		<a href="#" class="shop">
			<div class="shop-img">
				<img  data-lazy="<%=ContextPath.root%>/page/main/img/shopimg1.png"/>
				<div class="shop-score">7.74</div>
			</div>
			<div class="shop-content">
				<div class="shop-title">고스히얼</div>
				<div class="shop-desc">연희동으로 이사온 폴앤폴리나! 연희김밥집보다 좀더 안으로 들어 가다보면 있다.</div>
				<div class="shop-address">경기도 시흥시 정왕동 46-2</div>
			</div>
		</a>
	</div>
</div>

<div class="ex-hr"></div>

<div class="exhibition-container">
	<div class="ex-title">캠핑엔 바베큐죠 그쵸</div>
	<div class="ex-desc">#캠핑 #바비큐 #여름휴가 #야외음식 #가족</div>
	
	<div class="ex-slick-container">
		<a href="#" class="shop">
			<div class="shop-img">
				<img  data-lazy="<%=ContextPath.root%>/page/main/img/shopimg1.png"/>
				<div class="shop-score">7.74</div>
			</div>
			<div class="shop-content">
				<div class="shop-title">고스히얼</div>
				<div class="shop-desc">연희동으로 이사온 폴앤폴리나! 연희김밥집보다 좀더 안으로 들어 가다보면 있다.</div>
				<div class="shop-address">경기도 시흥시 정왕동 46-2</div>
			</div>
		</a>
		
		<a href="#" class="shop">
			<div class="shop-img">
				<img  data-lazy="<%=ContextPath.root%>/page/main/img/shopimg1.png"/>
				<div class="shop-score">7.74</div>
			</div>
			<div class="shop-content">
				<div class="shop-title">고스히얼</div>
				<div class="shop-desc">연희동으로 이사온 폴앤폴리나! 연희김밥집보다 좀더 안으로 들어 가다보면 있다.</div>
				<div class="shop-address">경기도 시흥시 정왕동 46-2</div>
			</div>
		</a>
		
		<a href="#" class="shop">
			<div class="shop-img">
				<img  data-lazy="<%=ContextPath.root%>/page/main/img/shopimg1.png"/>
				<div class="shop-score">7.74</div>
			</div>
			<div class="shop-content">
				<div class="shop-title">고스히얼</div>
				<div class="shop-desc">연희동으로 이사온 폴앤폴리나! 연희김밥집보다 좀더 안으로 들어 가다보면 있다.</div>
				<div class="shop-address">경기도 시흥시 정왕동 46-2</div>
			</div>
		</a>
		
		<a href="#" class="shop">
			<div class="shop-img">
				<img  data-lazy="<%=ContextPath.root%>/page/main/img/shopimg1.png"/>
				<div class="shop-score">7.74</div>
			</div>
			<div class="shop-content">
				<div class="shop-title">고스히얼</div>
				<div class="shop-desc">연희동으로 이사온 폴앤폴리나! 연희김밥집보다 좀더 안으로 들어 가다보면 있다.</div>
				<div class="shop-address">경기도 시흥시 정왕동 46-2</div>
			</div>
		</a>
		<a href="#" class="shop">
			<div class="shop-img">
				<img  data-lazy="<%=ContextPath.root%>/page/main/img/shopimg1.png"/>
				<div class="shop-score">7.74</div>
			</div>
			<div class="shop-content">
				<div class="shop-title">고스히얼</div>
				<div class="shop-desc">연희동으로 이사온 폴앤폴리나! 연희김밥집보다 좀더 안으로 들어 가다보면 있다.</div>
				<div class="shop-address">경기도 시흥시 정왕동 46-2</div>
			</div>
		</a>
		
		<a href="#" class="shop">
			<div class="shop-img">
				<img  data-lazy="<%=ContextPath.root%>/page/main/img/shopimg1.png"/>
				<div class="shop-score">7.74</div>
			</div>
			<div class="shop-content">
				<div class="shop-title">고스히얼</div>
				<div class="shop-desc">연희동으로 이사온 폴앤폴리나! 연희김밥집보다 좀더 안으로 들어 가다보면 있다.</div>
				<div class="shop-address">경기도 시흥시 정왕동 46-2</div>
			</div>
		</a>
		
		<a href="#" class="shop">
			<div class="shop-img">
				<img  data-lazy="<%=ContextPath.root%>/page/main/img/shopimg1.png"/>
				<div class="shop-score">7.74</div>
			</div>
			<div class="shop-content">
				<div class="shop-title">고스히얼</div>
				<div class="shop-desc">연희동으로 이사온 폴앤폴리나! 연희김밥집보다 좀더 안으로 들어 가다보면 있다.</div>
				<div class="shop-address">경기도 시흥시 정왕동 46-2</div>
			</div>
		</a>
		
		<a href="#" class="shop">
			<div class="shop-img">
				<img  data-lazy="<%=ContextPath.root%>/page/main/img/shopimg1.png"/>
				<div class="shop-score">7.74</div>
			</div>
			<div class="shop-content">
				<div class="shop-title">고스히얼</div>
				<div class="shop-desc">연희동으로 이사온 폴앤폴리나! 연희김밥집보다 좀더 안으로 들어 가다보면 있다.</div>
				<div class="shop-address">경기도 시흥시 정왕동 46-2</div>
			</div>
		</a>
	</div>
</div>