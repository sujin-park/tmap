function getArea(num) {
	console.log(num);
	document.location.href = "/secondproject/chart?act=areaChart&num="+num;
}

function getAjaxArea(num) {
	$.ajax({
		method: 'get',
		url: '/secondproject/chart',
		data: {
			'act': 'areaAjax',
			'num': num
		},
		dataType: 'json',
		success: function(data) {
			for (var i=0; i<data.length; i++) {
				console.log(data);
				areaChart.data.labels[i] = data[i].area;
				areaChart.data.datasets[0].data[i] = data[i].areaCount;
			}
				areaChart.update();
		}
			
	})
}