function addMarker(data) {
		if (data.lat && data.lng) {
			var marker = new naver.maps.Marker({
				position: new naver.maps.LatLng(data.lat, data.lng),
				map: map
			});
			markers.push(marker);
		} 
	}