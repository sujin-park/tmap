function getCategory(number) {
	document.location.href = "/secondproject/chart?act=categoryChart&number="+number;
}
/*
function getCategory(number) {
		$.ajax({
		method: 'get',
		url: '/secondproject/chart',
		data: {
			'act': 'categoryChart',
			'number': number
		},
		dataType: 'json',
		success: function(data) {
			for (var i=0; i<data.length; i++) {
				cateChart.data.labels[i] = data[i].category;
				cateChart.data.datasets[0].data[i] = data[i].categoryCount;
			}
				cateChart.update();
		}
			
	})
}
 */