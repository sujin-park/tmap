<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"
	import="com.secondproject.constant.ContextPath,java.util.*,com.secondproject.mypage.model.*"%>
<script type="text/javascript"
	src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=HI7oAnTDg6I_l3gyYakf&submodules=geocoder"></script>
	
<script type="text/javascript">


<% List<MyReviewDto> list = (List<MyReviewDto>) request.getAttribute("reviewlist"); 
if(list!=null) {%>
	var map = new naver.maps.Map('map', {
	    center: new naver.maps.LatLng(<%=list.get(0).getLat()%>, <%=list.get(0).getLng()%>),
	    zoom: 8
	});
	
	<% for(MyReviewDto rdto : list) {%>
	var marker = new naver.maps.Marker({
	    position: 
	    	
	    	new naver.maps.LatLng(<%=rdto.getLat()%>, <%=rdto.getLng()%>),
	    
	    map: map
	});
<%
	}
} else {
%>
<%MyReviewDto mrdto = (MyReviewDto) request.getAttribute("myreview");
if(mrdto!=null) {%>

var map = new naver.maps.Map('map', {
    center: new naver.maps.LatLng(<%=mrdto.getLat()%>, <%=mrdto.getLng()%>),
    zoom: 10
});
var marker = new naver.maps.Marker({
    position: new naver.maps.LatLng(<%=mrdto.getLat()%>, <%=mrdto.getLng()%>),
    
    map: map
});
<%}
}%>
</script>
