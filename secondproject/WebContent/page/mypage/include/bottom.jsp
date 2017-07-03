<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" import="com.secondproject.constant.ContextPath"%>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=HI7oAnTDg6I_l3gyYakf&submodules=geocoder"></script>
<script>
var reviewPoint = new naver.maps.LatLng($('#reviewLat').val(), $('#reviewLng').val());

var mapOptions = {
    center: reviewPoint,
    zoom: 10
};

var map = new naver.maps.Map('map', mapOptions);


var HOME_PATH = window.HOME_PATH || '.';
var map = new naver.maps.Map(document.getElementById('map'), {zoom: 11});

map.fitBounds(naver.maps.LatLngBounds.bounds(reviewPoint,
                                             reviewPoint));
                                             
	
var marker = new naver.maps.Marker({
    position: reviewPoint,
    map: map
});

</script>