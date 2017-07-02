<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" import="com.secondproject.constant.ContextPath"%>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=HI7oAnTDg6I_l3gyYakf&submodules=geocoder"></script>
<script>
var mapOptions = {
    center: new naver.maps.LatLng(37.3595704, 127.105399),
    zoom: 10
};

var map = new naver.maps.Map('map', mapOptions);

var HOME_PATH = window.HOME_PATH || '.';
var map = new naver.maps.Map(document.getElementById('map'), {zoom: 11});

map.fitBounds(naver.maps.LatLngBounds.bounds(new naver.maps.LatLng(37.3724620, 127.1051714),
                                             new naver.maps.LatLng(37.3542795, 127.1174332)));

var urlMarker = new naver.maps.Marker({
    position: new naver.maps.LatLng(37.3542795, 127.1072556),
    map: map,
    title: 'urlMarker',
    icon: HOME_PATH +"/img/example/pin_default.png",
    animation: naver.maps.Animation.DROP
});

naver.maps.Event.addListener(urlMarker, 'click', function() {
    if (urlMarker.getAnimation() !== null) {
        urlMarker.setAnimation(null);
    } else {
        urlMarker.setAnimation(naver.maps.Animation.BOUNCE);
    }
});

var imageMarker = new naver.maps.Marker({
    position: new naver.maps.LatLng(37.3637770, 127.1174332),
    map: map,
    title: 'imageMarker',
    icon: HOME_PATH +"/img/example/pin_default.png",
    animation: naver.maps.Animation.DROP
});

</script>