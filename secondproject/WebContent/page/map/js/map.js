var map = (function() {
	
	var currentPosition;
	var currentPositionMarker;
	var map;
	var mapOptions;
	var currentMarkers = [];
	
	navigator.geolocation.getCurrentPosition(function(pos) {
		initMap(pos.coords.latitude, pos.coords.longitude);
	}, notSupportGPS);
	
	function initMap(lat, lng) {
		setCurrentPosition(lat, lng);
		setMapOptions();
		loadMap();
		makeCurrentPositionMarker();
		console.log(map.getBounds());
	}
	
	function notSupportGPS(err) {
		switch (err.code){
	        case err.PERMISSION_DENIED:
	            msg = "PERMISSION_DENIED";
	        break;
	        case err.PERMISSION_UNAVAILABLE:
	            msg = "PERMISSION_UNAVAILABLE";
	        break;
	        case err.TIMEOUT:
	            msg = "TIMEOUT";
	        break;
	        case err.UNKNOWN_ERROR:
	            msg = "UNKNOWN_ERROR";
	        break;
	    }
		alert("GPS Fail :: " + msg);
	}
	
	function setCurrentPosition(lat, lng) {
		currentPosition = {};
		currentPosition.lat = lat;
		currentPosition.lng = lng;
	}
	
	function setMapOptions() {
		mapOptions = {
			center: new naver.maps.LatLng(currentPosition.lat, currentPosition.lng),
			zoom: 10
		};
	}
	
	function loadMap() {
		map = new naver.maps.Map('map', mapOptions);
	}
	
	function makeCurrentPositionMarker() {
		currentPositionMarker = new naver.maps.Marker({
			position: new naver.maps.LatLng(currentPosition.lat, currentPosition.lng),
			map: map
		});
	}
	
	function makeShopListMarker(shoplist) {
		clearCurrentMarker();
		if (shoplist) {
			shoplist.forEach(function(shop) {
				var lat = shop.lat;
				var lng = shop.lng;
				var marker = new naver.maps.Marker({
					position: new naver.maps.LatLng(lat, lng),
					map: map
				})
				currentMarkers.push(marker);
			});
		}
		console.log(currentMarkers);
	}
	
	function setMarker(bounds) {
		var lat = bounds._min._lat;
		var lng = bounds._min._lng;
		var marker = new naver.maps.Marker({
			position: new naver.maps.LatLng(lat, lng),
			map: map
		})
		
		var lat = bounds._max._lat;
		var lng = bounds._max._lng;
		var marker = new naver.maps.Marker({
			position: new naver.maps.LatLng(lat, lng),
			map: map
		})
	}
	
	function clearCurrentMarker() {
		if (currentMarkers.length > 0) {
			currentMarkers.forEach(function (marker) {
				clearMarker(marker);
			});
			currentMarkers = [];
		}
	}
	
	function clearMarker(marker) {
		marker.setMap(null);
	}
	
	function moveMapToCurrentPosition() {
		map.setCenter(currentPosition);
		map.refresh(true);
	}
	
	function getBounds() {
		return map.getBounds();
	}
	
	return {
		"setMarker" : setMarker,
		"makeShopListMarker" : makeShopListMarker,
		"moveMapToCurrentPosition" : moveMapToCurrentPosition,
		"getBounds" : getBounds
	}
	
})();