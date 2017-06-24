function addShopMap () {
	
	var map;
	
	var infoWindow = new naver.maps.InfoWindow({
		anchorSkew : true
	});
	
	var currentAddress = '';
	var currentPosition;
	
	
	function init() {
		map = new naver.maps.Map('addShopMap', {
			center : new naver.maps.LatLng(37.3595316, 127.1052133),
			zoom : 10,
		});
		map.setCursor('pointer');
		map.addListener('click', function(e) {
			searchCoordinateToAddress(e.coord);
		});
		
		$('#addShopAddress').on('keydown', function(e) {
			var keyCode = e.which;
			if (keyCode === 13) { // Enter Key
				searchAddressToCoordinate($('#addShopAddress').val());
			}
		});
		
		$('#addShopSearchSubmit').on('click', function(e) {
			e.preventDefault();
			searchAddressToCoordinate($('#addShopAddress').val());
		});
	}
	
	function searchCoordinateToAddress(latlng) {
		var tm128 = naver.maps.TransCoord.fromLatLngToTM128(latlng);
		infoWindow.close();
		naver.maps.Service.reverseGeocode({
			location : tm128,
			coordType : naver.maps.Service.CoordType.TM128
		}, function(status, response) {
			if (status === naver.maps.Service.Status.ERROR) {
				return alert('주소가 검색이 안되네요!');
			}
			var items = response.result.items, htmlAddresses = [];
			
			for (var i = 0, ii = items.length, item, addrType; i < ii; i++) {
				item = items[i];
				if (item.isRoadAddress === false) {
					currentAddress = item.address;
					htmlAddresses.push('<div><input type="hidden" class="address1Value" value="' + item.address + '">' + item.address + '</div>');
					currentPosition = latlng;
					infoWindow.setContent('<div style="padding:10px 15px; text-align:center;">' + htmlAddresses + '<button type="button" class="btn btn-default" style="margin-top:10px;" onclick="pageFunc.insertAddShopSearchValue()">입력!!</button></div>');
					infoWindow.open(map, latlng);
					break;
				}
			}

		});
	}
	
	function searchAddressToCoordinate(address) {
		naver.maps.Service.geocode(
			{
				address : address
			},
			function(status, response) {
				if (status === naver.maps.Service.Status.ERROR) {
					return alert('주소가 검색이 안되네요!');
				}
		
				var items = response.result.items, htmlAddresses = [];
				for (var i = 0, ii = items.length, item, addrType; i < ii; i++) {
					item = items[i];
					if (item.isRoadAddress === false) {
						currentAddress = item.address;
						htmlAddresses.push('<div><input type="hidden" class="address1Value" value="' + item.address + '">' + item.address + '</div>');
						currentPosition = new naver.maps.Point(item.point.x, item.point.y);
						infoWindow.setContent('<div style="padding:10px 15px; text-align:center;">' + htmlAddresses + '<button type="button" class="btn btn-default" style="margin-top:10px;" onclick="pageFunc.insertAddShopSearchValue()">입력!!</button></div>');
						infoWindow.open(map, currentPosition);
						map.setCenter(currentPosition);
						break;
					}
				}

			}
		);
	}
	
	function getCurrentAddress() {
		return currentAddress;
	}
	
	function getCurrentPosition() {
		return currentPosition;
	}
	
	return {
		'init' : init,
		'searchCoordinateToAddress' : searchCoordinateToAddress,
		'searchAddressToCoordinate' : searchAddressToCoordinate,
		'getCurrentAddress' : getCurrentAddress,
		'getCurrentPosition' : getCurrentPosition
	}
}