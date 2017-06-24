function addShopMap () {
	
	var map = new naver.maps.Map("addShopMap", {
		center : new naver.maps.LatLng(37.3595316, 127.1052133),
		zoom : 10,
	});
	
	var infoWindow = new naver.maps.InfoWindow({
		anchorSkew : true
	});
	
	map.setCursor('pointer');
	
	function init() {
		map.addListener('click', function(e) {
			searchCoordinateToAddress(e.coord);
		});
		$('#addShopSearchAddress').on('keydown', function(e) {
			var keyCode = e.which;
			if (keyCode === 13) { // Enter Key
				searchAddressToCoordinate($('#addShopSearchAddress').val());
			}
		});
		$('#addShopSearchSubmit').on('click', function(e) {
			e.preventDefault();
			searchAddressToCoordinate($('#addShopSearchAddress').val());
		});
		searchAddressToCoordinate('정자동 178-1');
	}
	
	function searchCoordinateToAddress(latlng) {
		var tm128 = naver.maps.TransCoord.fromLatLngToTM128(latlng);
		infoWindow.close();
		naver.maps.Service.reverseGeocode({
			location : tm128,
			coordType : naver.maps.Service.CoordType.TM128
		}, function(status, response) {
			if (status === naver.maps.Service.Status.ERROR) {
				return alert('Something Wrong!');
			}
			var items = response.result.items, htmlAddresses = [];
			for (var i = 0, ii = items.length, item, addrType; i < ii; i++) {
				item = items[i];
				if (item.isRoadAddress === false) {
					htmlAddresses.push('<div>' + (i + 1) + ' ' + item.address + '</div>');
				}
			}
			infoWindow.setContent('<div style="padding:10px 15px;">' + htmlAddresses + '<button>이곳이맞나요</button></div>');
			infoWindow.open(map, latlng);
		});
	}
	
	function searchAddressToCoordinate(address) {
		naver.maps.Service.geocode(
			{
				address : address
			},
			function(status, response) {
				if (status === naver.maps.Service.Status.ERROR) {
					return alert('Something Wrong!');
				}
		
				var item = response.result.items[0], addrType = item.isRoadAddress ? '[도로명 주소]'
						: '[지번 주소]', point = new naver.maps.Point(
						item.point.x, item.point.y);
		
				infoWindow
						.setContent([
								'<div style="padding:10px;min-width:200px;line-height:150%;">',
										+ point.y, '</div>' ]
								.join('\n'));
		
				map.setCenter(point);
				infoWindow.open(map, point);
			}
		);
	}
	

	
	return {
		'init' : init,
		'searchCoordinateToAddress' : searchCoordinateToAddress,
		'searchAddressToCoordinate' : searchAddressToCoordinate
	}
}