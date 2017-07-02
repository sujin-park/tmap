<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" import="com.secondproject.constant.ContextPath"%>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=HI7oAnTDg6I_l3gyYakf&callback=initMap"></script>
<script type="text/javascript" src="<%=ContextPath.root%>/page/adminpage/js/map.js"></script>
<script type="text/javascript">
    var map = null;
    function initMap() {
    	var shopPoint = new naver.maps.LatLng($('#shoplat').val(), $('#shoplng').val());
    	if ($('#shoplat').val() == "" || $('#shoplat').val() == null) {
    		return false;
    	}
        map = new naver.maps.Map('map', {
            center: shopPoint,
            zoom: 10,
            scaleControl: false,
            logoControl: true,
            mapDataControl: true,
            zoomControl: true,
            minZoom: 1
        });

        var marker = new naver.maps.Marker({
            position: shopPoint,
            map: map
        });
    }
</script>