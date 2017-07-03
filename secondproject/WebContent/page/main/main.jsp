<%@page import="com.secondproject.constant.ContextPath"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"
	import="java.util.*, com.secondproject.admin.model.*"%>
<%
List<ExhibitionDto> list = (List<ExhibitionDto>) request.getAttribute("exhibitionList");
%>
<div id="main-visual-container">

	<div class="visual-title">
		<span class="sub-title">솔직한 리뷰, 믿을 수 있는 평점!</span>
		<span class="title">Tmap</span>
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
	for (int i=0; i<size; i++) {
		ExhibitionDto exhibitionDto = list.get(i);
%>
<div class="exhibition-container black">
	<div class="ex-title"><%=exhibitionDto.getExTitle()%></div>
	<div class="ex-desc"><%=exhibitionDto.getExDesc()%></div>
	
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
		
	</div>
</div>
<%
	}
}
%>
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