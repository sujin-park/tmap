$("#search_modal_open").on("click", function() {
	$('.modal').modal('show');
});

$("#search_submit").on("click", function() {
	var currentBounds = map.getBounds();
	var search_menu = $("#search_menu").val();
	var search_orderby = $("#search_orderby").val();
	var search_where = $("#search_where").val();
	
	$.ajax({
		method: "get",
		url: "/secondproject/map",
		data: {
			"act": "ajaxGetShopList"
		},
		dataType: "json",
		success: function(data) {
			if (data === null) {
				alert("no DATA");
			}
			if (search_where === "myposition") {
				map.moveMapToCurrentPosition();
			}

			map.makeShopListMarker(data);
		}
	})
	
	$('.modal').modal('hide');
});

$("#test").on("click", function () {
	var currentBounds = map.getBounds();
	var jsonDataToServer = JSON.stringify(currentBounds);
	console.log("currentBounds");
	console.log(currentBounds);
	console.log("jsonDataToServer");
	console.log(jsonDataToServer);
	$.ajax({
		method: "get",
		url: "/secondproject/map",
		data: {
			"act": "ajaxGetShopList",
			"minLat" : currentBounds._min._lat,
			"minLng" : currentBounds._min._lng,
			"maxLat" : currentBounds._max._lat,
			"maxLng" : currentBounds._max._lng,
			"bounds" : jsonDataToServer
		},
		dataType: "json",
		success: function(data) {
			if (data === null) {
				alert("no DATA");
			}
			console.log("ajaxData");
			console.log(data);
		}
	})
	//map.setMarker(currentBounds);
});

