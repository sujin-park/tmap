var pageFunc = (function(){
	
	function showSearchDetail(boolean) {
		boolean ? $('body').addClass('search-detail-active') : $('body').removeClass('search-detail-active');
	}
	
	function getShopList(mapSlick, callbackFunc) {
		var currentBounds = map.getBounds();
		var jsonDataToServer = JSON.stringify(currentBounds);
		
		var followUsersId = [];
		$('.followUsersId:checked').each(function(index, el) {
			followUsersId.push(el.value);
		})
		
		$.ajax({
			method: 'post',
			url: CONTEXT_PATH + '/map',
			data: {
				'act': 'ajaxGetShopList',
				'bounds': jsonDataToServer,
				'categoryId' : $('#search_menu').val() ? $('#search_menu').val() : 0,
				'followUsersId' : followUsersId
			},
			dataType: 'json',
			success: function(data) {
				
				$('.search-list-container-mobile .slick-track').empty();
				$('.search-list-container .search-list').empty();
				
				if (data.length === 0) {
					map.clearMarkers();
					var tag = '<div class="panel panel-default shop">'
						tag += '	<div class="panel-body">이 지역에는 등록된 매장이 없습니다.';
						tag += '	</div>';
						tag += '</div>';
					mapSlick.slick('slickAdd', tag);
					$('.search-list-container .search-list').append(tag);
				} else {
					var i = 1;
					data.forEach(function (shop) {
						var tag = '<div class="panel panel-default shop">'
							tag += '	<a href="' + CONTEXT_PATH + '/shop?act=view&shopId=' + shop.shopId + '" target="_blank"class="panel-body">';
							tag += '		<span class="category label label-default">' + shop.categoryName + '</span>';
							tag += '		<span class="score label label-danger">평점 : ' + shop.score + '</span>';
							tag += '		<span class="category label label-warning">리뷰 ' + shop.reviewCount + '</span>';
							tag += '		<div>';
							tag += '			<span class="rank">' + i + '위</span>';
							tag += '			<span class="title">' + shop.title + '</span>';
							tag += '		</div>';
							tag += '		<span class="address">' + shop.address + '</span>';
							if (shop.followReviewCount != 0) {
								tag += '		<div class="review-count-container">';
								tag += '			<span class="category label label-warning">내 팔로우들의 리뷰 ' + shop.followReviewCount + '</span>';
								tag += '		</div>';
							}
							tag += '	</a>';
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
				$('#search_menu').children().eq(0).prop('selected', true);
				if (callbackFunc) {
					callbackFunc();
				}
			}
		})
	}
	
	
	function getFollows() {
		var currentBounds = map.getBounds();
		var jsonDataToServer = JSON.stringify(currentBounds);
		$('#follow-data-insert').html("Loading..");
		$.ajax({
			method: 'post',
			url: CONTEXT_PATH + '/map',
			data: {
				'act': 'ajaxGetFollows',
				'bounds': jsonDataToServer,
				'categoryId': $('#search_menu').val()
			},
			dataType: 'json',
			success: function(data) {
				setTimeout(function() {
					$('#follow-data-insert').empty();
					data.forEach(function (followGroup) {
						var ableCount = 0;
						var tag = "";
						tag += "<div class=\"panel panel-default favorite-item\">";
						tag += "	<div class=\"panel-heading followGroup" + followGroup.followCategoryId + "\" data-toggle=\"collapse\" data-target=\"#followGroup" + followGroup.followCategoryId + "\" >";
						tag += "		<span class=\"followGroupName\">" + followGroup.categoryName + "</span>";
						tag += "	</div>";
						
						if (followGroup.categoryUserList.length > 0) {
							var followUsers = followGroup.categoryUserList;
							tag += "	<div class=\"collapse panel-collapse\" id=\"followGroup" + followGroup.followCategoryId + "\">";
							tag += "		<ul class=\"list-group\">";
							
							followUsers.forEach(function (user){
								var cnt = user.mapReviewCount;
								var noReivew = (cnt === 0) ? 'noReview' : '';
								tag += "			<li class=\"list-group-item followUser " + noReivew + "\" >";
								tag += "				<label>";
								
								if (cnt > 0) {
									tag += "					<input type=\"checkbox\" class=\"followUsersId\" value=\"" + user.regUserId + "\">";
									ableCount++;
								}
								
								tag += "					<span class=\"userEmail\">" + user.userEmail + "</span>";
								
								if (user.alias) {
									tag += "					<span class=\"alias\">" + user.alias + "</span>";
								}
								
								tag += "				</label>";
								tag += "			</li>";
							})
							
							tag += "		</ul>";
							tag += "	</div>";
						}
						tag += "</div>";
						
						$('#follow-data-insert').append(tag);
						if (ableCount > 0) {
							$('#follow-data-insert .followGroup' + followGroup.followCategoryId).append('&nbsp;<span class="label label-danger">' + ableCount + '</span>');
						}
					})
				}, 500);
			},
			error: function(error) {
				$('#follow-data-insert').html("팔로우는 로그인이 필요한 서비스입니다.");
				//SYSOUT(error);
			},
			complete: function() {
				showSearchDetail(true);
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
		'getFollows' :getFollows,
		'insertAddShopSearchValue' : insertAddShopSearchValue,
		'addShopFormReset' : addShopFormReset,
		'addShop' : addShop
	}
	
})();