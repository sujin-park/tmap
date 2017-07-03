<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=HI7oAnTDg6I_l3gyYakf&callback=initMap"></script>
<script type="text/javascript">
var oMap = null; 
var oPoint = new nhn.api.map.LatLng(126.8716174, 37.5274949);
nhn.api.map.setDefaultPoint('LatLng'); 
function initMap() {
oMap = new nhn.api.map.Map('adminMap' ,{ 
point : oPoint, 
zoom : 10, 
enableWheelZoom : true, 
enableDragPan : true, 
enableDblClickZoom : false, 
mapMode : 0, 
activateTrafficMap : false, 
activateBicycleMap : false, 
minMaxLevel : [ 1, 14 ], 
}); 
}
//지도에 이름, 마커명 추가하는 스크립트 시작
var oSize = new nhn.api.map.Size(28, 37); 
var oOffset = new nhn.api.map.Size(14, 37); 
var oIcon = new nhn.api.map.Icon('http://static.naver.com/maps2/icons/pin_spot2.png', oSize, oOffset); 

var oMarker = new nhn.api.map.Marker(oIcon, { title : '(주)글로리바이오텍 ' }); //마커명 넣어주세요. 
oMarker.setPoint(oPoint); //마커의 좌표를 oPoint 에 저장된 좌표로 지정한다 

oMap.addOverlay(oMarker); //마커를 네이버 지도위에 표시한다 .

var oLabel = new nhn.api.map.MarkerLabel(); // 마커 라벨를 선언한다. 
oMap.addOverlay(oLabel); // - 마커의 라벨을 지도에 추가한다. 
oLabel.setVisible(true, oMarker); // 마커의 라벨을 보이게 설정한다. 
</script>
</head>
<body>
		<div class="col-md-offset-3" id="adminMap" style="width: 50%; height: 400px;"></div>
</body>
</html>