var pageFunc = (function(){
	
	function showSearchDetail(boolean) {
		boolean ? $('body').addClass('search-detail-active') : $('body').removeClass('search-detail-active');
	}
	
	function getShopList(mapSlick, callbackFunc) {
		var currentBounds = map.getBounds();
		var jsonDataToServer = JSON.stringify(currentBounds);
		$.ajax({
			method: 'post',
			url: CONTEXT_PATH + '/map',
			data: {
				'act': 'ajaxGetShopList',
				'bounds': jsonDataToServer
			},
			dataType: 'json',
			success: function(data) {
				
				$('.search-list-container-mobile .slick-track').empty();
				$('.search-list-container .search-list').empty();
				
				if (data.length === 0) {
					map.clearMarkers();
					var tag = '<div class="panel panel-default shop">'
						tag += '	<div class="panel-body">이 지역에는 등록된 매장이 없습니다<br>매장을 등록해주시면 추첨을 통해 푸짐한 상품을 드리고 싶네요..';
						tag += '	</div>';
						tag += '</div>';
					mapSlick.slick('slickAdd', tag);
					$('.search-list-container .search-list').append(tag);
				} else {
					var i = 1;
					data.forEach(function (shop) {
						var tag = '<div class="panel panel-default shop">'
							tag += '	<div class="panel-body">';
							tag += '		<a href="' + CONTEXT_PATH + '/shop?shop_id=' + shop.shopId + '" target="_blank">';
							tag += '			<span class="rank">' + i + '위</span>';
							tag += '			<span class="title">' + shop.title + '</span>';
							tag += '			<span class="category">[' + shop.categoryId + ']</span>';
							tag += '			<span class="score">평점 : ' + shop.score + '</span>';
							tag += '			<span class="address">' + shop.address + '</span>';
							tag += '		</a>';
							tag += '	</div>';
							tag += '</div>';
							
						mapSlick.slick('slickAdd', tag);
						$('.search-list-container .search-list').append(tag);
						i++;
					});
					
					map.clearMarkers();
					map.addMarkers(data, function (index) {
						SYSOUT('pageFunc.getShopList() :: index = ' + index);
						mapSlick.slick('slickGoTo', index);
						map.moveMapByMarkerIndex(index);
						$('.search-list-container .search-list .shop').removeClass('on').eq(index).addClass('on');
					});
					map.moveMapByMarkerIndex(0);
					$('.search-list-container .search-list .shop').eq(0).addClass('on');
				}
				
			},
			error: function(error) {
				alert('검색오류');
				SYSOUT(error);
			},
			complete: function() {
				if (callbackFunc) {
					callbackFunc();
				}
			}
		})
	}
	
	function insertAddShopSearchValue() {
		var address = addShopMap.getCurrentAddress();
		var latlng = addShopMap.getCurrentPosition();
		$('#addShopAddress1').val(address);
		$('#addShopAddress2').focus();
		$('#addShopLat').val(latlng._lat);
		$('#addShopLng').val(latlng._lng);
	}
	
	function addShopFormReset() {
		$('#addShopForm')[0].reset();
	}
	
	function addShop() {
		var data = $('#addShopForm').serialize();
		$.ajax({
			method: 'post',
			url: CONTEXT_PATH + '/shop',
			data: data,
			dataType: 'json',
			success: function(data) {
				if (data.isSuccess === 'success') {
					alert('등록되었습니다.');
					addShopFormReset();
					$('#modal_addshopForm .close').click();
				} else if (data.isSuccess === 'fail') {
					alert('등록에 실패했습니다..');
				}
			},
			error: function(error) {
				alert('등록에 실패했습니다.');
				SYSOUT(error);
			}
		})
	}
	
	return {
		'showSearchDetail': showSearchDetail,
		'getShopList': getShopList,
		'insertAddShopSearchValue' : insertAddShopSearchValue,
		'addShopFormReset' : addShopFormReset,
		'addShop' : addShop
	}
	
})();